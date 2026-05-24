package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 关键数据复核记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapDataReviewRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "表名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("表名")
    private String tableName;

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录编号")
    private Long recordId;

    @Schema(description = "记录单号")
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "复核类型(0录入复核 1定期复核 2专项复核)")
    @ExcelProperty("复核类型")
    private Integer reviewType;

    @Schema(description = "复核内容")
    @ExcelProperty("复核内容")
    private String reviewContent;

    @Schema(description = "复核结果(0合格 1不合格)")
    @ExcelProperty("复核结果")
    private Integer reviewResult;

    @Schema(description = "发现问题")
    @ExcelProperty("发现问题")
    private String findings;

    @Schema(description = "复核人")
    @ExcelProperty("复核人")
    private Long reviewerId;

    @Schema(description = "复核时间")
    @ExcelProperty("复核时间")
    private LocalDateTime reviewTime;

    @Schema(description = "纠正措施")
    @ExcelProperty("纠正措施")
    private String correctiveAction;

    @Schema(description = "状态(0待复核 1已复核 2已纠正)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
