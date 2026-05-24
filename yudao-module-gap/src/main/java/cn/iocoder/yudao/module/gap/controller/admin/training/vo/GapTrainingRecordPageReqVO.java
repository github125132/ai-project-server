package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 培训记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTrainingRecordPageReqVO extends PageParam {

    @Schema(description = "记录单号", example = "REC-2024-001")
    private String recordNo;

    @Schema(description = "培训计划编号", example = "1")
    private Long planId;

    @Schema(description = "课程编号", example = "1")
    private Long courseId;

    @Schema(description = "培训日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] trainingDate;

    @Schema(description = "状态(0已计划 1已完成 2已考核)", example = "0")
    private Integer status;

}
