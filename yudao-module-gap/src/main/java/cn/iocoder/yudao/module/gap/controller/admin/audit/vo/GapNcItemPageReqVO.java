package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP nc_item分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapNcItemPageReqVO extends PageParam {

    @Schema(description = "不符合项编号")
    private String ncNo;

    @Schema(description = "审核计划编号")
    private Long planId;

    @Schema(description = "检查表编号")
    private Long checklistId;

    @Schema(description = "检查项目编号")
    private Long checklistItemId;

    @Schema(description = "不符合类型(0一般 1严重)")
    private Integer ncType;

    @Schema(description = "不符合描述")
    private String ncDesc;

    @Schema(description = "引用条款")
    private String clauseReference;

    @Schema(description = "证据")
    private String evidence;

    @Schema(description = "责任部门")
    private Long auditedDeptId;

    @Schema(description = "责任人")
    private Long responsibleUserId;

    @Schema(description = "根本原因分析")
    private String rootCause;

    @Schema(description = "纠正措施")
    private String correctiveAction;

    @Schema(description = "纠正期限")
    private LocalDate correctiveDeadline;

    @Schema(description = "纠正完成日期")
    private LocalDate correctiveCompletionDate;

    @Schema(description = "预防措施")
    private String preventiveAction;

    @Schema(description = "预防期限")
    private LocalDate preventiveDeadline;

    @Schema(description = "预防完成日期")
    private LocalDate preventiveCompletionDate;

    @Schema(description = "验证人")
    private Long verifierId;

    @Schema(description = "验证日期")
    private LocalDate verifyDate;

    @Schema(description = "验证结果(0待验证 1有效 2无效)")
    private Integer verifyResult;

    @Schema(description = "验证意见")
    private String verifyOpinion;

    @Schema(description = "状态(0待整改 1整改中 2待验证 3已关闭)")
    private Integer status;

}
