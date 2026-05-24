package cn.iocoder.yudao.module.gap.controller.admin.audit;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditPlanDO;
import cn.iocoder.yudao.module.gap.service.audit.GapAuditPlanService;
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

@Tag(name = "管理后台 - GAP 审核计划")
@RestController
@RequestMapping("/gap/audit-plan")
@Validated
public class GapAuditPlanController {

    @Resource
    private GapAuditPlanService auditPlanService;

    @PostMapping("/create")
    @Operation(summary = "创建审核计划")
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:create')")
    public CommonResult<Long> createAuditPlan(@Valid @RequestBody GapAuditPlanSaveReqVO createReqVO) {
        return success(auditPlanService.createAuditPlan(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新审核计划")
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:update')")
    public CommonResult<Boolean> updateAuditPlan(@Valid @RequestBody GapAuditPlanSaveReqVO updateReqVO) {
        auditPlanService.updateAuditPlan(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除审核计划")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:delete')")
    public CommonResult<Boolean> deleteAuditPlan(@RequestParam("id") Long id) {
        auditPlanService.deleteAuditPlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得审核计划")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:query')")
    public CommonResult<GapAuditPlanRespVO> getAuditPlan(@RequestParam("id") Long id) {
        GapAuditPlanDO auditPlan = auditPlanService.getAuditPlan(id);
        return success(BeanUtils.toBean(auditPlan, GapAuditPlanRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得审核计划分页")
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:query')")
    public CommonResult<PageResult<GapAuditPlanRespVO>> getAuditPlanPage(@Valid GapAuditPlanPageReqVO pageReqVO) {
        PageResult<GapAuditPlanDO> pageResult = auditPlanService.getAuditPlanPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapAuditPlanRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得审核计划列表")
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:query')")
    public CommonResult<List<GapAuditPlanRespVO>> getAuditPlanList() {
        List<GapAuditPlanDO> list = auditPlanService.getAuditPlanList();
        return success(BeanUtils.toBean(list, GapAuditPlanRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出审核计划 Excel")
    @PreAuthorize("@ss.hasPermission('gap:audit-plan:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportAuditPlanExcel(@Valid GapAuditPlanPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapAuditPlanDO> list = auditPlanService.getAuditPlanPage(pageReqVO).getList();
        ExcelUtils.write(response, "审核计划.xls", "数据", GapAuditPlanRespVO.class,
                BeanUtils.toBean(list, GapAuditPlanRespVO.class));
    }

}
