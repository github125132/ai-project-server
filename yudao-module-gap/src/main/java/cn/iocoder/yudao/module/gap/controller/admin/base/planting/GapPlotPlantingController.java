package cn.iocoder.yudao.module.gap.controller.admin.base.planting;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.planting.GapPlotPlantingDO;
import cn.iocoder.yudao.module.gap.service.base.planting.GapPlotPlantingService;
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

@Tag(name = "管理后台 - GAP 地块种植历史")
@RestController
@RequestMapping("/gap/plot-planting")
@Validated
public class GapPlotPlantingController {

    @Resource
    private GapPlotPlantingService plantingService;

    @PostMapping("/create")
    @Operation(summary = "创建种植历史")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:create')")
    public CommonResult<Long> createPlanting(@Valid @RequestBody GapPlotPlantingSaveReqVO createReqVO) {
        return success(plantingService.createPlanting(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新种植历史")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:update')")
    public CommonResult<Boolean> updatePlanting(@Valid @RequestBody GapPlotPlantingSaveReqVO updateReqVO) {
        plantingService.updatePlanting(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除种植历史")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:delete')")
    public CommonResult<Boolean> deletePlanting(@RequestParam("id") Long id) {
        plantingService.deletePlanting(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得种植历史")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:query')")
    public CommonResult<GapPlotPlantingRespVO> getPlanting(@RequestParam("id") Long id) {
        GapPlotPlantingDO planting = plantingService.getPlanting(id);
        return success(BeanUtils.toBean(planting, GapPlotPlantingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得种植历史分页")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:query')")
    public CommonResult<PageResult<GapPlotPlantingRespVO>> getPlantingPage(@Valid GapPlotPlantingPageReqVO pageReqVO) {
        PageResult<GapPlotPlantingDO> pageResult = plantingService.getPlantingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPlotPlantingRespVO.class));
    }

    @GetMapping("/list-by-plot")
    @Operation(summary = "根据地块获得种植历史列表")
    @Parameter(name = "plotId", description = "地块编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:query')")
    public CommonResult<List<GapPlotPlantingRespVO>> getPlantingListByPlotId(@RequestParam("plotId") Long plotId) {
        List<GapPlotPlantingDO> list = plantingService.getPlantingListByPlotId(plotId);
        return success(BeanUtils.toBean(list, GapPlotPlantingRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得种植历史列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:query')")
    public CommonResult<List<GapPlotPlantingRespVO>> getPlantingListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapPlotPlantingDO> list = plantingService.getPlantingListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapPlotPlantingRespVO.class));
    }

}
