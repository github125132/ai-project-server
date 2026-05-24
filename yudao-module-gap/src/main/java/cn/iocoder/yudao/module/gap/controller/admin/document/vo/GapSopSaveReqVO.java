package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP SOP新增/修改 Request VO")
@Data
public class GapSopSaveReqVO {

    @Schema(description = "SOP编号", example = "1024")
    private Long id;

    @Schema(description = "SOP编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "SOP-001")
    @NotEmpty(message = "SOP编号不能为空")
    private String sopNo;

    @Schema(description = "SOP名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "种植作业指导书")
    @NotEmpty(message = "SOP名称不能为空")
    private String name;

    @Schema(description = "类别(0种植 1采收 2加工 3仓储 4检验 5设备 6卫生)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "类别不能为空")
    private Integer category;

    @Schema(description = "版本号", example = "V1.0")
    private String version;

    @Schema(description = "目的")
    private String purpose;

    @Schema(description = "适用范围")
    private String scope;

    @Schema(description = "职责")
    private String responsibility;

    @Schema(description = "操作步骤")
    private String procedure;

    @Schema(description = "注意事项")
    private String precautions;

    @Schema(description = "相关文件")
    private String relatedDocs;

    @Schema(description = "相关记录")
    private String relatedRecords;

    @Schema(description = "生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "附件")
    private String fileUrl;

    @Schema(description = "批准人", example = "1")
    private Long approverId;

    @Schema(description = "批准日期")
    private LocalDate approveDate;

    @Schema(description = "状态(0草稿 1已批准 2已废止)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
