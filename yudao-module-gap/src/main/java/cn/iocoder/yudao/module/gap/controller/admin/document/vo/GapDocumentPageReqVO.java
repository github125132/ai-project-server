package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 文件档案分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapDocumentPageReqVO extends PageParam {

    @Schema(description = "分类编号", example = "1")
    private Long categoryId;

    @Schema(description = "文件编号", example = "DOC-001")
    private String docNo;

    @Schema(description = "文件名称", example = "质量手册")
    private String name;

    @Schema(description = "状态(0草稿 1审核中 2已批准 3已废止)", example = "0")
    private Integer status;

    @Schema(description = "起草人", example = "1")
    private Long drafterId;

    @Schema(description = "批准人", example = "3")
    private Long approverId;

}
