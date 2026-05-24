package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 记录模板新增/修改 Request VO")
@Data
public class GapRecordTemplateSaveReqVO {

    @Schema(description = "模板编号", example = "1024")
    private Long id;

    @Schema(description = "模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "TPL-001")
    @NotEmpty(message = "模板编号不能为空")
    private String templateNo;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "农事记录模板")
    @NotEmpty(message = "模板名称不能为空")
    private String name;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "分类编号不能为空")
    private Long categoryId;

    @Schema(description = "模板类型(0原始记录 1台账 2报告)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "模板类型不能为空")
    private Integer templateType;

    @Schema(description = "模板内容(JSON)")
    private String content;

    @Schema(description = "填写规范")
    private String fillRules;

    @Schema(description = "修改规范")
    private String modifyRules;

    @Schema(description = "复核规范")
    private String reviewRules;

    @Schema(description = "保存期限(年)", example = "5")
    private Integer retentionPeriod;

    @Schema(description = "生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "模板附件")
    private String fileUrl;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
