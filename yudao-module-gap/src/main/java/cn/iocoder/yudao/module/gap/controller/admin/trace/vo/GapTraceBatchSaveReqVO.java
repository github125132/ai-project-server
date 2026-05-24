package cn.iocoder.yudao.module.gap.controller.admin.trace.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 溯源批次新增/修改 Request VO")
@Data
public class GapTraceBatchSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "追溯码", requiredMode = Schema.RequiredMode.REQUIRED, example = "TRACE-2024001")
    @NotEmpty(message = "追溯码不能为空")
    private String traceCode;

    @Schema(description = "批次号", example = "BATCH-2024001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "品种名称(快照)", example = "三七")
    private String varietyName;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "基地名称(快照)")
    private String baseName;

    @Schema(description = "基地地址(快照)")
    private String baseAddress;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "地块名称(快照)")
    private String plotName;

    @Schema(description = "种子批次编号", example = "1")
    private Long seedBatchId;

    @Schema(description = "种植日期")
    private LocalDate plantingDate;

    @Schema(description = "采收日期")
    private LocalDate harvestDate;

    @Schema(description = "加工日期")
    private LocalDate processDate;

    @Schema(description = "包装日期")
    private LocalDate packageDate;

    @Schema(description = "包装规格", example = "0.500")
    private BigDecimal packageWeight;

    @Schema(description = "总重量(kg)", example = "1000.00")
    private BigDecimal totalWeight;

    @Schema(description = "包装件数", example = "2000")
    private Integer packageCount;

    @Schema(description = "质量状态(0合格 1不合格)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "质量状态不能为空")
    private Integer qualityStatus;

    @Schema(description = "检验报告编号", example = "1")
    private Long inspectReportId;

    @Schema(description = "放行单编号", example = "1")
    private Long releaseId;

    @Schema(description = "二维码图片")
    private String qrCodeUrl;

    @Schema(description = "状态(0种植中 1已采收 2已加工 3已入库 4已放行 5已出库 6已销售)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
