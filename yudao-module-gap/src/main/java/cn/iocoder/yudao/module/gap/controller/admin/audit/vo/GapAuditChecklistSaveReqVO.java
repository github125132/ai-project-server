package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP audit_checklist新增/修改 Request VO")
@Data
public class GapAuditChecklistSaveReqVO {

    @Schema(description = "检查表编号", example = "1024")
    private Long id;

    @Schema(description = "检查表编号")
    private String checklistNo;

    @Schema(description = "审核计划编号")
    private Long planId;

    @Schema(description = "检查表名称")
    private String name;

    @Schema(description = "检查章节")
    private String checkChapter;

    @Schema(description = "适用条款")
    private String applicableClauses;

    @Schema(description = "状态")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
