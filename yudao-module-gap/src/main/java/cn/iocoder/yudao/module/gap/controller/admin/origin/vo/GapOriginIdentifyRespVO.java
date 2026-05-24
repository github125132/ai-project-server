package cn.iocoder.yudao.module.gap.controller.admin.origin.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 基源鉴定 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapOriginIdentifyRespVO {

    @Schema(description = "鉴定编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("鉴定编号")
    private Long id;

    @Schema(description = "鉴定报告编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "ID-2024-001")
    @ExcelProperty("鉴定报告编号")
    private String identifyNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "种子批次编号")
    @ExcelProperty("种子批次编号")
    private Long seedBatchId;

    @Schema(description = "鉴定方法(形态学/DNA条形码等)")
    @ExcelProperty("鉴定方法")
    private String identifyMethod;

    @Schema(description = "鉴定机构")
    @ExcelProperty("鉴定机构")
    private String identifyOrg;

    @Schema(description = "鉴定人")
    @ExcelProperty("鉴定人")
    private String identifyPerson;

    @Schema(description = "鉴定日期")
    @ExcelProperty("鉴定日期")
    private LocalDate identifyDate;

    @Schema(description = "鉴定结果")
    @ExcelProperty("鉴定结果")
    private String identifyResult;

    @Schema(description = "鉴定结论")
    @ExcelProperty("鉴定结论")
    private String conclusion;

    @Schema(description = "鉴定报告附件")
    @ExcelProperty("鉴定报告附件")
    private String reportUrl;

    @Schema(description = "标本照片附件")
    @ExcelProperty("标本照片附件")
    private String specimenUrl;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
