package cn.iocoder.yudao.module.gap.controller.admin.document;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentDO;
import cn.iocoder.yudao.module.gap.service.document.GapDocumentService;
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

@Tag(name = "管理后台 - GAP 文件档案")
@RestController
@RequestMapping("/gap/document")
@Validated
public class GapDocumentController {

    @Resource
    private GapDocumentService documentService;

    @PostMapping("/create")
    @Operation(summary = "创建文件档案")
    @PreAuthorize("@ss.hasPermission('gap:document:create')")
    public CommonResult<Long> createDocument(@Valid @RequestBody GapDocumentSaveReqVO createReqVO) {
        return success(documentService.createDocument(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新文件档案")
    @PreAuthorize("@ss.hasPermission('gap:document:update')")
    public CommonResult<Boolean> updateDocument(@Valid @RequestBody GapDocumentSaveReqVO updateReqVO) {
        documentService.updateDocument(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除文件档案")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:document:delete')")
    public CommonResult<Boolean> deleteDocument(@RequestParam("id") Long id) {
        documentService.deleteDocument(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得文件档案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:document:query')")
    public CommonResult<GapDocumentRespVO> getDocument(@RequestParam("id") Long id) {
        GapDocumentDO document = documentService.getDocument(id);
        return success(BeanUtils.toBean(document, GapDocumentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得文件档案分页")
    @PreAuthorize("@ss.hasPermission('gap:document:query')")
    public CommonResult<PageResult<GapDocumentRespVO>> getDocumentPage(@Valid GapDocumentPageReqVO pageReqVO) {
        PageResult<GapDocumentDO> pageResult = documentService.getDocumentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapDocumentRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得文件档案列表")
    @PreAuthorize("@ss.hasPermission('gap:document:query')")
    public CommonResult<List<GapDocumentRespVO>> getDocumentList() {
        List<GapDocumentDO> list = documentService.getDocumentList();
        return success(BeanUtils.toBean(list, GapDocumentRespVO.class));
    }

    @GetMapping("/list-by-category")
    @Operation(summary = "根据分类ID获得文件档案列表")
    @Parameter(name = "categoryId", description = "分类编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:document:query')")
    public CommonResult<List<GapDocumentRespVO>> getDocumentListByCategoryId(@RequestParam("categoryId") Long categoryId) {
        List<GapDocumentDO> list = documentService.getDocumentListByCategoryId(categoryId);
        return success(BeanUtils.toBean(list, GapDocumentRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出文件档案 Excel")
    @PreAuthorize("@ss.hasPermission('gap:document:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDocumentExcel(@Valid GapDocumentPageReqVO pageReqVO,
                                    HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapDocumentDO> list = documentService.getDocumentPage(pageReqVO).getList();
        ExcelUtils.write(response, "文件档案.xls", "数据", GapDocumentRespVO.class,
                BeanUtils.toBean(list, GapDocumentRespVO.class));
    }

}
