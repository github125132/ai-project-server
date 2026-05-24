package cn.iocoder.yudao.module.gap.controller.admin.document;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplatePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplateRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplateSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapRecordTemplateDO;
import cn.iocoder.yudao.module.gap.service.document.GapRecordTemplateService;
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

@Tag(name = "管理后台 - GAP 记录模板")
@RestController
@RequestMapping("/gap/record-template")
@Validated
public class GapRecordTemplateController {

    @Resource
    private GapRecordTemplateService recordTemplateService;

    @PostMapping("/create")
    @Operation(summary = "创建记录模板")
    @PreAuthorize("@ss.hasPermission('gap:record-template:create')")
    public CommonResult<Long> createRecordTemplate(@Valid @RequestBody GapRecordTemplateSaveReqVO createReqVO) {
        return success(recordTemplateService.createRecordTemplate(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新记录模板")
    @PreAuthorize("@ss.hasPermission('gap:record-template:update')")
    public CommonResult<Boolean> updateRecordTemplate(@Valid @RequestBody GapRecordTemplateSaveReqVO updateReqVO) {
        recordTemplateService.updateRecordTemplate(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除记录模板")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:record-template:delete')")
    public CommonResult<Boolean> deleteRecordTemplate(@RequestParam("id") Long id) {
        recordTemplateService.deleteRecordTemplate(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得记录模板")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:record-template:query')")
    public CommonResult<GapRecordTemplateRespVO> getRecordTemplate(@RequestParam("id") Long id) {
        GapRecordTemplateDO recordTemplate = recordTemplateService.getRecordTemplate(id);
        return success(BeanUtils.toBean(recordTemplate, GapRecordTemplateRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得记录模板分页")
    @PreAuthorize("@ss.hasPermission('gap:record-template:query')")
    public CommonResult<PageResult<GapRecordTemplateRespVO>> getRecordTemplatePage(@Valid GapRecordTemplatePageReqVO pageReqVO) {
        PageResult<GapRecordTemplateDO> pageResult = recordTemplateService.getRecordTemplatePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapRecordTemplateRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得记录模板列表")
    @PreAuthorize("@ss.hasPermission('gap:record-template:query')")
    public CommonResult<List<GapRecordTemplateRespVO>> getRecordTemplateList() {
        List<GapRecordTemplateDO> list = recordTemplateService.getRecordTemplateList();
        return success(BeanUtils.toBean(list, GapRecordTemplateRespVO.class));
    }

    @GetMapping("/list-by-category")
    @Operation(summary = "根据分类ID获得记录模板列表")
    @Parameter(name = "categoryId", description = "分类编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:record-template:query')")
    public CommonResult<List<GapRecordTemplateRespVO>> getRecordTemplateListByCategoryId(@RequestParam("categoryId") Long categoryId) {
        List<GapRecordTemplateDO> list = recordTemplateService.getRecordTemplateListByCategoryId(categoryId);
        return success(BeanUtils.toBean(list, GapRecordTemplateRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出记录模板 Excel")
    @PreAuthorize("@ss.hasPermission('gap:record-template:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportRecordTemplateExcel(@Valid GapRecordTemplatePageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapRecordTemplateDO> list = recordTemplateService.getRecordTemplatePage(pageReqVO).getList();
        ExcelUtils.write(response, "记录模板.xls", "数据", GapRecordTemplateRespVO.class,
                BeanUtils.toBean(list, GapRecordTemplateRespVO.class));
    }

}
