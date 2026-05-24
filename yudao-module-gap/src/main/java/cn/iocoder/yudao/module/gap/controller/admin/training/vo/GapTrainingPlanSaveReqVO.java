package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训计划新增/修改 Request VO")
@Data
public class GapTrainingPlanSaveReqVO {

    @Schema(description = "计划编号", example = "1024")
    private Long id;

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN-2024-001")
    @NotEmpty(message = "计划编号不能为空")
    private String planNo;

    @Schema(description = "年度", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024")
    @NotNull(message = "年度不能为空")
    private Integer year;

    @Schema(description = "计划名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024年度GAP法规培训计划")
    @NotEmpty(message = "计划名称不能为空")
    private String planName;

    @Schema(description = "课程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "课程编号不能为空")
    private Long courseId;

    @Schema(description = "培训类型(0新员工 1在岗 2转岗 3晋升 4继续教育)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "培训类型不能为空")
    private Integer trainingType;

    @Schema(description = "目标部门", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "目标部门不能为空")
    private Long targetDeptId;

    @Schema(description = "目标岗位", example = "1,2,3")
    private String targetPostIds;

    @Schema(description = "计划开始日期")
    private LocalDate plannedStartDate;

    @Schema(description = "计划结束日期")
    private LocalDate plannedEndDate;

    @Schema(description = "计划人数", example = "50")
    private Integer plannedParticipants;

    @Schema(description = "培训地点", example = "公司培训室")
    private String trainingLocation;

    @Schema(description = "培训方式", example = "线下授课")
    private String trainingMethod;

    @Schema(description = "审批人", example = "1")
    private Long approverId;

    @Schema(description = "审批时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3执行中 4已完成)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
