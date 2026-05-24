package cn.iocoder.yudao.module.gap.controller.admin.audit;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapNcItemDO;
import cn.iocoder.yudao.module.gap.service.audit.GapNcItemService;
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

@Tag(name = "管理后台 - GAP 不符合项")
@RestController
@RequestMapping("/gap/nc-item")
@Validated
public class GapNcItemController {

    @Resource
    private GapNcItemService ncItemService;

    @PostMapping("/create")
    @Operation(summary = "创建不符合项")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:create')")
    public CommonResult<Long> createNcItem(@Valid @RequestBody GapNcItemSaveReqVO createReqVO) {
        return success(ncItemService.createNcItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新不符合项")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:update')")
    public CommonResult<Boolean> updateNcItem(@Valid @RequestBody GapNcItemSaveReqVO updateReqVO) {
        ncItemService.updateNcItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除不符合项")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:nc-item:delete')")
    public CommonResult<Boolean> deleteNcItem(@RequestParam("id") Long id) {
        ncItemService.deleteNcItem(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得不符合项")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:query')")
    public CommonResult<GapNcItemRespVO> getNcItem(@RequestParam("id") Long id) {
        GapNcItemDO ncItem = ncItemService.getNcItem(id);
        return success(BeanUtils.toBean(ncItem, GapNcItemRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得不符合项分页")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:query')")
    public CommonResult<PageResult<GapNcItemRespVO>> getNcItemPage(@Valid GapNcItemPageReqVO pageReqVO) {
        PageResult<GapNcItemDO> pageResult = ncItemService.getNcItemPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapNcItemRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得不符合项列表")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:query')")
    public CommonResult<List<GapNcItemRespVO>> getNcItemList() {
        List<GapNcItemDO> list = ncItemService.getNcItemList();
        return success(BeanUtils.toBean(list, GapNcItemRespVO.class));
    }

    @GetMapping("/list-by-plan")
    @Operation(summary = "根据审核计划获得不符合项列表")
    @Parameter(name = "planId", description = "审核计划编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:query')")
    public CommonResult<List<GapNcItemRespVO>> getNcItemListByPlanId(@RequestParam("planId") Long planId) {
        List<GapNcItemDO> list = ncItemService.getNcItemListByPlanId(planId);
        return success(BeanUtils.toBean(list, GapNcItemRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出不符合项 Excel")
    @PreAuthorize("@ss.hasPermission('gap:nc-item:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportNcItemExcel(@Valid GapNcItemPageReqVO pageReqVO,
                                  HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapNcItemDO> list = ncItemService.getNcItemPage(pageReqVO).getList();
        ExcelUtils.write(response, "不符合项.xls", "数据", GapNcItemRespVO.class,
                BeanUtils.toBean(list, GapNcItemRespVO.class));
    }

}
