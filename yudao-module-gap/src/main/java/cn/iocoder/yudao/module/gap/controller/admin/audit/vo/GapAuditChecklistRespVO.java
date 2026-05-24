package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP audit_checklist Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapAuditChecklistRespVO {

    @Schema(description = "检查表编号")
    @ExcelProperty("检查表编号")
    private Long id;

    @Schema(description = "检查表编号")
    @ExcelProperty("检查表编号")
    private String checklistNo;

    @Schema(description = "审核计划编号")
    @ExcelProperty("审核计划编号")
    private Long planId;

    @Schema(description = "检查表名称")
    @ExcelProperty("检查表名称")
    private String name;

    @Schema(description = "检查章节")
    @ExcelProperty("检查章节")
    private String checkChapter;

    @Schema(description = "适用条款")
    @ExcelProperty("适用条款")
    private String applicableClauses;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
