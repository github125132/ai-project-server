package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP audit_checklist_item分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapAuditChecklistItemPageReqVO extends PageParam {

    @Schema(description = "检查表编号")
    private Long checklistId;

    @Schema(description = "项目编号")
    private String itemNo;

    @Schema(description = "章节")
    private String chapter;

    @Schema(description = "条款")
    private String clause;

    @Schema(description = "检查内容")
    private String checkContent;

    @Schema(description = "检查方法")
    private String checkMethod;

    @Schema(description = "检查标准")
    private String checkStandard;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "状态")
    private Integer status;

}
