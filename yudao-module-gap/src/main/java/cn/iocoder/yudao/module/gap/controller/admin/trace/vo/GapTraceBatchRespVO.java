package cn.iocoder.yudao.module.gap.controller.admin.trace.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 溯源批次 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTraceBatchRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "追溯码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("追溯码")
    private String traceCode;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "品种名称(快照)")
    @ExcelProperty("品种名称")
    private String varietyName;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "基地名称(快照)")
    @ExcelProperty("基地名称")
    private String baseName;

    @Schema(description = "基地地址(快照)")
    @ExcelProperty("基地地址")
    private String baseAddress;

    @Schema(description = "地块编号")
    @ExcelProperty("地块编号")
    private Long plotId;

    @Schema(description = "地块名称(快照)")
    @ExcelProperty("地块名称")
    private String plotName;

    @Schema(description = "种子批次编号")
    @ExcelProperty("种子批次编号")
    private Long seedBatchId;

    @Schema(description = "种植日期")
    @ExcelProperty("种植日期")
    private LocalDate plantingDate;

    @Schema(description = "采收日期")
    @ExcelProperty("采收日期")
    private LocalDate harvestDate;

    @Schema(description = "加工日期")
    @ExcelProperty("加工日期")
    private LocalDate processDate;

    @Schema(description = "包装日期")
    @ExcelProperty("包装日期")
    private LocalDate packageDate;

    @Schema(description = "包装规格")
    @ExcelProperty("包装规格")
    private BigDecimal packageWeight;

    @Schema(description = "总重量(kg)")
    @ExcelProperty("总重量(kg)")
    private BigDecimal totalWeight;

    @Schema(description = "包装件数")
    @ExcelProperty("包装件数")
    private Integer packageCount;

    @Schema(description = "质量状态(0合格 1不合格)")
    @ExcelProperty("质量状态")
    private Integer qualityStatus;

    @Schema(description = "检验报告编号")
    @ExcelProperty("检验报告编号")
    private Long inspectReportId;

    @Schema(description = "放行单编号")
    @ExcelProperty("放行单编号")
    private Long releaseId;

    @Schema(description = "二维码图片")
    @ExcelProperty("二维码图片")
    private String qrCodeUrl;

    @Schema(description = "状态(0种植中 1已采收 2已加工 3已入库 4已放行 5已出库 6已销售)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
