package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP InspectReport新增/修改 Request VO")
@Data
public class GapInspectReportSaveReqVO {

    @Schema(description = "报告编号", example = "1024")
    private Long id;

    @Schema(description = "报告编号")
    private String reportNo;

    @Schema(description = "检验任务编号")
    private Long taskId;

    @Schema(description = "批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    private Long varietyId;

    @Schema(description = "样品编号")
    private String sampleNo;

    @Schema(description = "报告类型(0全检 1委托 2抽检)")
    private Integer reportType;

    @Schema(description = "检验机构")
    private String inspectOrg;

    @Schema(description = "检验日期")
    private LocalDate inspectDate;

    @Schema(description = "报告日期")
    private LocalDate reportDate;

    @Schema(description = "综合结论(0合格 1不合格)")
    private Integer overallConclusion;

    @Schema(description = "综合结论描述")
    private String overallConclusionDesc;

    @Schema(description = "报告附件")
    private String reportUrl;

    @Schema(description = "检验人")
    private Long inspectorId;

    @Schema(description = "复核人")
    private Long reviewerId;

    @Schema(description = "批准人")
    private Long approverId;

    @Schema(description = "批准时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1已审核 2已批准)")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
