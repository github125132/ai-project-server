package cn.iocoder.yudao.module.gap.controller.admin.audit;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistDO;
import cn.iocoder.yudao.module.gap.service.audit.GapAuditChecklistService;
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

@Tag(name = "管理后台 - GAP 审核检查表")
@RestController
@RequestMapping("/gap/audit-checklist")
@Validated
public class GapAuditChecklistController {

    @Resource
    private GapAuditChecklistService auditChecklistService;

    @PostMapping("/create")
    @Operation(summary = "创建审核检查表")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:create')")
    public CommonResult<Long> createAuditChecklist(@Valid @RequestBody GapAuditChecklistSaveReqVO createReqVO) {
        return success(auditChecklistService.createAuditChecklist(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新审核检查表")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:update')")
    public CommonResult<Boolean> updateAuditChecklist(@Valid @RequestBody GapAuditChecklistSaveReqVO updateReqVO) {
        auditChecklistService.updateAuditChecklist(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除审核检查表")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:delete')")
    public CommonResult<Boolean> deleteAuditChecklist(@RequestParam("id") Long id) {
        auditChecklistService.deleteAuditChecklist(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得审核检查表")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:query')")
    public CommonResult<GapAuditChecklistRespVO> getAuditChecklist(@RequestParam("id") Long id) {
        GapAuditChecklistDO auditChecklist = auditChecklistService.getAuditChecklist(id);
        return success(BeanUtils.toBean(auditChecklist, GapAuditChecklistRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得审核检查表分页")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:query')")
    public CommonResult<PageResult<GapAuditChecklistRespVO>> getAuditChecklistPage(@Valid GapAuditChecklistPageReqVO pageReqVO) {
        PageResult<GapAuditChecklistDO> pageResult = auditChecklistService.getAuditChecklistPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapAuditChecklistRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得审核检查表列表")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:query')")
    public CommonResult<List<GapAuditChecklistRespVO>> getAuditChecklistList() {
        List<GapAuditChecklistDO> list = auditChecklistService.getAuditChecklistList();
        return success(BeanUtils.toBean(list, GapAuditChecklistRespVO.class));
    }

    @GetMapping("/list-by-plan")
    @Operation(summary = "根据审核计划获得检查表列表")
    @Parameter(name = "planId", description = "审核计划编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:query')")
    public CommonResult<List<GapAuditChecklistRespVO>> getAuditChecklistListByPlanId(@RequestParam("planId") Long planId) {
        List<GapAuditChecklistDO> list = auditChecklistService.getAuditChecklistListByPlanId(planId);
        return success(BeanUtils.toBean(list, GapAuditChecklistRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出审核检查表 Excel")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportAuditChecklistExcel(@Valid GapAuditChecklistPageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapAuditChecklistDO> list = auditChecklistService.getAuditChecklistPage(pageReqVO).getList();
        ExcelUtils.write(response, "审核检查表.xls", "数据", GapAuditChecklistRespVO.class,
                BeanUtils.toBean(list, GapAuditChecklistRespVO.class));
    }

}
