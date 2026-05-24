package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 投入品供应商新增/修改 Request VO")
@Data
public class GapInputSupplierSaveReqVO {

    @Schema(description = "供应商编号", example = "1024")
    private Long id;

    @Schema(description = "供应商编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "SUP-001")
    @NotEmpty(message = "供应商编码不能为空")
    private String code;

    @Schema(description = "供应商名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "云南农资有限公司")
    @NotEmpty(message = "供应商名称不能为空")
    private String name;

    @Schema(description = "联系人", example = "张三")
    private String contactPerson;

    @Schema(description = "联系电话", example = "13800138000")
    private String contactPhone;

    @Schema(description = "地址", example = "云南省昆明市")
    private String address;

    @Schema(description = "营业执照号", example = "91530000MA6K7XXXX")
    private String businessLicense;

    @Schema(description = "营业执照附件")
    private String licenseUrl;

    @Schema(description = "生产许可证号")
    private String productionLicense;

    @Schema(description = "质量协议附件")
    private String qualityAgreementUrl;

    @Schema(description = "审计日期")
    private LocalDate auditDate;

    @Schema(description = "审计结果(0合格 1不合格)", example = "0")
    private Integer auditResult;

    @Schema(description = "审计报告附件")
    private String auditReportUrl;

    @Schema(description = "状态(0合格供应商 1观察 2不合格)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
