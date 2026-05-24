package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTrainingRecordRespVO {

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("记录编号")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "REC-2024-001")
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "培训计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("培训计划编号")
    private Long planId;

    @Schema(description = "课程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("课程编号")
    private Long courseId;

    @Schema(description = "培训日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("培训日期")
    private LocalDate trainingDate;

    @Schema(description = "开始时间")
    @ExcelProperty("开始时间")
    private LocalDateTime trainingStartTime;

    @Schema(description = "结束时间")
    @ExcelProperty("结束时间")
    private LocalDateTime trainingEndTime;

    @Schema(description = "培训地点")
    @ExcelProperty("培训地点")
    private String trainingLocation;

    @Schema(description = "讲师")
    @ExcelProperty("讲师")
    private String instructor;

    @Schema(description = "参加人数")
    @ExcelProperty("参加人数")
    private Integer participantCount;

    @Schema(description = "培训内容快照")
    @ExcelProperty("培训内容快照")
    private String contentSnapshot;

    @Schema(description = "签到表附件")
    @ExcelProperty("签到表附件")
    private String attendanceUrl;

    @Schema(description = "培训照片")
    @ExcelProperty("培训照片")
    private String photoUrl;

    @Schema(description = "状态(0已计划 1已完成 2已考核)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
