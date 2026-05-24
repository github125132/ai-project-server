package cn.iocoder.yudao.module.gap.controller.admin.document;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategoryRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentCategoryDO;
import cn.iocoder.yudao.module.gap.service.document.GapDocumentCategoryService;
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

@Tag(name = "管理后台 - GAP 文件分类")
@RestController
@RequestMapping("/gap/document-category")
@Validated
public class GapDocumentCategoryController {

    @Resource
    private GapDocumentCategoryService documentCategoryService;

    @PostMapping("/create")
    @Operation(summary = "创建文件分类")
    @PreAuthorize("@ss.hasPermission('gap:document-category:create')")
    public CommonResult<Long> createDocumentCategory(@Valid @RequestBody GapDocumentCategorySaveReqVO createReqVO) {
        return success(documentCategoryService.createDocumentCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新文件分类")
    @PreAuthorize("@ss.hasPermission('gap:document-category:update')")
    public CommonResult<Boolean> updateDocumentCategory(@Valid @RequestBody GapDocumentCategorySaveReqVO updateReqVO) {
        documentCategoryService.updateDocumentCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除文件分类")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:document-category:delete')")
    public CommonResult<Boolean> deleteDocumentCategory(@RequestParam("id") Long id) {
        documentCategoryService.deleteDocumentCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得文件分类")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:document-category:query')")
    public CommonResult<GapDocumentCategoryRespVO> getDocumentCategory(@RequestParam("id") Long id) {
        GapDocumentCategoryDO category = documentCategoryService.getDocumentCategory(id);
        return success(BeanUtils.toBean(category, GapDocumentCategoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得文件分类分页")
    @PreAuthorize("@ss.hasPermission('gap:document-category:query')")
    public CommonResult<PageResult<GapDocumentCategoryRespVO>> getDocumentCategoryPage(@Valid GapDocumentCategoryPageReqVO pageReqVO) {
        PageResult<GapDocumentCategoryDO> pageResult = documentCategoryService.getDocumentCategoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapDocumentCategoryRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得文件分类列表")
    @PreAuthorize("@ss.hasPermission('gap:document-category:query')")
    public CommonResult<List<GapDocumentCategoryRespVO>> getDocumentCategoryList() {
        List<GapDocumentCategoryDO> list = documentCategoryService.getDocumentCategoryList();
        return success(BeanUtils.toBean(list, GapDocumentCategoryRespVO.class));
    }

    @GetMapping("/list-by-parent")
    @Operation(summary = "根据父分类ID获得子分类列表")
    @Parameter(name = "parentId", description = "父分类编号", required = true, example = "0")
    @PreAuthorize("@ss.hasPermission('gap:document-category:query')")
    public CommonResult<List<GapDocumentCategoryRespVO>> getDocumentCategoryListByParentId(@RequestParam("parentId") Long parentId) {
        List<GapDocumentCategoryDO> list = documentCategoryService.getDocumentCategoryListByParentId(parentId);
        return success(BeanUtils.toBean(list, GapDocumentCategoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出文件分类 Excel")
    @PreAuthorize("@ss.hasPermission('gap:document-category:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportDocumentCategoryExcel(@Valid GapDocumentCategoryPageReqVO pageReqVO,
                                            HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapDocumentCategoryDO> list = documentCategoryService.getDocumentCategoryPage(pageReqVO).getList();
        ExcelUtils.write(response, "文件分类.xls", "数据", GapDocumentCategoryRespVO.class,
                BeanUtils.toBean(list, GapDocumentCategoryRespVO.class));
    }

}
