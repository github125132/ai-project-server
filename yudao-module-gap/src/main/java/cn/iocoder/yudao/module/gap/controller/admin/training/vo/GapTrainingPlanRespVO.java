package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训计划 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTrainingPlanRespVO {

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("计划编号")
    private Long id;

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN-2024-001")
    @ExcelProperty("计划编号")
    private String planNo;

    @Schema(description = "年度", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024")
    @ExcelProperty("年度")
    private Integer year;

    @Schema(description = "计划名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024年度GAP法规培训计划")
    @ExcelProperty("计划名称")
    private String planName;

    @Schema(description = "课程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("课程编号")
    private Long courseId;

    @Schema(description = "培训类型(0新员工 1在岗 2转岗 3晋升 4继续教育)")
    @ExcelProperty("培训类型")
    private Integer trainingType;

    @Schema(description = "目标部门")
    @ExcelProperty("目标部门")
    private Long targetDeptId;

    @Schema(description = "目标岗位")
    @ExcelProperty("目标岗位")
    private String targetPostIds;

    @Schema(description = "计划开始日期")
    @ExcelProperty("计划开始日期")
    private LocalDate plannedStartDate;

    @Schema(description = "计划结束日期")
    @ExcelProperty("计划结束日期")
    private LocalDate plannedEndDate;

    @Schema(description = "计划人数")
    @ExcelProperty("计划人数")
    private Integer plannedParticipants;

    @Schema(description = "培训地点")
    @ExcelProperty("培训地点")
    private String trainingLocation;

    @Schema(description = "培训方式")
    @ExcelProperty("培训方式")
    private String trainingMethod;

    @Schema(description = "审批人")
    @ExcelProperty("审批人")
    private Long approverId;

    @Schema(description = "审批时间")
    @ExcelProperty("审批时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3执行中 4已完成)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
