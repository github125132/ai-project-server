package cn.iocoder.yudao.module.gap.controller.admin.treatment.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 种子处理记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapSeedTreatmentRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "种子批次编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("种子批次编号")
    private Long seedBatchId;

    @Schema(description = "处理方式(0消毒 1浸种 2催芽 3包衣)")
    @ExcelProperty("处理方式")
    private Integer treatmentType;

    @Schema(description = "处理日期")
    @ExcelProperty("处理日期")
    private LocalDate treatmentDate;

    @Schema(description = "处理方法")
    @ExcelProperty("处理方法")
    private String method;

    @Schema(description = "药剂名称")
    @ExcelProperty("药剂名称")
    private String medicineName;

    @Schema(description = "药剂用量")
    @ExcelProperty("药剂用量")
    private String medicineDosage;

    @Schema(description = "处理时长")
    @ExcelProperty("处理时长")
    private String duration;

    @Schema(description = "操作人员")
    @ExcelProperty("操作人员")
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
