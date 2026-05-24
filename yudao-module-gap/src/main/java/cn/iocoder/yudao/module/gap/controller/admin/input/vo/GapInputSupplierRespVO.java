package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 投入品供应商 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInputSupplierRespVO {

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("供应商编号")
    private Long id;

    @Schema(description = "供应商编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("供应商编码")
    private String code;

    @Schema(description = "供应商名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("供应商名称")
    private String name;

    @Schema(description = "联系人")
    @ExcelProperty("联系人")
    private String contactPerson;

    @Schema(description = "联系电话")
    @ExcelProperty("联系电话")
    private String contactPhone;

    @Schema(description = "地址")
    @ExcelProperty("地址")
    private String address;

    @Schema(description = "营业执照号")
    @ExcelProperty("营业执照号")
    private String businessLicense;

    @Schema(description = "营业执照附件")
    @ExcelProperty("营业执照附件")
    private String licenseUrl;

    @Schema(description = "生产许可证号")
    @ExcelProperty("生产许可证号")
    private String productionLicense;

    @Schema(description = "质量协议附件")
    @ExcelProperty("质量协议附件")
    private String qualityAgreementUrl;

    @Schema(description = "审计日期")
    @ExcelProperty("审计日期")
    private LocalDate auditDate;

    @Schema(description = "审计结果(0合格 1不合格)")
    @ExcelProperty("审计结果")
    private Integer auditResult;

    @Schema(description = "审计报告附件")
    @ExcelProperty("审计报告附件")
    private String auditReportUrl;

    @Schema(description = "状态(0合格供应商 1观察 2不合格)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
