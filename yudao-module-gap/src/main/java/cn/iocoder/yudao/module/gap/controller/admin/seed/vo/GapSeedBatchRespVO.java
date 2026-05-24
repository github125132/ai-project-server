package cn.iocoder.yudao.module.gap.controller.admin.seed.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 种子种苗批次 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapSeedBatchRespVO {

    @Schema(description = "批次编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("批次编号")
    private Long id;

    @Schema(description = "批次号", requiredMode = Schema.RequiredMode.REQUIRED, example = "SB-2024-001")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "类型(0种子 1种苗)")
    @ExcelProperty("类型")
    private Integer seedType;

    @Schema(description = "来源(0自繁 1外购 2野生采集)")
    @ExcelProperty("来源")
    private Integer sourceType;

    @Schema(description = "供应商编号")
    @ExcelProperty("供应商编号")
    private Long supplierId;

    @Schema(description = "数量")
    @ExcelProperty("数量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "采购/采集日期")
    @ExcelProperty("采购/采集日期")
    private LocalDate purchaseDate;

    @Schema(description = "储存位置")
    @ExcelProperty("储存位置")
    private String storageLocation;

    @Schema(description = "储存条件")
    @ExcelProperty("储存条件")
    private String storageCondition;

    @Schema(description = "有效期限")
    @ExcelProperty("有效期限")
    private LocalDate validityPeriod;

    @Schema(description = "基源鉴定编号")
    @ExcelProperty("基源鉴定编号")
    private Long originIdentifyId;

    @Schema(description = "检疫证号")
    @ExcelProperty("检疫证号")
    private String quarantineCertNo;

    @Schema(description = "检疫证书附件")
    @ExcelProperty("检疫证书附件")
    private String quarantineCertUrl;

    @Schema(description = "纯度(%)")
    @ExcelProperty("纯度(%)")
    private BigDecimal purity;

    @Schema(description = "发芽率(%)")
    @ExcelProperty("发芽率(%)")
    private BigDecimal germinationRate;

    @Schema(description = "水分(%)")
    @ExcelProperty("水分(%)")
    private BigDecimal moisture;

    @Schema(description = "净度(%)")
    @ExcelProperty("净度(%)")
    private BigDecimal cleanliness;

    @Schema(description = "状态(0待验 1合格 2不合格 3已使用)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
