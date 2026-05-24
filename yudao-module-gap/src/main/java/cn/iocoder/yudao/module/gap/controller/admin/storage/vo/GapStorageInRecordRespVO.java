package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 药材入库记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapStorageInRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "入库单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("入库单号")
    private String recordNo;

    @Schema(description = "药材批次号")
    @ExcelProperty("药材批次号")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("加工记录编号")
    private Long processRecordId;

    @Schema(description = "包装记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("包装记录编号")
    private Long packageRecordId;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("仓库编号")
    private Long warehouseId;

    @Schema(description = "分区编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分区编号")
    private Long areaId;

    @Schema(description = "入库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("入库日期")
    private LocalDate inDate;

    @Schema(description = "入库数量(kg)")
    @ExcelProperty("入库数量(kg)")
    private BigDecimal quantity;

    @Schema(description = "包装件数")
    @ExcelProperty("包装件数")
    private Integer packageCount;

    @Schema(description = "质量状态(0待验 1合格 2不合格)")
    @ExcelProperty("质量状态")
    private Integer qualityStatus;

    @Schema(description = "外观检查")
    @ExcelProperty("外观检查")
    private String appearanceCheck;

    @Schema(description = "标签检查")
    @ExcelProperty("标签检查")
    private String labelCheck;

    @Schema(description = "验收人", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("验收人")
    private Long inspectorId;

    @Schema(description = "储存条件")
    @ExcelProperty("储存条件")
    private String storageCondition;

    @Schema(description = "温度(°C)")
    @ExcelProperty("温度(°C)")
    private BigDecimal temperature;

    @Schema(description = "湿度(%)")
    @ExcelProperty("湿度(%)")
    private BigDecimal humidity;

    @Schema(description = "复验日期")
    @ExcelProperty("复验日期")
    private LocalDate reinspectDate;

    @Schema(description = "有效期至")
    @ExcelProperty("有效期至")
    private LocalDate validityDate;

    @Schema(description = "状态(0待验 1已入库 2已移库 3已出库)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
