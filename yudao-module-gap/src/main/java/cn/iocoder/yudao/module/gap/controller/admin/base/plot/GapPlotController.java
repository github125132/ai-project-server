package cn.iocoder.yudao.module.gap.controller.admin.base.plot;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.plot.GapPlotDO;
import cn.iocoder.yudao.module.gap.service.base.plot.GapPlotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.EXPORT;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP 地块信息")
@RestController
@RequestMapping("/gap/plot")
@Validated
public class GapPlotController {

    @Resource
    private GapPlotService plotService;

    @PostMapping("/create")
    @Operation(summary = "创建地块信息")
    @PreAuthorize("@ss.hasPermission('gap:plot:create')")
    public CommonResult<Long> createPlot(@Valid @RequestBody GapPlotSaveReqVO createReqVO) {
        return success(plotService.createPlot(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新地块信息")
    @PreAuthorize("@ss.hasPermission('gap:plot:update')")
    public CommonResult<Boolean> updatePlot(@Valid @RequestBody GapPlotSaveReqVO updateReqVO) {
        plotService.updatePlot(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除地块信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:plot:delete')")
    public CommonResult<Boolean> deletePlot(@RequestParam("id") Long id) {
        plotService.deletePlot(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得地块信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:plot:query')")
    public CommonResult<GapPlotRespVO> getPlot(@RequestParam("id") Long id) {
        GapPlotDO plot = plotService.getPlot(id);
        return success(BeanUtils.toBean(plot, GapPlotRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得地块信息分页")
    @PreAuthorize("@ss.hasPermission('gap:plot:query')")
    public CommonResult<PageResult<GapPlotRespVO>> getPlotPage(@Valid GapPlotPageReqVO pageReqVO) {
        PageResult<GapPlotDO> pageResult = plotService.getPlotPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPlotRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得地块信息列表")
    @PreAuthorize("@ss.hasPermission('gap:plot:query')")
    public CommonResult<List<GapPlotRespVO>> getPlotList() {
        List<GapPlotDO> list = plotService.getPlotList();
        return success(BeanUtils.toBean(list, GapPlotRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得地块列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:plot:query')")
    public CommonResult<List<GapPlotRespVO>> getPlotListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapPlotDO> list = plotService.getPlotListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapPlotRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出地块信息 Excel")
    @PreAuthorize("@ss.hasPermission('gap:plot:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportPlotExcel(@Valid GapPlotPageReqVO pageReqVO,
                                HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapPlotDO> list = plotService.getPlotPage(pageReqVO).getList();
        ExcelUtils.write(response, "地块信息.xls", "数据", GapPlotRespVO.class,
                BeanUtils.toBean(list, GapPlotRespVO.class));
    }

}
