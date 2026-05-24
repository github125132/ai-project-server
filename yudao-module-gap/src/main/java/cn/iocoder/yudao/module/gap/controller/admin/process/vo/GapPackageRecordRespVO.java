package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 包装记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapPackageRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("加工记录编号")
    private Long processRecordId;

    @Schema(description = "记录单号")
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "包装日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("包装日期")
    private LocalDate packageDate;

    @Schema(description = "包装材料")
    @ExcelProperty("包装材料")
    private String packageMaterial;

    @Schema(description = "包材批次号")
    @ExcelProperty("包材批次号")
    private String materialBatchNo;

    @Schema(description = "包装规格(kg/包)")
    @ExcelProperty("包装规格(kg/包)")
    private BigDecimal packageWeight;

    @Schema(description = "包装数量")
    @ExcelProperty("包装数量")
    private Integer packageCount;

    @Schema(description = "总重量(kg)")
    @ExcelProperty("总重量(kg)")
    private BigDecimal totalWeight;

    @Schema(description = "标签内容")
    @ExcelProperty("标签内容")
    private String labelContent;

    @Schema(description = "标签样张附件")
    @ExcelProperty("标签样张附件")
    private String labelSampleUrl;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "监督人")
    @ExcelProperty("监督人")
    private Long supervisorId;

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
