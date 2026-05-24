package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 变更记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapChangeRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "变更单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "CHG-2024001")
    @ExcelProperty("变更单号")
    private String changeNo;

    @Schema(description = "变更类型(0基地 1品种 2工艺 3设备 4人员 5SOP 6供应商)")
    @ExcelProperty("变更类型")
    private Integer changeType;

    @Schema(description = "变更标题", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("变更标题")
    private String changeTitle;

    @Schema(description = "变更描述")
    @ExcelProperty("变更描述")
    private String changeDesc;

    @Schema(description = "变更前状态")
    @ExcelProperty("变更前状态")
    private String beforeStatus;

    @Schema(description = "变更后状态")
    @ExcelProperty("变更后状态")
    private String afterStatus;

    @Schema(description = "影响分析")
    @ExcelProperty("影响分析")
    private String affectAnalysis;

    @Schema(description = "风险评估")
    @ExcelProperty("风险评估")
    private String riskAssessment;

    @Schema(description = "验证计划")
    @ExcelProperty("验证计划")
    private String validationPlan;

    @Schema(description = "提出人")
    @ExcelProperty("提出人")
    private Long proposerId;

    @Schema(description = "提出日期")
    @ExcelProperty("提出日期")
    private LocalDate proposeDate;

    @Schema(description = "计划实施日期")
    @ExcelProperty("计划实施日期")
    private LocalDate plannedDate;

    @Schema(description = "实际实施日期")
    @ExcelProperty("实际实施日期")
    private LocalDate actualDate;

    @Schema(description = "审批人")
    @ExcelProperty("审批人")
    private Long approverId;

    @Schema(description = "审批时间")
    @ExcelProperty("审批时间")
    private LocalDateTime approveTime;

    @Schema(description = "审批意见")
    @ExcelProperty("审批意见")
    private String approveOpinion;

    @Schema(description = "审批流程实例ID")
    @ExcelProperty("审批流程实例ID")
    private String processInstanceId;

    @Schema(description = "状态(0待评估 1评估中 2待审批 3已批准 4已实施 5已验证 6已关闭)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
