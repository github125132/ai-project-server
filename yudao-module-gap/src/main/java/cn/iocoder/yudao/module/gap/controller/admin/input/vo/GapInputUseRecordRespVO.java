package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 投入品使用记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInputUseRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "使用单号")
    @ExcelProperty("使用单号")
    private String recordNo;

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("产品编号")
    private Long productId;

    @Schema(description = "库存编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("库存编号")
    private Long inventoryId;

    @Schema(description = "产品批次号")
    @ExcelProperty("产品批次号")
    private String batchNo;

    @Schema(description = "使用类型(0农药 1肥料 2其他)")
    @ExcelProperty("使用类型")
    private Integer useType;

    @Schema(description = "使用日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("使用日期")
    private LocalDate useDate;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "地块编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("地块编号")
    private Long plotId;

    @Schema(description = "地块种植批次")
    @ExcelProperty("地块种植批次")
    private String plotBatchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "使用量")
    @ExcelProperty("使用量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "稀释倍数")
    @ExcelProperty("稀释倍数")
    private String dilutionRatio;

    @Schema(description = "施用面积(亩)")
    @ExcelProperty("施用面积(亩)")
    private BigDecimal applicationArea;

    @Schema(description = "施用方法")
    @ExcelProperty("施用方法")
    private String applicationMethod;

    @Schema(description = "天气条件")
    @ExcelProperty("天气条件")
    private String weatherCondition;

    @Schema(description = "风向")
    @ExcelProperty("风向")
    private String windDirection;

    @Schema(description = "风速")
    @ExcelProperty("风速")
    private String windSpeed;

    @Schema(description = "气温")
    @ExcelProperty("气温")
    private BigDecimal temperature;

    @Schema(description = "操作人员", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("操作人员")
    private Long operatorId;

    @Schema(description = "安全间隔期(天)")
    @ExcelProperty("安全间隔期(天)")
    private Integer safetyInterval;

    @Schema(description = "最早采收日期")
    @ExcelProperty("最早采收日期")
    private LocalDate earliestHarvestDate;

    @Schema(description = "禁用拦截校验")
    @ExcelProperty("禁用拦截校验")
    private Boolean bannedCheck;

    @Schema(description = "使用现场照片")
    @ExcelProperty("使用现场照片")
    private String photoUrl;

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
