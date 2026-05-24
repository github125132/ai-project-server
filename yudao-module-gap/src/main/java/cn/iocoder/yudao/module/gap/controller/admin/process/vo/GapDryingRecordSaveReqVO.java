package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 干燥记录新增/修改 Request VO")
@Data
public class GapDryingRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "加工记录编号不能为空")
    private Long processRecordId;

    @Schema(description = "批次号", example = "BATCH-001")
    private String batchNo;

    @Schema(description = "干燥方式(0晒干 1阴干 2烘干 3风干)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "干燥方式不能为空")
    private Integer dryingMethod;

    @Schema(description = "干燥开始时间")
    private LocalDateTime dryingStartTime;

    @Schema(description = "干燥结束时间")
    private LocalDateTime dryingEndTime;

    @Schema(description = "干燥时长(小时)", example = "48")
    private Integer dryingDuration;

    @Schema(description = "初始水分(%)", example = "75.00")
    private BigDecimal initialMoisture;

    @Schema(description = "目标水分(%)", example = "13.00")
    private BigDecimal targetMoisture;

    @Schema(description = "最终水分(%)", example = "12.50")
    private BigDecimal finalMoisture;

    @Schema(description = "最高温度(°C)", example = "60.00")
    private BigDecimal maxTemp;

    @Schema(description = "最低温度(°C)", example = "45.00")
    private BigDecimal minTemp;

    @Schema(description = "平均温度(°C)", example = "52.50")
    private BigDecimal avgTemp;

    @Schema(description = "环境湿度(%)", example = "55.0")
    private BigDecimal humidity;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "水分检测编号", example = "1")
    private Long moistureTestId;

    @Schema(description = "状态(0干燥中 1已完成 2不合格)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
