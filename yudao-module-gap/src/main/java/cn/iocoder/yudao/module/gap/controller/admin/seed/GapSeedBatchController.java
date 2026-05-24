package cn.iocoder.yudao.module.gap.controller.admin.seed;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.seed.GapSeedBatchDO;
import cn.iocoder.yudao.module.gap.service.seed.GapSeedBatchService;
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

@Tag(name = "管理后台 - GAP 种子种苗批次")
@RestController
@RequestMapping("/gap/seed-batch")
@Validated
public class GapSeedBatchController {

    @Resource
    private GapSeedBatchService seedBatchService;

    @PostMapping("/create")
    @Operation(summary = "创建种子种苗批次")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:create')")
    public CommonResult<Long> createSeedBatch(@Valid @RequestBody GapSeedBatchSaveReqVO createReqVO) {
        return success(seedBatchService.createSeedBatch(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新种子种苗批次")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:update')")
    public CommonResult<Boolean> updateSeedBatch(@Valid @RequestBody GapSeedBatchSaveReqVO updateReqVO) {
        seedBatchService.updateSeedBatch(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除种子种苗批次")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:delete')")
    public CommonResult<Boolean> deleteSeedBatch(@RequestParam("id") Long id) {
        seedBatchService.deleteSeedBatch(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得种子种苗批次")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:query')")
    public CommonResult<GapSeedBatchRespVO> getSeedBatch(@RequestParam("id") Long id) {
        GapSeedBatchDO seedBatch = seedBatchService.getSeedBatch(id);
        return success(BeanUtils.toBean(seedBatch, GapSeedBatchRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得种子种苗批次分页")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:query')")
    public CommonResult<PageResult<GapSeedBatchRespVO>> getSeedBatchPage(@Valid GapSeedBatchPageReqVO pageReqVO) {
        PageResult<GapSeedBatchDO> pageResult = seedBatchService.getSeedBatchPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapSeedBatchRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得种子种苗批次列表")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:query')")
    public CommonResult<List<GapSeedBatchRespVO>> getSeedBatchList() {
        List<GapSeedBatchDO> list = seedBatchService.getSeedBatchList();
        return success(BeanUtils.toBean(list, GapSeedBatchRespVO.class));
    }

    @GetMapping("/list-by-variety")
    @Operation(summary = "根据品种获得种子种苗批次列表")
    @Parameter(name = "varietyId", description = "品种编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:query')")
    public CommonResult<List<GapSeedBatchRespVO>> getSeedBatchListByVarietyId(@RequestParam("varietyId") Long varietyId) {
        List<GapSeedBatchDO> list = seedBatchService.getSeedBatchListByVarietyId(varietyId);
        return success(BeanUtils.toBean(list, GapSeedBatchRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出种子种苗批次 Excel")
    @PreAuthorize("@ss.hasPermission('gap:seed-batch:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportSeedBatchExcel(@Valid GapSeedBatchPageReqVO pageReqVO,
                                     HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapSeedBatchDO> list = seedBatchService.getSeedBatchPage(pageReqVO).getList();
        ExcelUtils.write(response, "种子种苗批次.xls", "数据", GapSeedBatchRespVO.class,
                BeanUtils.toBean(list, GapSeedBatchRespVO.class));
    }

}
