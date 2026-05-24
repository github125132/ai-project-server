package cn.iocoder.yudao.module.gap.controller.admin.training;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCoursePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCourseRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCourseSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingCourseDO;
import cn.iocoder.yudao.module.gap.service.training.GapTrainingCourseService;
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
 * 管理后台 - GAP 培训课程
 *
 * @author 芋道源码
 */
@Tag(name = "管理后台 - GAP 培训课程")
@RestController
@RequestMapping("/gap/training-course")
@Validated
public class GapTrainingCourseController {

    @Resource
    private GapTrainingCourseService trainingCourseService;

    @PostMapping("/create")
    @Operation(summary = "创建培训课程")
    @PreAuthorize("@ss.hasPermission('gap:training-course:create')")
    public CommonResult<Long> createTrainingCourse(@Valid @RequestBody GapTrainingCourseSaveReqVO createReqVO) {
        return success(trainingCourseService.createTrainingCourse(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新培训课程")
    @PreAuthorize("@ss.hasPermission('gap:training-course:update')")
    public CommonResult<Boolean> updateTrainingCourse(@Valid @RequestBody GapTrainingCourseSaveReqVO updateReqVO) {
        trainingCourseService.updateTrainingCourse(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除培训课程")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:training-course:delete')")
    public CommonResult<Boolean> deleteTrainingCourse(@RequestParam("id") Long id) {
        trainingCourseService.deleteTrainingCourse(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得培训课程")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:training-course:query')")
    public CommonResult<GapTrainingCourseRespVO> getTrainingCourse(@RequestParam("id") Long id) {
        GapTrainingCourseDO trainingCourse = trainingCourseService.getTrainingCourse(id);
        return success(BeanUtils.toBean(trainingCourse, GapTrainingCourseRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得培训课程分页")
    @PreAuthorize("@ss.hasPermission('gap:training-course:query')")
    public CommonResult<PageResult<GapTrainingCourseRespVO>> getTrainingCoursePage(@Valid GapTrainingCoursePageReqVO pageReqVO) {
        PageResult<GapTrainingCourseDO> pageResult = trainingCourseService.getTrainingCoursePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTrainingCourseRespVO.class));
    }

    @GetMapping("/list")
    @Operation(summary = "获得培训课程列表")
    @PreAuthorize("@ss.hasPermission('gap:training-course:query')")
    public CommonResult<List<GapTrainingCourseRespVO>> getTrainingCourseList() {
        List<GapTrainingCourseDO> list = trainingCourseService.getTrainingCourseList();
        return success(BeanUtils.toBean(list, GapTrainingCourseRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出培训课程 Excel")
    @PreAuthorize("@ss.hasPermission('gap:training-course:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrainingCourseExcel(@Valid GapTrainingCoursePageReqVO pageReqVO,
                                          HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<GapTrainingCourseDO> list = trainingCourseService.getTrainingCoursePage(pageReqVO).getList();
        ExcelUtils.write(response, "培训课程.xls", "数据", GapTrainingCourseRespVO.class,
                BeanUtils.toBean(list, GapTrainingCourseRespVO.class));
    }

}
