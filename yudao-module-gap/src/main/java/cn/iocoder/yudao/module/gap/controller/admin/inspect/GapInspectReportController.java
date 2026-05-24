package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectReportDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapInspectReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP InspectReport")
@RestController
@RequestMapping("/gap/inspect-report")
@Validated
public class GapInspectReportController {

    @Resource
    private GapInspectReportService InspectReportService;

    @PostMapping("/create")
    @Operation(summary = "创建InspectReport")
    @PreAuthorize("@ss.hasPermission('gap:inspect-report:create')")
    public CommonResult<Long> createGapInspectReport(@Valid @RequestBody GapInspectReportSaveReqVO createReqVO) {
        return success(InspectReportService.createGapInspectReport(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新InspectReport")
    @PreAuthorize("@ss.hasPermission('gap:inspect-report:update')")
    public CommonResult<Boolean> updateGapInspectReport(@Valid @RequestBody GapInspectReportSaveReqVO updateReqVO) {
        InspectReportService.updateGapInspectReport(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除InspectReport")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:inspect-report:delete')")
    public CommonResult<Boolean> deleteGapInspectReport(@RequestParam("id") Long id) {
        InspectReportService.deleteGapInspectReport(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得InspectReport")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:inspect-report:query')")
    public CommonResult<GapInspectReportRespVO> getGapInspectReport(@RequestParam("id") Long id) {
        GapInspectReportDO entity = InspectReportService.getGapInspectReport(id);
        return success(BeanUtils.toBean(entity, GapInspectReportRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得InspectReport分页")
    @PreAuthorize("@ss.hasPermission('gap:inspect-report:query')")
    public CommonResult<PageResult<GapInspectReportRespVO>> getGapInspectReportPage(@Valid GapInspectReportPageReqVO pageReqVO) {
        PageResult<GapInspectReportDO> pageResult = InspectReportService.getGapInspectReportPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInspectReportRespVO.class));
    }
}
