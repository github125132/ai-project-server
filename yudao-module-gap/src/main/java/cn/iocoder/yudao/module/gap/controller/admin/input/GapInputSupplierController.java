package cn.iocoder.yudao.module.gap.controller.admin.input;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputSupplierDO;
import cn.iocoder.yudao.module.gap.service.input.GapInputSupplierService;
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

@Tag(name = "管理后台 - GAP 投入品供应商")
@RestController
@RequestMapping("/gap/input-supplier")
@Validated
public class GapInputSupplierController {

    @Resource
    private GapInputSupplierService inputSupplierService;

    @PostMapping("/create")
    @Operation(summary = "创建供应商档案")
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:create')")
    public CommonResult<Long> createInputSupplier(@Valid @RequestBody GapInputSupplierSaveReqVO createReqVO) {
        return success(inputSupplierService.createInputSupplier(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新供应商档案")
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:update')")
    public CommonResult<Boolean> updateInputSupplier(@Valid @RequestBody GapInputSupplierSaveReqVO updateReqVO) {
        inputSupplierService.updateInputSupplier(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除供应商档案")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:delete')")
    public CommonResult<Boolean> deleteInputSupplier(@RequestParam("id") Long id) {
        inputSupplierService.deleteInputSupplier(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得供应商档案")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:query')")
    public CommonResult<GapInputSupplierRespVO> getInputSupplier(@RequestParam("id") Long id) {
        GapInputSupplierDO supplier = inputSupplierService.getInputSupplier(id);
        return success(BeanUtils.toBean(supplier, GapInputSupplierRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得供应商档案分页")
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:query')")
    public CommonResult<PageResult<GapInputSupplierRespVO>> getInputSupplierPage(@Valid GapInputSupplierPageReqVO pageReqVO) {
        PageResult<GapInputSupplierDO> pageResult = inputSupplierService.getInputSupplierPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInputSupplierRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得供应商档案列表")
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:query')")
    public CommonResult<List<GapInputSupplierRespVO>> getInputSupplierList() {
        List<GapInputSupplierDO> list = inputSupplierService.getInputSupplierList();
        return success(BeanUtils.toBean(list, GapInputSupplierRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出供应商档案 Excel")
    @PreAuthorize("@ss.hasPermission('gap:input-supplier:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInputSupplierExcel(@Valid GapInputSupplierPageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapInputSupplierDO> list = inputSupplierService.getInputSupplierPage(pageReqVO).getList();
        ExcelUtils.write(response, "投入品供应商.xls", "数据", GapInputSupplierRespVO.class,
                BeanUtils.toBean(list, GapInputSupplierRespVO.class));
    }

}
