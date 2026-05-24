package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 灌溉记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapIrrigationRecordPageReqVO extends PageParam {

    @Schema(description = "记录单号", example = "IR-2024-001")
    private String recordNo;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "BATCH-001")
    private String plotBatchNo;

    @Schema(description = "灌溉方式", example = "滴灌")
    private String irrigateMethod;

    @Schema(description = "灌溉日期开始")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate irrigateDateStart;

    @Schema(description = "灌溉日期结束")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate irrigateDateEnd;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
