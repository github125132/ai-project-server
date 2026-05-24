package cn.iocoder.yudao.module.gap.controller.admin.harvest.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 采收记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapHarvestRecordRespVO {

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("记录编号")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "采收计划编号")
    @ExcelProperty("采收计划编号")
    private Long harvestPlanId;

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

    @Schema(description = "采收日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("采收日期")
    private LocalDate harvestDate;

    @Schema(description = "采收时段")
    @ExcelProperty("采收时段")
    private String harvestTime;

    @Schema(description = "天气情况")
    @ExcelProperty("天气情况")
    private String weather;

    @Schema(description = "气温")
    @ExcelProperty("气温")
    private BigDecimal temperature;

    @Schema(description = "采收面积(亩)")
    @ExcelProperty("采收面积(亩)")
    private BigDecimal harvestArea;

    @Schema(description = "鲜品重量(kg)")
    @ExcelProperty("鲜品重量(kg)")
    private BigDecimal freshWeight;

    @Schema(description = "采收方式")
    @ExcelProperty("采收方式")
    private String harvestMethod;

    @Schema(description = "采收工具")
    @ExcelProperty("采收工具")
    private String harvestTool;

    @Schema(description = "采收人员")
    @ExcelProperty("采收人员")
    private String operatorIds;

    @Schema(description = "监督人")
    @ExcelProperty("监督人")
    private Long supervisorId;

    @Schema(description = "采收批次号(关联追溯)")
    @ExcelProperty("采收批次号")
    private String batchNo;

    @Schema(description = "采收合格证号")
    @ExcelProperty("采收合格证号")
    private String harvestCertNo;

    @Schema(description = "采收照片")
    @ExcelProperty("采收照片")
    private String photoUrl;

    @Schema(description = "状态(0已采收 1已运送 2已加工)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
