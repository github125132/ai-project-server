package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 变更记录新增/修改 Request VO")
@Data
public class GapChangeRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "变更单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHG-2024001")
    @NotEmpty(message = "变更单号不能为空")
    private String changeNo;

    @Schema(description = "变更类型(0基地 1品种 2工艺 3设备 4人员 5SOP 6供应商)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "变更类型不能为空")
    private Integer changeType;

    @Schema(description = "变更标题", requiredMode = Schema.RequiredMode.REQUIRED, example = "基地土壤改良方案变更")
    @NotEmpty(message = "变更标题不能为空")
    private String changeTitle;

    @Schema(description = "变更描述")
    private String changeDesc;

    @Schema(description = "变更前状态")
    private String beforeStatus;

    @Schema(description = "变更后状态")
    private String afterStatus;

    @Schema(description = "影响分析")
    private String affectAnalysis;

    @Schema(description = "风险评估")
    private String riskAssessment;

    @Schema(description = "验证计划")
    private String validationPlan;

    @Schema(description = "提出人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "提出人不能为空")
    private Long proposerId;

    @Schema(description = "提出日期")
    private LocalDate proposeDate;

    @Schema(description = "计划实施日期")
    private LocalDate plannedDate;

    @Schema(description = "实际实施日期")
    private LocalDate actualDate;

    @Schema(description = "审批人", example = "2")
    private Long approverId;

    @Schema(description = "审批意见")
    private String approveOpinion;

    @Schema(description = "审批流程实例ID")
    private String processInstanceId;

    @Schema(description = "状态(0待评估 1评估中 2待审批 3已批准 4已实施 5已验证 6已关闭)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
