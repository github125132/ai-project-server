package cn.iocoder.yudao.module.gap.controller.admin.treatment;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.treatment.GapSeedTreatmentDO;
import cn.iocoder.yudao.module.gap.service.treatment.GapSeedTreatmentService;
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

@Tag(name = "管理后台 - GAP 种子处理记录")
@RestController
@RequestMapping("/gap/seed-treatment")
@Validated
public class GapSeedTreatmentController {

    @Resource
    private GapSeedTreatmentService seedTreatmentService;

    @PostMapping("/create")
    @Operation(summary = "创建种子处理记录")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:create')")
    public CommonResult<Long> createSeedTreatment(@Valid @RequestBody GapSeedTreatmentSaveReqVO createReqVO) {
        return success(seedTreatmentService.createSeedTreatment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新种子处理记录")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:update')")
    public CommonResult<Boolean> updateSeedTreatment(@Valid @RequestBody GapSeedTreatmentSaveReqVO updateReqVO) {
        seedTreatmentService.updateSeedTreatment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除种子处理记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:delete')")
    public CommonResult<Boolean> deleteSeedTreatment(@RequestParam("id") Long id) {
        seedTreatmentService.deleteSeedTreatment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得种子处理记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:query')")
    public CommonResult<GapSeedTreatmentRespVO> getSeedTreatment(@RequestParam("id") Long id) {
        GapSeedTreatmentDO seedTreatment = seedTreatmentService.getSeedTreatment(id);
        return success(BeanUtils.toBean(seedTreatment, GapSeedTreatmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得种子处理记录分页")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:query')")
    public CommonResult<PageResult<GapSeedTreatmentRespVO>> getSeedTreatmentPage(@Valid GapSeedTreatmentPageReqVO pageReqVO) {
        PageResult<GapSeedTreatmentDO> pageResult = seedTreatmentService.getSeedTreatmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapSeedTreatmentRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得种子处理记录列表")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:query')")
    public CommonResult<List<GapSeedTreatmentRespVO>> getSeedTreatmentList() {
        List<GapSeedTreatmentDO> list = seedTreatmentService.getSeedTreatmentList();
        return success(BeanUtils.toBean(list, GapSeedTreatmentRespVO.class));
    }

    @GetMapping("/list-by-seed-batch")
    @Operation(summary = "根据种子批次获得处理记录列表")
    @Parameter(name = "seedBatchId", description = "种子批次编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:query')")
    public CommonResult<List<GapSeedTreatmentRespVO>> getSeedTreatmentListBySeedBatchId(@RequestParam("seedBatchId") Long seedBatchId) {
        List<GapSeedTreatmentDO> list = seedTreatmentService.getSeedTreatmentListBySeedBatchId(seedBatchId);
        return success(BeanUtils.toBean(list, GapSeedTreatmentRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出种子处理记录 Excel")
    @PreAuthorize("@ss.hasPermission('gap:seed-treatment:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSeedTreatmentExcel(@Valid GapSeedTreatmentPageReqVO pageReqVO,
                                         HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapSeedTreatmentDO> list = seedTreatmentService.getSeedTreatmentPage(pageReqVO).getList();
        ExcelUtils.write(response, "种子处理记录.xls", "数据", GapSeedTreatmentRespVO.class,
                BeanUtils.toBean(list, GapSeedTreatmentRespVO.class));
    }

}
