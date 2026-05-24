package cn.iocoder.yudao.module.gap.controller.admin.facility;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilityRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilitySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.facility.GapBaseFacilityDO;
import cn.iocoder.yudao.module.gap.service.facility.GapBaseFacilityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP BaseFacility")
@RestController
@RequestMapping("/gap/base-facility")
@Validated
public class GapBaseFacilityController {

    @Resource
    private GapBaseFacilityService BaseFacilityService;

    @PostMapping("/create")
    @Operation(summary = "创建BaseFacility")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:create')")
    public CommonResult<Long> createGapBaseFacility(@Valid @RequestBody GapBaseFacilitySaveReqVO createReqVO) {
        return success(BaseFacilityService.createGapBaseFacility(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新BaseFacility")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:update')")
    public CommonResult<Boolean> updateGapBaseFacility(@Valid @RequestBody GapBaseFacilitySaveReqVO updateReqVO) {
        BaseFacilityService.updateGapBaseFacility(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除BaseFacility")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-facility:delete')")
    public CommonResult<Boolean> deleteGapBaseFacility(@RequestParam("id") Long id) {
        BaseFacilityService.deleteGapBaseFacility(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得BaseFacility")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:query')")
    public CommonResult<GapBaseFacilityRespVO> getGapBaseFacility(@RequestParam("id") Long id) {
        GapBaseFacilityDO entity = BaseFacilityService.getGapBaseFacility(id);
        return success(BeanUtils.toBean(entity, GapBaseFacilityRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得BaseFacility分页")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:query')")
    public CommonResult<PageResult<GapBaseFacilityRespVO>> getGapBaseFacilityPage(@Valid GapBaseFacilityPageReqVO pageReqVO) {
        PageResult<GapBaseFacilityDO> pageResult = BaseFacilityService.getGapBaseFacilityPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseFacilityRespVO.class));
    }
}
