package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 包装记录新增/修改 Request VO")
@Data
public class GapPackageRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "加工记录编号不能为空")
    private Long processRecordId;

    @Schema(description = "记录单号", example = "PK-20240101-001")
    private String recordNo;

    @Schema(description = "批次号", example = "BATCH-001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "包装日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "包装日期不能为空")
    private LocalDate packageDate;

    @Schema(description = "包装材料", example = "食品级PE袋")
    private String packageMaterial;

    @Schema(description = "包材批次号", example = "PM-001")
    private String materialBatchNo;

    @Schema(description = "包装规格(kg/包)", example = "25.000")
    private BigDecimal packageWeight;

    @Schema(description = "包装数量", example = "40")
    private Integer packageCount;

    @Schema(description = "总重量(kg)", example = "1000.00")
    private BigDecimal totalWeight;

    @Schema(description = "标签内容", example = "三七 产地：云南文山")
    private String labelContent;

    @Schema(description = "标签样张附件")
    private String labelSampleUrl;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "监督人", example = "1")
    private Long supervisorId;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
