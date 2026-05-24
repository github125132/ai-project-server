package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 关键数据复核记录新增/修改 Request VO")
@Data
public class GapDataReviewSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "表名", requiredMode = Schema.RequiredMode.REQUIRED, example = "gap_base_info")
    @NotEmpty(message = "表名不能为空")
    private String tableName;

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "记录编号不能为空")
    private Long recordId;

    @Schema(description = "记录单号", example = "BASE-001")
    private String recordNo;

    @Schema(description = "复核类型(0录入复核 1定期复核 2专项复核)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "复核类型不能为空")
    private Integer reviewType;

    @Schema(description = "复核内容")
    private String reviewContent;

    @Schema(description = "复核结果(0合格 1不合格)", example = "0")
    private Integer reviewResult;

    @Schema(description = "发现问题")
    private String findings;

    @Schema(description = "复核人", example = "1")
    private Long reviewerId;

    @Schema(description = "复核时间")
    private LocalDateTime reviewTime;

    @Schema(description = "纠正措施")
    private String correctiveAction;

    @Schema(description = "状态(0待复核 1已复核 2已纠正)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
