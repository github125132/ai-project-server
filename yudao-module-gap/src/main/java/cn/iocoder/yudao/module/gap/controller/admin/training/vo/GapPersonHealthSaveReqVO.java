package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 人员健康档案新增/修改 Request VO")
@Data
public class GapPersonHealthSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "人员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "人员编号不能为空")
    private Long userId;

    @Schema(description = "体检日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "体检日期不能为空")
    private LocalDate checkDate;

    @Schema(description = "体检机构", example = "XX医院")
    private String checkOrg;

    @Schema(description = "检查项目", example = "血常规、尿常规、肝功能")
    private String checkItem;

    @Schema(description = "检查结果", example = "各项指标正常")
    private String checkResult;

    @Schema(description = "是否传染病", example = "false")
    private Boolean isContagious;

    @Schema(description = "是否皮肤病", example = "false")
    private Boolean isSkinDisease;

    @Schema(description = "是否合格", example = "true")
    private Boolean isQualified;

    @Schema(description = "健康证号", example = "HEALTH-001")
    private String healthCertNo;

    @Schema(description = "健康证附件")
    private String healthCertUrl;

    @Schema(description = "有效期至")
    private LocalDate validityDate;

    @Schema(description = "下次体检日期")
    private LocalDate nextCheckDate;

    @Schema(description = "是否已发送到期预警", example = "false")
    private Boolean warningSent;

    @Schema(description = "状态(0有效 1即将过期 2已过期)", example = "0")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
