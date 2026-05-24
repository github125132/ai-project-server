package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 召回记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapRecallRecordPageReqVO extends PageParam {

    @Schema(description = "召回编号", example = "RCL-2024001")
    private String recallNo;

    @Schema(description = "状态(0启动 1进行中 2已完成 3已关闭)", example = "0")
    private Integer status;

    @Schema(description = "召回批次号", example = "BATCH-2024001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "召回日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] recallDate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
