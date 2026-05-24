package cn.iocoder.yudao.module.gap.controller.admin.harvest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 采收计划新增/修改 Request VO")
@Data
public class GapHarvestPlanSaveReqVO {

    @Schema(description = "计划编号", example = "1024")
    private Long id;

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "HP-20240101-001")
    @NotEmpty(message = "计划编号不能为空")
    private String planNo;

    @Schema(description = "种植计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "种植计划编号不能为空")
    private Long plantingPlanId;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "地块编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "地块编号不能为空")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "BATCH-001")
    private String plotBatchNo;

    @Schema(description = "计划采收日期")
    private LocalDate plannedHarvestDate;

    @Schema(description = "计划采收量(kg)", example = "100.00")
    private BigDecimal plannedQuantity;

    @Schema(description = "采收标准")
    private String harvestCriteria;

    @Schema(description = "采收方式", example = "人工采收")
    private String harvestMethod;

    @Schema(description = "采收工具", example = "镰刀、竹筐")
    private String harvestTool;

    @Schema(description = "天气要求", example = "晴天无雨")
    private String weatherRequirement;

    @Schema(description = "采收人员列表", example = "1,2,3")
    private String operatorIds;

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
