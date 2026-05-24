package cn.iocoder.yudao.module.gap.controller.admin.audit.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP audit_checklist_item Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapAuditChecklistItemRespVO {

    @Schema(description = "编号")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "检查表编号")
    @ExcelProperty("检查表编号")
    private Long checklistId;

    @Schema(description = "项目编号")
    @ExcelProperty("项目编号")
    private String itemNo;

    @Schema(description = "章节")
    @ExcelProperty("章节")
    private String chapter;

    @Schema(description = "条款")
    @ExcelProperty("条款")
    private String clause;

    @Schema(description = "检查内容")
    @ExcelProperty("检查内容")
    private String checkContent;

    @Schema(description = "检查方法")
    @ExcelProperty("检查方法")
    private String checkMethod;

    @Schema(description = "检查标准")
    @ExcelProperty("检查标准")
    private String checkStandard;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

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
