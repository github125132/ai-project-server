package cn.iocoder.yudao.module.gap.controller.admin.origin;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifyPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifyRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.origin.GapOriginIdentifyDO;
import cn.iocoder.yudao.module.gap.service.origin.GapOriginIdentifyService;
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

@Tag(name = "管理后台 - GAP 基源鉴定")
@RestController
@RequestMapping("/gap/origin-identify")
@Validated
public class GapOriginIdentifyController {

    @Resource
    private GapOriginIdentifyService originIdentifyService;

    @PostMapping("/create")
    @Operation(summary = "创建基源鉴定")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:create')")
    public CommonResult<Long> createOriginIdentify(@Valid @RequestBody GapOriginIdentifySaveReqVO createReqVO) {
        return success(originIdentifyService.createOriginIdentify(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新基源鉴定")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:update')")
    public CommonResult<Boolean> updateOriginIdentify(@Valid @RequestBody GapOriginIdentifySaveReqVO updateReqVO) {
        originIdentifyService.updateOriginIdentify(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除基源鉴定")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:delete')")
    public CommonResult<Boolean> deleteOriginIdentify(@RequestParam("id") Long id) {
        originIdentifyService.deleteOriginIdentify(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得基源鉴定")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:query')")
    public CommonResult<GapOriginIdentifyRespVO> getOriginIdentify(@RequestParam("id") Long id) {
        GapOriginIdentifyDO originIdentify = originIdentifyService.getOriginIdentify(id);
        return success(BeanUtils.toBean(originIdentify, GapOriginIdentifyRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得基源鉴定分页")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:query')")
    public CommonResult<PageResult<GapOriginIdentifyRespVO>> getOriginIdentifyPage(@Valid GapOriginIdentifyPageReqVO pageReqVO) {
        PageResult<GapOriginIdentifyDO> pageResult = originIdentifyService.getOriginIdentifyPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapOriginIdentifyRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得基源鉴定列表")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:query')")
    public CommonResult<List<GapOriginIdentifyRespVO>> getOriginIdentifyList() {
        List<GapOriginIdentifyDO> list = originIdentifyService.getOriginIdentifyList();
        return success(BeanUtils.toBean(list, GapOriginIdentifyRespVO.class));
    }

    @GetMapping("/list-by-variety")
    @Operation(summary = "根据品种获得基源鉴定列表")
    @Parameter(name = "varietyId", description = "品种编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:query')")
    public CommonResult<List<GapOriginIdentifyRespVO>> getOriginIdentifyListByVarietyId(@RequestParam("varietyId") Long varietyId) {
        List<GapOriginIdentifyDO> list = originIdentifyService.getOriginIdentifyListByVarietyId(varietyId);
        return success(BeanUtils.toBean(list, GapOriginIdentifyRespVO.class));
    }

    @GetMapping("/list-by-seed-batch")
    @Operation(summary = "根据种子批次获得基源鉴定列表")
    @Parameter(name = "seedBatchId", description = "种子批次编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:query')")
    public CommonResult<List<GapOriginIdentifyRespVO>> getOriginIdentifyListBySeedBatchId(@RequestParam("seedBatchId") Long seedBatchId) {
        List<GapOriginIdentifyDO> list = originIdentifyService.getOriginIdentifyListBySeedBatchId(seedBatchId);
        return success(BeanUtils.toBean(list, GapOriginIdentifyRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出基源鉴定 Excel")
    @PreAuthorize("@ss.hasPermission('gap:origin-identify:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportOriginIdentifyExcel(@Valid GapOriginIdentifyPageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapOriginIdentifyDO> list = originIdentifyService.getOriginIdentifyPage(pageReqVO).getList();
        ExcelUtils.write(response, "基源鉴定.xls", "数据", GapOriginIdentifyRespVO.class,
                BeanUtils.toBean(list, GapOriginIdentifyRespVO.class));
    }

}
