package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 投入品分类 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInputCategoryRespVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("分类编号")
    private Long id;

    @Schema(description = "父分类编号", example = "0")
    @ExcelProperty("父分类编号")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分类名称")
    private String name;

    @Schema(description = "分类编码")
    @ExcelProperty("分类编码")
    private String code;

    @Schema(description = "大类(0农药 1肥料 2生物制剂 3其他)")
    @ExcelProperty("大类")
    private Integer categoryType;

    @Schema(description = "是否禁用")
    @ExcelProperty("是否禁用")
    private Boolean banned;

    @Schema(description = "禁用原因")
    @ExcelProperty("禁用原因")
    private String banReason;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

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
