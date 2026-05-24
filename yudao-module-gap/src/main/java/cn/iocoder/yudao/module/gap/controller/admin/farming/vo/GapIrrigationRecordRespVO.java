package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 灌溉记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapIrrigationRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "记录单号")
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "地块编号")
    @ExcelProperty("地块编号")
    private Long plotId;

    @Schema(description = "地块种植批次")
    @ExcelProperty("地块种植批次")
    private String plotBatchNo;

    @Schema(description = "灌溉日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("灌溉日期")
    private LocalDate irrigateDate;

    @Schema(description = "灌溉时段")
    @ExcelProperty("灌溉时段")
    private String irrigateTime;

    @Schema(description = "灌溉方式")
    @ExcelProperty("灌溉方式")
    private String irrigateMethod;

    @Schema(description = "水源")
    @ExcelProperty("水源")
    private String waterSource;

    @Schema(description = "用水量(m³)")
    @ExcelProperty("用水量(m³)")
    private BigDecimal waterVolume;

    @Schema(description = "灌溉面积(亩)")
    @ExcelProperty("灌溉面积(亩)")
    private BigDecimal irrigateArea;

    @Schema(description = "灌溉前土壤湿度(%)")
    @ExcelProperty("灌溉前土壤湿度(%)")
    private BigDecimal soilMoistureBefore;

    @Schema(description = "灌溉后土壤湿度(%)")
    @ExcelProperty("灌溉后土壤湿度(%)")
    private BigDecimal soilMoistureAfter;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
