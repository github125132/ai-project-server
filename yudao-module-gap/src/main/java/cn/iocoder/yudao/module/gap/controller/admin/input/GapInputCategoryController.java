package cn.iocoder.yudao.module.gap.controller.admin.input;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategoryRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputCategoryDO;
import cn.iocoder.yudao.module.gap.service.input.GapInputCategoryService;
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

@Tag(name = "管理后台 - GAP 投入品分类")
@RestController
@RequestMapping("/gap/input-category")
@Validated
public class GapInputCategoryController {

    @Resource
    private GapInputCategoryService inputCategoryService;

    @PostMapping("/create")
    @Operation(summary = "创建投入品分类")
    @PreAuthorize("@ss.hasPermission('gap:input-category:create')")
    public CommonResult<Long> createInputCategory(@Valid @RequestBody GapInputCategorySaveReqVO createReqVO) {
        return success(inputCategoryService.createInputCategory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新投入品分类")
    @PreAuthorize("@ss.hasPermission('gap:input-category:update')")
    public CommonResult<Boolean> updateInputCategory(@Valid @RequestBody GapInputCategorySaveReqVO updateReqVO) {
        inputCategoryService.updateInputCategory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除投入品分类")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:input-category:delete')")
    public CommonResult<Boolean> deleteInputCategory(@RequestParam("id") Long id) {
        inputCategoryService.deleteInputCategory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得投入品分类")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:input-category:query')")
    public CommonResult<GapInputCategoryRespVO> getInputCategory(@RequestParam("id") Long id) {
        GapInputCategoryDO category = inputCategoryService.getInputCategory(id);
        return success(BeanUtils.toBean(category, GapInputCategoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得投入品分类分页")
    @PreAuthorize("@ss.hasPermission('gap:input-category:query')")
    public CommonResult<PageResult<GapInputCategoryRespVO>> getInputCategoryPage(@Valid GapInputCategoryPageReqVO pageReqVO) {
        PageResult<GapInputCategoryDO> pageResult = inputCategoryService.getInputCategoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInputCategoryRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得投入品分类列表")
    @PreAuthorize("@ss.hasPermission('gap:input-category:query')")
    public CommonResult<List<GapInputCategoryRespVO>> getInputCategoryList() {
        List<GapInputCategoryDO> list = inputCategoryService.getInputCategoryList();
        return success(BeanUtils.toBean(list, GapInputCategoryRespVO.class));
    }

    @GetMapping("/list-by-parent")
    @Operation(summary = "根据父分类编号获得子分类列表")
    @Parameter(name = "parentId", description = "父分类编号", example = "0")
    @PreAuthorize("@ss.hasPermission('gap:input-category:query')")
    public CommonResult<List<GapInputCategoryRespVO>> getInputCategoryListByParentId(@RequestParam("parentId") Long parentId) {
        List<GapInputCategoryDO> list = inputCategoryService.getInputCategoryListByParentId(parentId);
        return success(BeanUtils.toBean(list, GapInputCategoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出投入品分类 Excel")
    @PreAuthorize("@ss.hasPermission('gap:input-category:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInputCategoryExcel(@Valid GapInputCategoryPageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapInputCategoryDO> list = inputCategoryService.getInputCategoryPage(pageReqVO).getList();
        ExcelUtils.write(response, "投入品分类.xls", "数据", GapInputCategoryRespVO.class,
                BeanUtils.toBean(list, GapInputCategoryRespVO.class));
    }

}
