package cn.iocoder.yudao.module.gap.controller.admin.audit;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistItemDO;
import cn.iocoder.yudao.module.gap.service.audit.GapAuditChecklistItemService;
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

@Tag(name = "管理后台 - GAP 审核检查表项目")
@RestController
@RequestMapping("/gap/audit-checklist-item")
@Validated
public class GapAuditChecklistItemController {

    @Resource
    private GapAuditChecklistItemService auditChecklistItemService;

    @PostMapping("/create")
    @Operation(summary = "创建审核检查表项目")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:create')")
    public CommonResult<Long> createAuditChecklistItem(@Valid @RequestBody GapAuditChecklistItemSaveReqVO createReqVO) {
        return success(auditChecklistItemService.createAuditChecklistItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新审核检查表项目")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:update')")
    public CommonResult<Boolean> updateAuditChecklistItem(@Valid @RequestBody GapAuditChecklistItemSaveReqVO updateReqVO) {
        auditChecklistItemService.updateAuditChecklistItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除审核检查表项目")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:delete')")
    public CommonResult<Boolean> deleteAuditChecklistItem(@RequestParam("id") Long id) {
        auditChecklistItemService.deleteAuditChecklistItem(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得审核检查表项目")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:query')")
    public CommonResult<GapAuditChecklistItemRespVO> getAuditChecklistItem(@RequestParam("id") Long id) {
        GapAuditChecklistItemDO auditChecklistItem = auditChecklistItemService.getAuditChecklistItem(id);
        return success(BeanUtils.toBean(auditChecklistItem, GapAuditChecklistItemRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得审核检查表项目分页")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:query')")
    public CommonResult<PageResult<GapAuditChecklistItemRespVO>> getAuditChecklistItemPage(@Valid GapAuditChecklistItemPageReqVO pageReqVO) {
        PageResult<GapAuditChecklistItemDO> pageResult = auditChecklistItemService.getAuditChecklistItemPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapAuditChecklistItemRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得审核检查表项目列表")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:query')")
    public CommonResult<List<GapAuditChecklistItemRespVO>> getAuditChecklistItemList() {
        List<GapAuditChecklistItemDO> list = auditChecklistItemService.getAuditChecklistItemList();
        return success(BeanUtils.toBean(list, GapAuditChecklistItemRespVO.class));
    }

    @GetMapping("/list-by-checklist")
    @Operation(summary = "根据检查表获得项目列表")
    @Parameter(name = "checklistId", description = "检查表编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:query')")
    public CommonResult<List<GapAuditChecklistItemRespVO>> getAuditChecklistItemListByChecklistId(@RequestParam("checklistId") Long checklistId) {
        List<GapAuditChecklistItemDO> list = auditChecklistItemService.getAuditChecklistItemListByChecklistId(checklistId);
        return success(BeanUtils.toBean(list, GapAuditChecklistItemRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出审核检查表项目 Excel")
    @PreAuthorize("@ss.hasPermission('gap:audit-checklist-item:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportAuditChecklistItemExcel(@Valid GapAuditChecklistItemPageReqVO pageReqVO,
                                              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapAuditChecklistItemDO> list = auditChecklistItemService.getAuditChecklistItemPage(pageReqVO).getList();
        ExcelUtils.write(response, "审核检查表项目.xls", "数据", GapAuditChecklistItemRespVO.class,
                BeanUtils.toBean(list, GapAuditChecklistItemRespVO.class));
    }

}
