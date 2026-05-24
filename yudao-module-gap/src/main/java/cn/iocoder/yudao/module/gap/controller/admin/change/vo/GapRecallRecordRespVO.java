package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 召回记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapRecallRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "召回编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("召回编号")
    private String recallNo;

    @Schema(description = "召回日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("召回日期")
    private LocalDate recallDate;

    @Schema(description = "召回批次号")
    @ExcelProperty("召回批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "召回原因")
    @ExcelProperty("召回原因")
    private String recallReason;

    @Schema(description = "召回范围")
    @ExcelProperty("召回范围")
    private String recallScope;

    @Schema(description = "召回数量(kg)")
    @ExcelProperty("召回数量(kg)")
    private BigDecimal recallQuantity;

    @Schema(description = "召回方式")
    @ExcelProperty("召回方式")
    private String recallMethod;

    @Schema(description = "召回进度(%)")
    @ExcelProperty("召回进度(%)")
    private BigDecimal recallProgress;

    @Schema(description = "已召回数量(kg)")
    @ExcelProperty("已召回数量(kg)")
    private BigDecimal recalledQuantity;

    @Schema(description = "销毁数量(kg)")
    @ExcelProperty("销毁数量(kg)")
    private BigDecimal destroyQuantity;

    @Schema(description = "处理结果")
    @ExcelProperty("处理结果")
    private String handleResult;

    @Schema(description = "处理人")
    @ExcelProperty("处理人")
    private Long handlerId;

    @Schema(description = "关闭日期")
    @ExcelProperty("关闭日期")
    private LocalDate closeDate;

    @Schema(description = "状态(0启动 1进行中 2已完成 3已关闭)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
