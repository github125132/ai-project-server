package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 投诉记录新增/修改 Request VO")
@Data
public class GapComplaintSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "投诉编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "CMP-2024001")
    @NotEmpty(message = "投诉编号不能为空")
    private String complaintNo;

    @Schema(description = "投诉日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "投诉日期不能为空")
    private LocalDate complaintDate;

    @Schema(description = "投诉人", example = "张三")
    private String complainant;

    @Schema(description = "联系方式", example = "13800138000")
    private String contactInfo;

    @Schema(description = "投诉类型(0质量 1包装 2运输 3其他)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "投诉类型不能为空")
    private Integer complaintType;

    @Schema(description = "涉及批次号", example = "BATCH-2024001")
    private String batchNo;

    @Schema(description = "涉及品种", example = "1")
    private Long varietyId;

    @Schema(description = "投诉内容")
    private String complaintContent;

    @Schema(description = "调查结果")
    private String investigation;

    @Schema(description = "处理结论")
    private String conclusion;

    @Schema(description = "处理人", example = "1")
    private Long handlerId;

    @Schema(description = "处理日期")
    private LocalDate handleDate;

    @Schema(description = "回复内容")
    private String responseContent;

    @Schema(description = "回复日期")
    private LocalDate responseDate;

    @Schema(description = "客户满意度(0满意 1一般 2不满意)", example = "0")
    private Integer customerSatisfaction;

    @Schema(description = "状态(0待处理 1处理中 2已回复 3已关闭)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
