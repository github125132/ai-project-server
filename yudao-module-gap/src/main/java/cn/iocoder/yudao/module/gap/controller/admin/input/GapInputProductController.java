package cn.iocoder.yudao.module.gap.controller.admin.input;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputProductDO;
import cn.iocoder.yudao.module.gap.service.input.GapInputProductService;
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

@Tag(name = "管理后台 - GAP 投入品产品")
@RestController
@RequestMapping("/gap/input-product")
@Validated
public class GapInputProductController {

    @Resource
    private GapInputProductService inputProductService;

    @PostMapping("/create")
    @Operation(summary = "创建投入品产品")
    @PreAuthorize("@ss.hasPermission('gap:input-product:create')")
    public CommonResult<Long> createInputProduct(@Valid @RequestBody GapInputProductSaveReqVO createReqVO) {
        return success(inputProductService.createInputProduct(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新投入品产品")
    @PreAuthorize("@ss.hasPermission('gap:input-product:update')")
    public CommonResult<Boolean> updateInputProduct(@Valid @RequestBody GapInputProductSaveReqVO updateReqVO) {
        inputProductService.updateInputProduct(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除投入品产品")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:input-product:delete')")
    public CommonResult<Boolean> deleteInputProduct(@RequestParam("id") Long id) {
        inputProductService.deleteInputProduct(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得投入品产品")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:input-product:query')")
    public CommonResult<GapInputProductRespVO> getInputProduct(@RequestParam("id") Long id) {
        GapInputProductDO product = inputProductService.getInputProduct(id);
        return success(BeanUtils.toBean(product, GapInputProductRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得投入品产品分页")
    @PreAuthorize("@ss.hasPermission('gap:input-product:query')")
    public CommonResult<PageResult<GapInputProductRespVO>> getInputProductPage(@Valid GapInputProductPageReqVO pageReqVO) {
        PageResult<GapInputProductDO> pageResult = inputProductService.getInputProductPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInputProductRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得投入品产品列表")
    @PreAuthorize("@ss.hasPermission('gap:input-product:query')")
    public CommonResult<List<GapInputProductRespVO>> getInputProductList() {
        List<GapInputProductDO> list = inputProductService.getInputProductList();
        return success(BeanUtils.toBean(list, GapInputProductRespVO.class));
    }

    @GetMapping("/list-by-category")
    @Operation(summary = "根据分类编号获得产品列表")
    @Parameter(name = "categoryId", description = "分类编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:input-product:query')")
    public CommonResult<List<GapInputProductRespVO>> getInputProductListByCategoryId(@RequestParam("categoryId") Long categoryId) {
        List<GapInputProductDO> list = inputProductService.getInputProductListByCategoryId(categoryId);
        return success(BeanUtils.toBean(list, GapInputProductRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出投入品产品 Excel")
    @PreAuthorize("@ss.hasPermission('gap:input-product:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInputProductExcel(@Valid GapInputProductPageReqVO pageReqVO,
                                         HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapInputProductDO> list = inputProductService.getInputProductPage(pageReqVO).getList();
        ExcelUtils.write(response, "投入品产品.xls", "数据", GapInputProductRespVO.class,
                BeanUtils.toBean(list, GapInputProductRespVO.class));
    }

}
