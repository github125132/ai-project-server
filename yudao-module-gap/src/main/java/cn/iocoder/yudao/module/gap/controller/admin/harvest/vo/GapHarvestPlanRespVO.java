package cn.iocoder.yudao.module.gap.controller.admin.harvest.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 采收计划 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapHarvestPlanRespVO {

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("计划编号")
    private Long id;

    @Schema(description = "计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "HP-20240101-001")
    @ExcelProperty("计划编号")
    private String planNo;

    @Schema(description = "种植计划编号")
    @ExcelProperty("种植计划编号")
    private Long plantingPlanId;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "地块编号")
    @ExcelProperty("地块编号")
    private Long plotId;

    @Schema(description = "地块种植批次")
    @ExcelProperty("地块种植批次")
    private String plotBatchNo;

    @Schema(description = "计划采收日期")
    @ExcelProperty("计划采收日期")
    private LocalDate plannedHarvestDate;

    @Schema(description = "计划采收量(kg)")
    @ExcelProperty("计划采收量(kg)")
    private BigDecimal plannedQuantity;

    @Schema(description = "采收标准")
    @ExcelProperty("采收标准")
    private String harvestCriteria;

    @Schema(description = "采收方式")
    @ExcelProperty("采收方式")
    private String harvestMethod;

    @Schema(description = "采收工具")
    @ExcelProperty("采收工具")
    private String harvestTool;

    @Schema(description = "天气要求")
    @ExcelProperty("天气要求")
    private String weatherRequirement;

    @Schema(description = "采收人员列表")
    @ExcelProperty("采收人员列表")
    private String operatorIds;

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
