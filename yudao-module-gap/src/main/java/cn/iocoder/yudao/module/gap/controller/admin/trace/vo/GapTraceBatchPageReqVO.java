package cn.iocoder.yudao.module.gap.controller.admin.trace.vo;

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

@Schema(description = "管理后台 - GAP 溯源批次分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTraceBatchPageReqVO extends PageParam {

    @Schema(description = "追溯码", example = "TRACE-2024001")
    private String traceCode;

    @Schema(description = "批次号", example = "BATCH-2024001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "状态(0种植中 1已采收 2已加工 3已入库 4已放行 5已出库 6已销售)", example = "0")
    private Integer status;

    @Schema(description = "质量状态(0合格 1不合格)", example = "0")
    private Integer qualityStatus;

    @Schema(description = "种植日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] plantingDate;

    @Schema(description = "采收日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] harvestDate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
