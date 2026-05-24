package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 种植计划 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapPlantingPlanRespVO {

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("计划编号")
    private Long id;

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN-2024-001")
    @ExcelProperty("计划编号")
    private String planNo;

    @Schema(description = "年度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("年度")
    private Integer year;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "地块编号")
    @ExcelProperty("地块编号")
    private Long plotId;

    @Schema(description = "计划面积(亩)")
    @ExcelProperty("计划面积(亩)")
    private BigDecimal plannedArea;

    @Schema(description = "计划产量(kg)")
    @ExcelProperty("计划产量(kg)")
    private BigDecimal plannedQuantity;

    @Schema(description = "种子批次编号")
    @ExcelProperty("种子批次编号")
    private Long seedBatchId;

    @Schema(description = "种子用量")
    @ExcelProperty("种子用量")
    private BigDecimal seedQuantity;

    @Schema(description = "种子单位")
    @ExcelProperty("种子单位")
    private String seedUnit;

    @Schema(description = "计划种植日期")
    @ExcelProperty("计划种植日期")
    private LocalDate plannedPlantDate;

    @Schema(description = "计划采收日期")
    @ExcelProperty("计划采收日期")
    private LocalDate plannedHarvestDate;

    @Schema(description = "种植方式")
    @ExcelProperty("种植方式")
    private String plantingMethod;

    @Schema(description = "种植密度")
    @ExcelProperty("种植密度")
    private String plantingDensity;

    @Schema(description = "轮作作物")
    @ExcelProperty("轮作作物")
    private String rotationCrop;

    @Schema(description = "审批人")
    @ExcelProperty("审批人")
    private Long approverId;

    @Schema(description = "审批时间")
    @ExcelProperty("审批时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3已执行 4已取消)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
