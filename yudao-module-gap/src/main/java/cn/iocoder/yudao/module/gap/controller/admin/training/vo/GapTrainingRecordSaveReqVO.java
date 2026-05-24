package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训记录新增/修改 Request VO")
@Data
public class GapTrainingRecordSaveReqVO {

    @Schema(description = "记录编号", example = "1024")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "REC-2024-001")
    @NotEmpty(message = "记录单号不能为空")
    private String recordNo;

    @Schema(description = "培训计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "培训计划编号不能为空")
    private Long planId;

    @Schema(description = "课程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "课程编号不能为空")
    private Long courseId;

    @Schema(description = "培训日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "培训日期不能为空")
    private LocalDate trainingDate;

    @Schema(description = "开始时间")
    private LocalDateTime trainingStartTime;

    @Schema(description = "结束时间")
    private LocalDateTime trainingEndTime;

    @Schema(description = "培训地点", example = "公司培训室")
    private String trainingLocation;

    @Schema(description = "讲师", example = "张三")
    private String instructor;

    @Schema(description = "参加人数", example = "45")
    private Integer participantCount;

    @Schema(description = "培训内容快照")
    private String contentSnapshot;

    @Schema(description = "签到表附件")
    private String attendanceUrl;

    @Schema(description = "培训照片")
    private String photoUrl;

    @Schema(description = "状态(0已计划 1已完成 2已考核)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
