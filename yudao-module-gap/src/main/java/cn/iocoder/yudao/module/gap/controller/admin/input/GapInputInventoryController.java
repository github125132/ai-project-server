package cn.iocoder.yudao.module.gap.controller.admin.input;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventoryRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputInventoryDO;
import cn.iocoder.yudao.module.gap.service.input.GapInputInventoryService;
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

@Tag(name = "管理后台 - GAP 投入品库存")
@RestController
@RequestMapping("/gap/input-inventory")
@Validated
public class GapInputInventoryController {

    @Resource
    private GapInputInventoryService inputInventoryService;

    @PostMapping("/create")
    @Operation(summary = "创建投入品库存")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:create')")
    public CommonResult<Long> createInputInventory(@Valid @RequestBody GapInputInventorySaveReqVO createReqVO) {
        return success(inputInventoryService.createInputInventory(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新投入品库存")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:update')")
    public CommonResult<Boolean> updateInputInventory(@Valid @RequestBody GapInputInventorySaveReqVO updateReqVO) {
        inputInventoryService.updateInputInventory(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除投入品库存")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:delete')")
    public CommonResult<Boolean> deleteInputInventory(@RequestParam("id") Long id) {
        inputInventoryService.deleteInputInventory(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得投入品库存")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:query')")
    public CommonResult<GapInputInventoryRespVO> getInputInventory(@RequestParam("id") Long id) {
        GapInputInventoryDO inventory = inputInventoryService.getInputInventory(id);
        return success(BeanUtils.toBean(inventory, GapInputInventoryRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得投入品库存分页")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:query')")
    public CommonResult<PageResult<GapInputInventoryRespVO>> getInputInventoryPage(@Valid GapInputInventoryPageReqVO pageReqVO) {
        PageResult<GapInputInventoryDO> pageResult = inputInventoryService.getInputInventoryPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInputInventoryRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得投入品库存列表")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:query')")
    public CommonResult<List<GapInputInventoryRespVO>> getInputInventoryList() {
        List<GapInputInventoryDO> list = inputInventoryService.getInputInventoryList();
        return success(BeanUtils.toBean(list, GapInputInventoryRespVO.class));
    }

    @GetMapping("/list-by-product")
    @Operation(summary = "根据产品编号获得库存列表")
    @Parameter(name = "productId", description = "产品编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:query')")
    public CommonResult<List<GapInputInventoryRespVO>> getInputInventoryListByProductId(@RequestParam("productId") Long productId) {
        List<GapInputInventoryDO> list = inputInventoryService.getInputInventoryListByProductId(productId);
        return success(BeanUtils.toBean(list, GapInputInventoryRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出投入品库存 Excel")
    @PreAuthorize("@ss.hasPermission('gap:input-inventory:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportInputInventoryExcel(@Valid GapInputInventoryPageReqVO pageReqVO,
                                           HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapInputInventoryDO> list = inputInventoryService.getInputInventoryPage(pageReqVO).getList();
        ExcelUtils.write(response, "投入品库存.xls", "数据", GapInputInventoryRespVO.class,
                BeanUtils.toBean(list, GapInputInventoryRespVO.class));
    }

}
