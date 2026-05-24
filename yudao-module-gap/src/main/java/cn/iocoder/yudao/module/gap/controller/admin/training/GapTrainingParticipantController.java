package cn.iocoder.yudao.module.gap.controller.admin.training;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingParticipantDO;
import cn.iocoder.yudao.module.gap.service.training.GapTrainingParticipantService;
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
 * 管理后台 - GAP 培训参训人员
 *
 * @author 芋道源码
 */
@Tag(name = "管理后台 - GAP 培训参训人员")
@RestController
@RequestMapping("/gap/training-participant")
@Validated
public class GapTrainingParticipantController {

    @Resource
    private GapTrainingParticipantService trainingParticipantService;

    @PostMapping("/create")
    @Operation(summary = "创建培训参训人员")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:create')")
    public CommonResult<Long> createTrainingParticipant(@Valid @RequestBody GapTrainingParticipantSaveReqVO createReqVO) {
        return success(trainingParticipantService.createTrainingParticipant(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新培训参训人员")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:update')")
    public CommonResult<Boolean> updateTrainingParticipant(@Valid @RequestBody GapTrainingParticipantSaveReqVO updateReqVO) {
        trainingParticipantService.updateTrainingParticipant(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除培训参训人员")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:training-participant:delete')")
    public CommonResult<Boolean> deleteTrainingParticipant(@RequestParam("id") Long id) {
        trainingParticipantService.deleteTrainingParticipant(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得培训参训人员")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:query')")
    public CommonResult<GapTrainingParticipantRespVO> getTrainingParticipant(@RequestParam("id") Long id) {
        GapTrainingParticipantDO trainingParticipant = trainingParticipantService.getTrainingParticipant(id);
        return success(BeanUtils.toBean(trainingParticipant, GapTrainingParticipantRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得培训参训人员分页")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:query')")
    public CommonResult<PageResult<GapTrainingParticipantRespVO>> getTrainingParticipantPage(@Valid GapTrainingParticipantPageReqVO pageReqVO) {
        PageResult<GapTrainingParticipantDO> pageResult = trainingParticipantService.getTrainingParticipantPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTrainingParticipantRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得培训参训人员列表")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:query')")
    public CommonResult<List<GapTrainingParticipantRespVO>> getTrainingParticipantList() {
        List<GapTrainingParticipantDO> list = trainingParticipantService.getTrainingParticipantList();
        return success(BeanUtils.toBean(list, GapTrainingParticipantRespVO.class));
    }

    @GetMapping("/list-by-record")
    @Operation(summary = "根据培训记录编号获得参训人员列表")
    @Parameter(name = "recordId", description = "培训记录编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:query')")
    public CommonResult<List<GapTrainingParticipantRespVO>> getTrainingParticipantListByRecordId(@RequestParam("recordId") Long recordId) {
        List<GapTrainingParticipantDO> list = trainingParticipantService.getTrainingParticipantListByRecordId(recordId);
        return success(BeanUtils.toBean(list, GapTrainingParticipantRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出培训参训人员 Excel")
    @PreAuthorize("@ss.hasPermission('gap:training-participant:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrainingParticipantExcel(@Valid GapTrainingParticipantPageReqVO pageReqVO,
                                               HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapTrainingParticipantDO> list = trainingParticipantService.getTrainingParticipantPage(pageReqVO).getList();
        ExcelUtils.write(response, "培训参训人员.xls", "数据", GapTrainingParticipantRespVO.class,
                BeanUtils.toBean(list, GapTrainingParticipantRespVO.class));
    }

}
