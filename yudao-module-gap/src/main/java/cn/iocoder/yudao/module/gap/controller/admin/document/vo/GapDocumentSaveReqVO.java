package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 文件档案新增/修改 Request VO")
@Data
public class GapDocumentSaveReqVO {

    @Schema(description = "文件编号", example = "1024")
    private Long id;

    @Schema(description = "文件编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "DOC-001")
    @NotEmpty(message = "文件编号不能为空")
    private String docNo;

    @Schema(description = "文件名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "质量手册V1.0")
    @NotEmpty(message = "文件名称不能为空")
    private String name;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "分类编号不能为空")
    private Long categoryId;

    @Schema(description = "版本号", example = "V1.0")
    private String version;

    @Schema(description = "文件内容/正文")
    private String content;

    @Schema(description = "适用范围")
    private String scope;

    @Schema(description = "起草人", example = "1")
    private Long drafterId;

    @Schema(description = "起草日期")
    private LocalDate draftDate;

    @Schema(description = "审核人", example = "2")
    private Long reviewerId;

    @Schema(description = "审核日期")
    private LocalDate reviewDate;

    @Schema(description = "审核意见")
    private String reviewOpinion;

    @Schema(description = "批准人", example = "3")
    private Long approverId;

    @Schema(description = "批准日期")
    private LocalDate approveDate;

    @Schema(description = "生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "失效日期")
    private LocalDate expiryDate;

    @Schema(description = "文件附件")
    private String fileUrl;

    @Schema(description = "发放范围")
    private String distributionScope;

    @Schema(description = "保存期限(年)", example = "5")
    private Integer retentionPeriod;

    @Schema(description = "是否现行有效")
    private Boolean isEffective;

    @Schema(description = "替代文件编号", example = "0")
    private Long replacedDocId;

    @Schema(description = "状态(0草稿 1审核中 2已批准 3已废止)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
