package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 干燥记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapDryingRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("加工记录编号")
    private Long processRecordId;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "干燥方式(0晒干 1阴干 2烘干 3风干)")
    @ExcelProperty("干燥方式")
    private Integer dryingMethod;

    @Schema(description = "干燥开始时间")
    @ExcelProperty("干燥开始时间")
    private LocalDateTime dryingStartTime;

    @Schema(description = "干燥结束时间")
    @ExcelProperty("干燥结束时间")
    private LocalDateTime dryingEndTime;

    @Schema(description = "干燥时长(小时)")
    @ExcelProperty("干燥时长(小时)")
    private Integer dryingDuration;

    @Schema(description = "初始水分(%)")
    @ExcelProperty("初始水分(%)")
    private BigDecimal initialMoisture;

    @Schema(description = "目标水分(%)")
    @ExcelProperty("目标水分(%)")
    private BigDecimal targetMoisture;

    @Schema(description = "最终水分(%)")
    @ExcelProperty("最终水分(%)")
    private BigDecimal finalMoisture;

    @Schema(description = "最高温度(°C)")
    @ExcelProperty("最高温度(°C)")
    private BigDecimal maxTemp;

    @Schema(description = "最低温度(°C)")
    @ExcelProperty("最低温度(°C)")
    private BigDecimal minTemp;

    @Schema(description = "平均温度(°C)")
    @ExcelProperty("平均温度(°C)")
    private BigDecimal avgTemp;

    @Schema(description = "环境湿度(%)")
    @ExcelProperty("环境湿度(%)")
    private BigDecimal humidity;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "水分检测编号")
    @ExcelProperty("水分检测编号")
    private Long moistureTestId;

    @Schema(description = "状态(0干燥中 1已完成 2不合格)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
