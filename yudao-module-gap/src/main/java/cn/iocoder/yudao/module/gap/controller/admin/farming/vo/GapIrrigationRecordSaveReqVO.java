package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 灌溉记录新增/修改 Request VO")
@Data
public class GapIrrigationRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "记录单号", example = "IR-2024-001")
    private String recordNo;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "地块编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "地块编号不能为空")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "BATCH-001")
    private String plotBatchNo;

    @Schema(description = "灌溉日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "灌溉日期不能为空")
    private LocalDate irrigateDate;

    @Schema(description = "灌溉时段", example = "08:00-10:00")
    private String irrigateTime;

    @Schema(description = "灌溉方式", example = "滴灌")
    private String irrigateMethod;

    @Schema(description = "水源", example = "井水")
    private String waterSource;

    @Schema(description = "用水量(m³)", example = "50.0000")
    private BigDecimal waterVolume;

    @Schema(description = "灌溉面积(亩)", example = "10.0000")
    private BigDecimal irrigateArea;

    @Schema(description = "灌溉前土壤湿度(%)", example = "15.50")
    private BigDecimal soilMoistureBefore;

    @Schema(description = "灌溉后土壤湿度(%)", example = "35.50")
    private BigDecimal soilMoistureAfter;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
