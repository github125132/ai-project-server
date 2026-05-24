package cn.iocoder.yudao.module.gap.controller.admin.soil;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.soil.GapBaseSoilDO;
import cn.iocoder.yudao.module.gap.service.soil.GapBaseSoilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP BaseSoil")
@RestController
@RequestMapping("/gap/base-soil")
@Validated
public class GapBaseSoilController {

    @Resource
    private GapBaseSoilService BaseSoilService;

    @PostMapping("/create")
    @Operation(summary = "创建BaseSoil")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:create')")
    public CommonResult<Long> createGapBaseSoil(@Valid @RequestBody GapBaseSoilSaveReqVO createReqVO) {
        return success(BaseSoilService.createGapBaseSoil(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新BaseSoil")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:update')")
    public CommonResult<Boolean> updateGapBaseSoil(@Valid @RequestBody GapBaseSoilSaveReqVO updateReqVO) {
        BaseSoilService.updateGapBaseSoil(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除BaseSoil")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-soil:delete')")
    public CommonResult<Boolean> deleteGapBaseSoil(@RequestParam("id") Long id) {
        BaseSoilService.deleteGapBaseSoil(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得BaseSoil")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:query')")
    public CommonResult<GapBaseSoilRespVO> getGapBaseSoil(@RequestParam("id") Long id) {
        GapBaseSoilDO entity = BaseSoilService.getGapBaseSoil(id);
        return success(BeanUtils.toBean(entity, GapBaseSoilRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得BaseSoil分页")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:query')")
    public CommonResult<PageResult<GapBaseSoilRespVO>> getGapBaseSoilPage(@Valid GapBaseSoilPageReqVO pageReqVO) {
        PageResult<GapBaseSoilDO> pageResult = BaseSoilService.getGapBaseSoilPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseSoilRespVO.class));
    }
}
