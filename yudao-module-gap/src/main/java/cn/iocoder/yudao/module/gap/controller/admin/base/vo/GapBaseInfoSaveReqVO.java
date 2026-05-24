package cn.iocoder.yudao.module.gap.controller.admin.base.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 基地信息新增/修改 Request VO")
@Data
public class GapBaseInfoSaveReqVO {

    @Schema(description = "基地编号", example = "1024")
    private Long id;

    @Schema(description = "基地编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "BASE-001")
    @NotEmpty(message = "基地编码不能为空")
    private String code;

    @Schema(description = "基地名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "云南文山三七基地")
    @NotEmpty(message = "基地名称不能为空")
    private String name;

    @Schema(description = "省份", example = "云南省")
    private String province;

    @Schema(description = "城市", example = "文山壮族苗族自治州")
    private String city;

    @Schema(description = "区县", example = "文山市")
    private String district;

    @Schema(description = "详细地址")
    private String address;

    @Schema(description = "经度", example = "104.233")
    private BigDecimal longitude;

    @Schema(description = "纬度", example = "23.371")
    private BigDecimal latitude;

    @Schema(description = "总面积(亩)", example = "500.00")
    private BigDecimal area;

    @Schema(description = "种植面积(亩)", example = "450.00")
    private BigDecimal plantingArea;

    @Schema(description = "海拔(m)", example = "1800.00")
    private BigDecimal altitude;

    @Schema(description = "状态(0正常 1停用)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "环境评估状态", example = "0")
    private Integer envAssessStatus;

    @Schema(description = "环境评估日期")
    private LocalDate envAssessDate;

    @Schema(description = "环境评估报告附件")
    private String envAssessReportUrl;

    @Schema(description = "基地负责人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地负责人不能为空")
    private Long responsibleUserId;

    @Schema(description = "生产负责人", example = "2")
    private Long managerUserId;

    @Schema(description = "质量负责人", example = "3")
    private Long qualityUserId;

    @Schema(description = "备注")
    private String remark;

}
