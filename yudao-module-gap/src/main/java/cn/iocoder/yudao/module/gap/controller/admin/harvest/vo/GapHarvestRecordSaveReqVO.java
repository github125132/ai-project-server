package cn.iocoder.yudao.module.gap.controller.admin.harvest.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 采收记录新增/修改 Request VO")
@Data
public class GapHarvestRecordSaveReqVO {

    @Schema(description = "记录编号", example = "1024")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "HR-20240101-001")
    @NotEmpty(message = "记录单号不能为空")
    private String recordNo;

    @Schema(description = "采收计划编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "采收计划编号不能为空")
    private Long harvestPlanId;

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

    @Schema(description = "采收日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "采收日期不能为空")
    private LocalDate harvestDate;

    @Schema(description = "采收时段", example = "08:00-12:00")
    private String harvestTime;

    @Schema(description = "天气情况", example = "晴天")
    private String weather;

    @Schema(description = "气温", example = "25.5")
    private BigDecimal temperature;

    @Schema(description = "采收面积(亩)", example = "5.00")
    private BigDecimal harvestArea;

    @Schema(description = "鲜品重量(kg)", example = "500.00")
    private BigDecimal freshWeight;

    @Schema(description = "采收方式", example = "人工采收")
    private String harvestMethod;

    @Schema(description = "采收工具", example = "镰刀、竹筐")
    private String harvestTool;

    @Schema(description = "采收人员", example = "1,2,3")
    private String operatorIds;

    @Schema(description = "监督人", example = "1")
    private Long supervisorId;

    @Schema(description = "采收批次号(关联追溯)", example = "TRACE-001")
    private String batchNo;

    @Schema(description = "采收合格证号", example = "CERT-001")
    private String harvestCertNo;

    @Schema(description = "采收照片")
    private String photoUrl;

    @Schema(description = "状态(0已采收 1已运送 2已加工)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
