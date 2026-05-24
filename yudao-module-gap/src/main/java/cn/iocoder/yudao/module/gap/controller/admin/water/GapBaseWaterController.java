package cn.iocoder.yudao.module.gap.controller.admin.water;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.water.GapBaseWaterDO;
import cn.iocoder.yudao.module.gap.service.water.GapBaseWaterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP BaseWater")
@RestController
@RequestMapping("/gap/base-water")
@Validated
public class GapBaseWaterController {

    @Resource
    private GapBaseWaterService BaseWaterService;

    @PostMapping("/create")
    @Operation(summary = "创建BaseWater")
    @PreAuthorize("@ss.hasPermission('gap:base-water:create')")
    public CommonResult<Long> createGapBaseWater(@Valid @RequestBody GapBaseWaterSaveReqVO createReqVO) {
        return success(BaseWaterService.createGapBaseWater(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新BaseWater")
    @PreAuthorize("@ss.hasPermission('gap:base-water:update')")
    public CommonResult<Boolean> updateGapBaseWater(@Valid @RequestBody GapBaseWaterSaveReqVO updateReqVO) {
        BaseWaterService.updateGapBaseWater(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除BaseWater")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-water:delete')")
    public CommonResult<Boolean> deleteGapBaseWater(@RequestParam("id") Long id) {
        BaseWaterService.deleteGapBaseWater(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得BaseWater")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-water:query')")
    public CommonResult<GapBaseWaterRespVO> getGapBaseWater(@RequestParam("id") Long id) {
        GapBaseWaterDO entity = BaseWaterService.getGapBaseWater(id);
        return success(BeanUtils.toBean(entity, GapBaseWaterRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得BaseWater分页")
    @PreAuthorize("@ss.hasPermission('gap:base-water:query')")
    public CommonResult<PageResult<GapBaseWaterRespVO>> getGapBaseWaterPage(@Valid GapBaseWaterPageReqVO pageReqVO) {
        PageResult<GapBaseWaterDO> pageResult = BaseWaterService.getGapBaseWaterPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseWaterRespVO.class));
    }
}
