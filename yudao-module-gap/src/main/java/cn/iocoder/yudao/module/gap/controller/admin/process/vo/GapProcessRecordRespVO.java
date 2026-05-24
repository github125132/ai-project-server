package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 加工记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapProcessRecordRespVO {

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("记录编号")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "采收记录编号")
    @ExcelProperty("采收记录编号")
    private Long harvestRecordId;

    @Schema(description = "加工批次号")
    @ExcelProperty("加工批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "加工日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("加工日期")
    private LocalDate processDate;

    @Schema(description = "加工场所")
    @ExcelProperty("加工场所")
    private String processLocation;

    @Schema(description = "鲜品投入量(kg)")
    @ExcelProperty("鲜品投入量(kg)")
    private BigDecimal freshWeightIn;

    @Schema(description = "干品产出量(kg)")
    @ExcelProperty("干品产出量(kg)")
    private BigDecimal dryWeightOut;

    @Schema(description = "出成率(%)")
    @ExcelProperty("出成率(%)")
    private BigDecimal yieldRate;

    @Schema(description = "加工SOP编号")
    @ExcelProperty("加工SOP编号")
    private Long sopId;

    @Schema(description = "操作人员")
    @ExcelProperty("操作人员")
    private String operatorIds;

    @Schema(description = "监督人")
    @ExcelProperty("监督人")
    private Long supervisorId;

    @Schema(description = "加工开始时间")
    @ExcelProperty("加工开始时间")
    private LocalDateTime processStartTime;

    @Schema(description = "加工结束时间")
    @ExcelProperty("加工结束时间")
    private LocalDateTime processEndTime;

    @Schema(description = "使用设备编号")
    @ExcelProperty("使用设备编号")
    private String equipmentIds;

    @Schema(description = "用水来源")
    @ExcelProperty("用水来源")
    private String waterSource;

    @Schema(description = "水质检测编号")
    @ExcelProperty("水质检测编号")
    private Long waterTestId;

    @Schema(description = "状态(0加工中 1已完成 2检验中)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
