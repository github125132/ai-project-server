package cn.iocoder.yudao.module.gap.controller.admin.origin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 基源鉴定新增/修改 Request VO")
@Data
public class GapOriginIdentifySaveReqVO {

    @Schema(description = "鉴定编号", example = "1024")
    private Long id;

    @Schema(description = "鉴定报告编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "ID-2024-001")
    @NotEmpty(message = "鉴定报告编号不能为空")
    private String identifyNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "种子批次编号", example = "1")
    private Long seedBatchId;

    @Schema(description = "鉴定方法(形态学/DNA条形码等)", example = "DNA条形码")
    private String identifyMethod;

    @Schema(description = "鉴定机构", example = "中国药科大学")
    private String identifyOrg;

    @Schema(description = "鉴定人", example = "张三")
    private String identifyPerson;

    @Schema(description = "鉴定日期")
    private LocalDate identifyDate;

    @Schema(description = "鉴定结果")
    private String identifyResult;

    @Schema(description = "鉴定结论", example = "鉴定为正品三七")
    private String conclusion;

    @Schema(description = "鉴定报告附件")
    private String reportUrl;

    @Schema(description = "标本照片附件")
    private String specimenUrl;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
