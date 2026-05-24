package cn.iocoder.yudao.module.gap.controller.admin.planting;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.planting.GapPlotPlantingDO;
import cn.iocoder.yudao.module.gap.service.planting.GapPlotPlantingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP PlotPlanting")
@RestController
@RequestMapping("/gap/plot-planting")
@Validated
public class GapPlotPlantingController {

    @Resource
    private GapPlotPlantingService PlotPlantingService;

    @PostMapping("/create")
    @Operation(summary = "创建PlotPlanting")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:create')")
    public CommonResult<Long> createGapPlotPlanting(@Valid @RequestBody GapPlotPlantingSaveReqVO createReqVO) {
        return success(PlotPlantingService.createGapPlotPlanting(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新PlotPlanting")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:update')")
    public CommonResult<Boolean> updateGapPlotPlanting(@Valid @RequestBody GapPlotPlantingSaveReqVO updateReqVO) {
        PlotPlantingService.updateGapPlotPlanting(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除PlotPlanting")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:delete')")
    public CommonResult<Boolean> deleteGapPlotPlanting(@RequestParam("id") Long id) {
        PlotPlantingService.deleteGapPlotPlanting(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得PlotPlanting")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:query')")
    public CommonResult<GapPlotPlantingRespVO> getGapPlotPlanting(@RequestParam("id") Long id) {
        GapPlotPlantingDO entity = PlotPlantingService.getGapPlotPlanting(id);
        return success(BeanUtils.toBean(entity, GapPlotPlantingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得PlotPlanting分页")
    @PreAuthorize("@ss.hasPermission('gap:plot-planting:query')")
    public CommonResult<PageResult<GapPlotPlantingRespVO>> getGapPlotPlantingPage(@Valid GapPlotPlantingPageReqVO pageReqVO) {
        PageResult<GapPlotPlantingDO> pageResult = PlotPlantingService.getGapPlotPlantingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPlotPlantingRespVO.class));
    }
}
