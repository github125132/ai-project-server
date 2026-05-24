package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 加工工序明细新增/修改 Request VO")
@Data
public class GapProcessDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "加工记录编号不能为空")
    private Long processRecordId;

    @Schema(description = "工序序号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "工序序号不能为空")
    private Integer processStep;

    @Schema(description = "工序名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "清洗")
    @NotEmpty(message = "工序名称不能为空")
    private String processName;

    @Schema(description = "开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    private LocalDateTime endTime;

    @Schema(description = "时长(分钟)", example = "30")
    private Integer duration;

    @Schema(description = "温度(°C)", example = "60.00")
    private BigDecimal temperature;

    @Schema(description = "湿度(%)", example = "65.0")
    private BigDecimal humidity;

    @Schema(description = "工艺参数", example = "水温40°C")
    private String parameter;

    @Schema(description = "工序前重量(kg)", example = "100.00")
    private BigDecimal weightBefore;

    @Schema(description = "工序后重量(kg)", example = "95.00")
    private BigDecimal weightAfter;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "监督人", example = "1")
    private Long supervisorId;

    @Schema(description = "检查结果(0合格 1不合格)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "检查结果不能为空")
    private Integer checkResult;

    @Schema(description = "备注")
    private String remark;

}
