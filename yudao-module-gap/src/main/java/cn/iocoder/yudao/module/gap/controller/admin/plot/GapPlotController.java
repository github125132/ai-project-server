package cn.iocoder.yudao.module.gap.controller.admin.plot;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.plot.GapPlotDO;
import cn.iocoder.yudao.module.gap.service.plot.GapPlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP Plot")
@RestController
@RequestMapping("/gap/plot")
@Validated
public class GapPlotController {

    @Resource
    private GapPlotService PlotService;

    @PostMapping("/create")
    @Operation(summary = "创建Plot")
    @PreAuthorize("@ss.hasPermission('gap:plot:create')")
    public CommonResult<Long> createGapPlot(@Valid @RequestBody GapPlotSaveReqVO createReqVO) {
        return success(PlotService.createGapPlot(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新Plot")
    @PreAuthorize("@ss.hasPermission('gap:plot:update')")
    public CommonResult<Boolean> updateGapPlot(@Valid @RequestBody GapPlotSaveReqVO updateReqVO) {
        PlotService.updateGapPlot(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除Plot")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:plot:delete')")
    public CommonResult<Boolean> deleteGapPlot(@RequestParam("id") Long id) {
        PlotService.deleteGapPlot(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得Plot")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:plot:query')")
    public CommonResult<GapPlotRespVO> getGapPlot(@RequestParam("id") Long id) {
        GapPlotDO entity = PlotService.getGapPlot(id);
        return success(BeanUtils.toBean(entity, GapPlotRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得Plot分页")
    @PreAuthorize("@ss.hasPermission('gap:plot:query')")
    public CommonResult<PageResult<GapPlotRespVO>> getGapPlotPage(@Valid GapPlotPageReqVO pageReqVO) {
        PageResult<GapPlotDO> pageResult = PlotService.getGapPlotPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPlotRespVO.class));
    }
}
