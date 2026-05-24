package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 投诉记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapComplaintRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "投诉编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("投诉编号")
    private String complaintNo;

    @Schema(description = "投诉日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("投诉日期")
    private LocalDate complaintDate;

    @Schema(description = "投诉人")
    @ExcelProperty("投诉人")
    private String complainant;

    @Schema(description = "联系方式")
    @ExcelProperty("联系方式")
    private String contactInfo;

    @Schema(description = "投诉类型(0质量 1包装 2运输 3其他)")
    @ExcelProperty("投诉类型")
    private Integer complaintType;

    @Schema(description = "涉及批次号")
    @ExcelProperty("涉及批次号")
    private String batchNo;

    @Schema(description = "涉及品种")
    @ExcelProperty("涉及品种")
    private Long varietyId;

    @Schema(description = "投诉内容")
    @ExcelProperty("投诉内容")
    private String complaintContent;

    @Schema(description = "调查结果")
    @ExcelProperty("调查结果")
    private String investigation;

    @Schema(description = "处理结论")
    @ExcelProperty("处理结论")
    private String conclusion;

    @Schema(description = "处理人")
    @ExcelProperty("处理人")
    private Long handlerId;

    @Schema(description = "处理日期")
    @ExcelProperty("处理日期")
    private LocalDate handleDate;

    @Schema(description = "回复内容")
    @ExcelProperty("回复内容")
    private String responseContent;

    @Schema(description = "回复日期")
    @ExcelProperty("回复日期")
    private LocalDate responseDate;

    @Schema(description = "客户满意度(0满意 1一般 2不满意)")
    @ExcelProperty("客户满意度")
    private Integer customerSatisfaction;

    @Schema(description = "状态(0待处理 1处理中 2已回复 3已关闭)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
