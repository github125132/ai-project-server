package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP ReleaseRecord分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapReleaseRecordPageReqVO extends PageParam {

    @Schema(description = "放行单号")
    private String releaseNo;

    @Schema(description = "批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    private Long varietyId;

    @Schema(description = "来源类型(0加工 1入库)")
    private Integer sourceType;

    @Schema(description = "来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "数量(kg)")
    private BigDecimal quantity;

    @Schema(description = "检验报告编号")
    private Long inspectReportId;

    @Schema(description = "检验结论(0合格 1不合格)")
    private Integer inspectConclusion;

    @Schema(description = "放行审核项目")
    private String releaseItems;

    @Schema(description = "质量审核人")
    private Long qualityReviewerId;

    @Schema(description = "质量审核时间")
    private LocalDateTime qualityReviewTime;

    @Schema(description = "质量审核意见")
    private String qualityReviewOpinion;

    @Schema(description = "批准人")
    private Long approverId;

    @Schema(description = "批准时间")
    private LocalDateTime approveTime;

    @Schema(description = "批准意见")
    private String approveOpinion;

    @Schema(description = "状态(0待审核 1质量审核通过 2已批准 3拒绝)")
    private Integer status;

}
