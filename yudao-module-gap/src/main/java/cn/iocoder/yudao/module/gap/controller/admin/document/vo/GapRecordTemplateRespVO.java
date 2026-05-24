package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 记录模板 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapRecordTemplateRespVO {

    @Schema(description = "模板编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("模板编号")
    private Long id;

    @Schema(description = "模板编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模板编号")
    private String templateNo;

    @Schema(description = "模板名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("模板名称")
    private String name;

    @Schema(description = "分类编号")
    @ExcelProperty("分类编号")
    private Long categoryId;

    @Schema(description = "模板类型(0原始记录 1台账 2报告)")
    @ExcelProperty("模板类型")
    private Integer templateType;

    @Schema(description = "模板内容(JSON)")
    @ExcelProperty("模板内容")
    private String content;

    @Schema(description = "填写规范")
    @ExcelProperty("填写规范")
    private String fillRules;

    @Schema(description = "修改规范")
    @ExcelProperty("修改规范")
    private String modifyRules;

    @Schema(description = "复核规范")
    @ExcelProperty("复核规范")
    private String reviewRules;

    @Schema(description = "保存期限(年)")
    @ExcelProperty("保存期限(年)")
    private Integer retentionPeriod;

    @Schema(description = "生效日期")
    @ExcelProperty("生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "模板附件")
    @ExcelProperty("模板附件")
    private String fileUrl;

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
