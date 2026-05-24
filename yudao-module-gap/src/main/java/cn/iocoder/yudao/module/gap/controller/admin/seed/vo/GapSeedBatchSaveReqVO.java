package cn.iocoder.yudao.module.gap.controller.admin.seed.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 种子种苗批次新增/修改 Request VO")
@Data
public class GapSeedBatchSaveReqVO {

    @Schema(description = "批次编号", example = "1024")
    private Long id;

    @Schema(description = "批次号", requiredMode = Schema.RequiredMode.REQUIRED, example = "SB-2024-001")
    @NotEmpty(message = "批次号不能为空")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "类型(0种子 1种苗)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "类型不能为空")
    private Integer seedType;

    @Schema(description = "来源(0自繁 1外购 2野生采集)", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "来源不能为空")
    private Integer sourceType;

    @Schema(description = "供应商编号", example = "1")
    private Long supplierId;

    @Schema(description = "数量", example = "100.0000")
    private BigDecimal quantity;

    @Schema(description = "单位", example = "kg")
    private String unit;

    @Schema(description = "采购/采集日期")
    private LocalDate purchaseDate;

    @Schema(description = "储存位置", example = "1号冷库A区")
    private String storageLocation;

    @Schema(description = "储存条件", example = "低温干燥")
    private String storageCondition;

    @Schema(description = "有效期限")
    private LocalDate validityPeriod;

    @Schema(description = "基源鉴定编号", example = "1")
    private Long originIdentifyId;

    @Schema(description = "检疫证号", example = "QZ-2024-001")
    private String quarantineCertNo;

    @Schema(description = "检疫证书附件")
    private String quarantineCertUrl;

    @Schema(description = "纯度(%)", example = "98.50")
    private BigDecimal purity;

    @Schema(description = "发芽率(%)", example = "95.00")
    private BigDecimal germinationRate;

    @Schema(description = "水分(%)", example = "12.50")
    private BigDecimal moisture;

    @Schema(description = "净度(%)", example = "99.00")
    private BigDecimal cleanliness;

    @Schema(description = "状态(0待验 1合格 2不合格 3已使用)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
