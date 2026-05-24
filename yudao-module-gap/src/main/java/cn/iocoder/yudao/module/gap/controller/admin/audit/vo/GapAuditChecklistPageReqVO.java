package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP audit_checklist分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapAuditChecklistPageReqVO extends PageParam {

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

}
