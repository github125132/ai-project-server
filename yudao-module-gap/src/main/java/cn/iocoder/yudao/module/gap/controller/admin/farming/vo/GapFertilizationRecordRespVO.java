package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP FertilizationRecord Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapFertilizationRecordRespVO {

    @Schema(description = "编号")
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

    @Schema(description = "施肥日期")
    @ExcelProperty("施肥日期")
    private LocalDate fertilizeDate;

    @Schema(description = "肥料类型(0基肥 1追肥 2叶面肥)")
    @ExcelProperty("肥料类型(0基肥 1追肥 2叶面肥)")
    private Integer fertilizeType;

    @Schema(description = "施肥时期")
    @ExcelProperty("施肥时期")
    private String fertilizeStage;

    @Schema(description = "施肥方法")
    @ExcelProperty("施肥方法")
    private String fertilizeMethod;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
