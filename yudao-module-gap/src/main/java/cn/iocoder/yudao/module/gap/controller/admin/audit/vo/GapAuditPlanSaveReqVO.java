package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP audit_plan新增/修改 Request VO")
@Data
public class GapAuditPlanSaveReqVO {

    @Schema(description = "计划编号", example = "1024")
    private Long id;

    @Schema(description = "计划编号")
    private String planNo;

    @Schema(description = "年度")
    private Integer year;

    @Schema(description = "计划名称")
    private String planName;

    @Schema(description = "审核类型(0内部审核 1管理评审 2专项检查)")
    private Integer auditType;

    @Schema(description = "审核范围")
    private String auditScope;

    @Schema(description = "计划开始日期")
    private LocalDate plannedStartDate;

    @Schema(description = "计划结束日期")
    private LocalDate plannedEndDate;

    @Schema(description = "审核组长")
    private Long auditorLeaderId;

    @Schema(description = "审核组员")
    private String auditorIds;

    @Schema(description = "被审核部门")
    private String auditedDeptIds;

    @Schema(description = "审批人")
    private Long approverId;

    @Schema(description = "审批时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3执行中 4已完成)")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
