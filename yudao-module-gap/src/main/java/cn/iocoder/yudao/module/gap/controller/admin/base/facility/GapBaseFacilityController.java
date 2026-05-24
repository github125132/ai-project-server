package cn.iocoder.yudao.module.gap.controller.admin.base.facility;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilityRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilitySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.facility.GapBaseFacilityDO;
import cn.iocoder.yudao.module.gap.service.base.facility.GapBaseFacilityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP 基地设施设备")
@RestController
@RequestMapping("/gap/base-facility")
@Validated
public class GapBaseFacilityController {

    @Resource
    private GapBaseFacilityService facilityService;

    @PostMapping("/create")
    @Operation(summary = "创建设施设备")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:create')")
    public CommonResult<Long> createFacility(@Valid @RequestBody GapBaseFacilitySaveReqVO createReqVO) {
        return success(facilityService.createFacility(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新设施设备")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:update')")
    public CommonResult<Boolean> updateFacility(@Valid @RequestBody GapBaseFacilitySaveReqVO updateReqVO) {
        facilityService.updateFacility(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除设施设备")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-facility:delete')")
    public CommonResult<Boolean> deleteFacility(@RequestParam("id") Long id) {
        facilityService.deleteFacility(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得设施设备")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:query')")
    public CommonResult<GapBaseFacilityRespVO> getFacility(@RequestParam("id") Long id) {
        GapBaseFacilityDO facility = facilityService.getFacility(id);
        return success(BeanUtils.toBean(facility, GapBaseFacilityRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得设施设备分页")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:query')")
    public CommonResult<PageResult<GapBaseFacilityRespVO>> getFacilityPage(@Valid GapBaseFacilityPageReqVO pageReqVO) {
        PageResult<GapBaseFacilityDO> pageResult = facilityService.getFacilityPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseFacilityRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得设施设备列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:base-facility:query')")
    public CommonResult<List<GapBaseFacilityRespVO>> getFacilityListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapBaseFacilityDO> list = facilityService.getFacilityListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapBaseFacilityRespVO.class));
    }

}
