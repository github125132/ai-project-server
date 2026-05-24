package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 种植计划新增/修改 Request VO")
@Data
public class GapPlantingPlanSaveReqVO {

    @Schema(description = "计划编号", example = "1024")
    private Long id;

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PLAN-2024-001")
    @NotEmpty(message = "计划编号不能为空")
    private String planNo;

    @Schema(description = "年度", requiredMode = Schema.RequiredMode.REQUIRED, example = "2024")
    @NotNull(message = "年度不能为空")
    private Integer year;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "地块编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "地块编号不能为空")
    private Long plotId;

    @Schema(description = "计划面积(亩)", example = "10.0000")
    private BigDecimal plannedArea;

    @Schema(description = "计划产量(kg)", example = "500.0000")
    private BigDecimal plannedQuantity;

    @Schema(description = "种子批次编号", example = "1")
    private Long seedBatchId;

    @Schema(description = "种子用量", example = "2.5000")
    private BigDecimal seedQuantity;

    @Schema(description = "种子单位", example = "kg")
    private String seedUnit;

    @Schema(description = "计划种植日期")
    private LocalDate plannedPlantDate;

    @Schema(description = "计划采收日期")
    private LocalDate plannedHarvestDate;

    @Schema(description = "种植方式", example = "条播")
    private String plantingMethod;

    @Schema(description = "种植密度", example = "行距30cm×株距20cm")
    private String plantingDensity;

    @Schema(description = "轮作作物", example = "玉米")
    private String rotationCrop;

    @Schema(description = "审批人", example = "1")
    private Long approverId;

    @Schema(description = "审批时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3已执行 4已取消)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
