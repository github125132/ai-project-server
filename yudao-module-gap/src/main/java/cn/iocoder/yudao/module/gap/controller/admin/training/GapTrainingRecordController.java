package cn.iocoder.yudao.module.gap.controller.admin.training;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingRecordDO;
import cn.iocoder.yudao.module.gap.service.training.GapTrainingRecordService;
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

/**
 * 管理后台 - GAP 培训记录
 *
 * @author 芋道源码
 */
@Tag(name = "管理后台 - GAP 培训记录")
@RestController
@RequestMapping("/gap/training-record")
@Validated
public class GapTrainingRecordController {

    @Resource
    private GapTrainingRecordService trainingRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建培训记录")
    @PreAuthorize("@ss.hasPermission('gap:training-record:create')")
    public CommonResult<Long> createTrainingRecord(@Valid @RequestBody GapTrainingRecordSaveReqVO createReqVO) {
        return success(trainingRecordService.createTrainingRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新培训记录")
    @PreAuthorize("@ss.hasPermission('gap:training-record:update')")
    public CommonResult<Boolean> updateTrainingRecord(@Valid @RequestBody GapTrainingRecordSaveReqVO updateReqVO) {
        trainingRecordService.updateTrainingRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除培训记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:training-record:delete')")
    public CommonResult<Boolean> deleteTrainingRecord(@RequestParam("id") Long id) {
        trainingRecordService.deleteTrainingRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得培训记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:training-record:query')")
    public CommonResult<GapTrainingRecordRespVO> getTrainingRecord(@RequestParam("id") Long id) {
        GapTrainingRecordDO trainingRecord = trainingRecordService.getTrainingRecord(id);
        return success(BeanUtils.toBean(trainingRecord, GapTrainingRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得培训记录分页")
    @PreAuthorize("@ss.hasPermission('gap:training-record:query')")
    public CommonResult<PageResult<GapTrainingRecordRespVO>> getTrainingRecordPage(@Valid GapTrainingRecordPageReqVO pageReqVO) {
        PageResult<GapTrainingRecordDO> pageResult = trainingRecordService.getTrainingRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTrainingRecordRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得培训记录列表")
    @PreAuthorize("@ss.hasPermission('gap:training-record:query')")
    public CommonResult<List<GapTrainingRecordRespVO>> getTrainingRecordList() {
        List<GapTrainingRecordDO> list = trainingRecordService.getTrainingRecordList();
        return success(BeanUtils.toBean(list, GapTrainingRecordRespVO.class));
    }

    @GetMapping("/list-by-plan")
    @Operation(summary = "根据培训计划编号获得培训记录列表")
    @Parameter(name = "planId", description = "培训计划编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:training-record:query')")
    public CommonResult<List<GapTrainingRecordRespVO>> getTrainingRecordListByPlanId(@RequestParam("planId") Long planId) {
        List<GapTrainingRecordDO> list = trainingRecordService.getTrainingRecordListByPlanId(planId);
        return success(BeanUtils.toBean(list, GapTrainingRecordRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出培训记录 Excel")
    @PreAuthorize("@ss.hasPermission('gap:training-record:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrainingRecordExcel(@Valid GapTrainingRecordPageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapTrainingRecordDO> list = trainingRecordService.getTrainingRecordPage(pageReqVO).getList();
        ExcelUtils.write(response, "培训记录.xls", "数据", GapTrainingRecordRespVO.class,
                BeanUtils.toBean(list, GapTrainingRecordRespVO.class));
    }

}
