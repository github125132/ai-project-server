package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 召回记录新增/修改 Request VO")
@Data
public class GapRecallRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "召回编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "RCL-2024001")
    @NotEmpty(message = "召回编号不能为空")
    private String recallNo;

    @Schema(description = "召回日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "召回日期不能为空")
    private LocalDate recallDate;

    @Schema(description = "召回批次号", example = "BATCH-2024001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "召回原因")
    private String recallReason;

    @Schema(description = "召回范围")
    private String recallScope;

    @Schema(description = "召回数量(kg)", example = "1000.00")
    private BigDecimal recallQuantity;

    @Schema(description = "召回方式")
    private String recallMethod;

    @Schema(description = "召回进度(%)", example = "50.00")
    private BigDecimal recallProgress;

    @Schema(description = "已召回数量(kg)", example = "500.00")
    private BigDecimal recalledQuantity;

    @Schema(description = "销毁数量(kg)", example = "200.00")
    private BigDecimal destroyQuantity;

    @Schema(description = "处理结果")
    private String handleResult;

    @Schema(description = "处理人", example = "1")
    private Long handlerId;

    @Schema(description = "关闭日期")
    private LocalDate closeDate;

    @Schema(description = "状态(0启动 1进行中 2已完成 3已关闭)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
