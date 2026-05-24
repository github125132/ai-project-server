package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 文件档案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapDocumentRespVO {

    @Schema(description = "文件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("文件编号")
    private Long id;

    @Schema(description = "文件编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("文件编号")
    private String docNo;

    @Schema(description = "文件名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("文件名称")
    private String name;

    @Schema(description = "分类编号")
    @ExcelProperty("分类编号")
    private Long categoryId;

    @Schema(description = "版本号")
    @ExcelProperty("版本号")
    private String version;

    @Schema(description = "文件内容/正文")
    @ExcelProperty("文件内容")
    private String content;

    @Schema(description = "适用范围")
    @ExcelProperty("适用范围")
    private String scope;

    @Schema(description = "起草人")
    @ExcelProperty("起草人")
    private Long drafterId;

    @Schema(description = "起草日期")
    @ExcelProperty("起草日期")
    private LocalDate draftDate;

    @Schema(description = "审核人")
    @ExcelProperty("审核人")
    private Long reviewerId;

    @Schema(description = "审核日期")
    @ExcelProperty("审核日期")
    private LocalDate reviewDate;

    @Schema(description = "审核意见")
    @ExcelProperty("审核意见")
    private String reviewOpinion;

    @Schema(description = "批准人")
    @ExcelProperty("批准人")
    private Long approverId;

    @Schema(description = "批准日期")
    @ExcelProperty("批准日期")
    private LocalDate approveDate;

    @Schema(description = "生效日期")
    @ExcelProperty("生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "失效日期")
    @ExcelProperty("失效日期")
    private LocalDate expiryDate;

    @Schema(description = "文件附件")
    @ExcelProperty("文件附件")
    private String fileUrl;

    @Schema(description = "发放范围")
    @ExcelProperty("发放范围")
    private String distributionScope;

    @Schema(description = "保存期限(年)")
    @ExcelProperty("保存期限(年)")
    private Integer retentionPeriod;

    @Schema(description = "是否现行有效")
    @ExcelProperty("是否现行有效")
    private Boolean isEffective;

    @Schema(description = "替代文件编号")
    @ExcelProperty("替代文件编号")
    private Long replacedDocId;

    @Schema(description = "状态(0草稿 1审核中 2已批准 3已废止)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
