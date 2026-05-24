package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 不合格品处理新增/修改 Request VO")
@Data
public class GapUnqualifiedHandleSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "处理单号", example = "UQ-20240101-001")
    private String recordNo;

    @Schema(description = "来源类型(0采收 1加工 2检验 3仓储)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "来源类型不能为空")
    private Integer sourceType;

    @Schema(description = "来源记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "来源记录编号不能为空")
    private Long sourceRecordId;

    @Schema(description = "批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "不合格原因")
    private String unqualifiedReason;

    @Schema(description = "数量(kg)", example = "10.0000")
    private BigDecimal quantity;

    @Schema(description = "处理方式(0返工 1降级 2销毁 3退货)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "处理方式不能为空")
    private Integer handleMethod;

    @Schema(description = "处理结果")
    private String handleResult;

    @Schema(description = "处理日期")
    private LocalDate handleDate;

    @Schema(description = "处理人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "处理人不能为空")
    private Long handlerId;

    @Schema(description = "监督人", example = "2")
    private Long supervisorId;

    @Schema(description = "处理照片")
    private String photoUrl;

    @Schema(description = "状态(0待处理 1处理中 2已处理)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
