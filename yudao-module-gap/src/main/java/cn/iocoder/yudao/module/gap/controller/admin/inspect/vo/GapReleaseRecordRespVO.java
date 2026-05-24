package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP ReleaseRecord Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapReleaseRecordRespVO {

    @Schema(description = "编号")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "放行单号")
    @ExcelProperty("放行单号")
    private String releaseNo;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "来源类型(0加工 1入库)")
    @ExcelProperty("来源类型(0加工 1入库)")
    private Integer sourceType;

    @Schema(description = "来源记录编号")
    @ExcelProperty("来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "数量(kg)")
    @ExcelProperty("数量(kg)")
    private BigDecimal quantity;

    @Schema(description = "检验报告编号")
    @ExcelProperty("检验报告编号")
    private Long inspectReportId;

    @Schema(description = "检验结论(0合格 1不合格)")
    @ExcelProperty("检验结论(0合格 1不合格)")
    private Integer inspectConclusion;

    @Schema(description = "放行审核项目")
    @ExcelProperty("放行审核项目")
    private String releaseItems;

    @Schema(description = "质量审核人")
    @ExcelProperty("质量审核人")
    private Long qualityReviewerId;

    @Schema(description = "质量审核时间")
    @ExcelProperty("质量审核时间")
    private LocalDateTime qualityReviewTime;

    @Schema(description = "质量审核意见")
    @ExcelProperty("质量审核意见")
    private String qualityReviewOpinion;

    @Schema(description = "批准人")
    @ExcelProperty("批准人")
    private Long approverId;

    @Schema(description = "批准时间")
    @ExcelProperty("批准时间")
    private LocalDateTime approveTime;

    @Schema(description = "批准意见")
    @ExcelProperty("批准意见")
    private String approveOpinion;

    @Schema(description = "状态(0待审核 1质量审核通过 2已批准 3拒绝)")
    @ExcelProperty("状态(0待审核 1质量审核通过 2已批准 3拒绝)")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
