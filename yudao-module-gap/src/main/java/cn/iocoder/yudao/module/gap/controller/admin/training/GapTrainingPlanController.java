package cn.iocoder.yudao.module.gap.controller.admin.training;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingPlanDO;
import cn.iocoder.yudao.module.gap.service.training.GapTrainingPlanService;
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
 * 管理后台 - GAP 培训计划
 *
 * @author 芋道源码
 */
@Tag(name = "管理后台 - GAP 培训计划")
@RestController
@RequestMapping("/gap/training-plan")
@Validated
public class GapTrainingPlanController {

    @Resource
    private GapTrainingPlanService trainingPlanService;

    @PostMapping("/create")
    @Operation(summary = "创建培训计划")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:create')")
    public CommonResult<Long> createTrainingPlan(@Valid @RequestBody GapTrainingPlanSaveReqVO createReqVO) {
        return success(trainingPlanService.createTrainingPlan(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新培训计划")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:update')")
    public CommonResult<Boolean> updateTrainingPlan(@Valid @RequestBody GapTrainingPlanSaveReqVO updateReqVO) {
        trainingPlanService.updateTrainingPlan(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除培训计划")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:training-plan:delete')")
    public CommonResult<Boolean> deleteTrainingPlan(@RequestParam("id") Long id) {
        trainingPlanService.deleteTrainingPlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得培训计划")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:query')")
    public CommonResult<GapTrainingPlanRespVO> getTrainingPlan(@RequestParam("id") Long id) {
        GapTrainingPlanDO trainingPlan = trainingPlanService.getTrainingPlan(id);
        return success(BeanUtils.toBean(trainingPlan, GapTrainingPlanRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得培训计划分页")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:query')")
    public CommonResult<PageResult<GapTrainingPlanRespVO>> getTrainingPlanPage(@Valid GapTrainingPlanPageReqVO pageReqVO) {
        PageResult<GapTrainingPlanDO> pageResult = trainingPlanService.getTrainingPlanPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTrainingPlanRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得培训计划列表")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:query')")
    public CommonResult<List<GapTrainingPlanRespVO>> getTrainingPlanList() {
        List<GapTrainingPlanDO> list = trainingPlanService.getTrainingPlanList();
        return success(BeanUtils.toBean(list, GapTrainingPlanRespVO.class));
    }

    @GetMapping("/list-by-course")
    @Operation(summary = "根据课程编号获得培训计划列表")
    @Parameter(name = "courseId", description = "课程编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:query')")
    public CommonResult<List<GapTrainingPlanRespVO>> getTrainingPlanListByCourseId(@RequestParam("courseId") Long courseId) {
        List<GapTrainingPlanDO> list = trainingPlanService.getTrainingPlanListByCourseId(courseId);
        return success(BeanUtils.toBean(list, GapTrainingPlanRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出培训计划 Excel")
    @PreAuthorize("@ss.hasPermission('gap:training-plan:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrainingPlanExcel(@Valid GapTrainingPlanPageReqVO pageReqVO,
                                        HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapTrainingPlanDO> list = trainingPlanService.getTrainingPlanPage(pageReqVO).getList();
        ExcelUtils.write(response, "培训计划.xls", "数据", GapTrainingPlanRespVO.class,
                BeanUtils.toBean(list, GapTrainingPlanRespVO.class));
    }

}
