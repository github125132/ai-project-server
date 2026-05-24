package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 农事记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapFarmingRecordPageReqVO extends PageParam {

    @Schema(description = "记录单号", example = "FR-2024-001")
    private String recordNo;

    @Schema(description = "农事类型(0整地 1播种 2育苗 3移栽 4中耕 5除草 6灌溉 7施肥 8整枝 9覆盖 10病虫害防治 11采收)", example = "0")
    private Integer recordType;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "BATCH-001")
    private String plotBatchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "操作日期开始")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate operateDateStart;

    @Schema(description = "操作日期结束")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate operateDateEnd;

    @Schema(description = "状态(0草稿 1已提交 2已审核)", example = "0")
    private Integer status;

}
