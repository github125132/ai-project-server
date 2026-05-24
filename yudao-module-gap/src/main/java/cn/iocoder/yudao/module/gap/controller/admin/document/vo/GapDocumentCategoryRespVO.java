package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 文件分类 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapDocumentCategoryRespVO {

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("分类编号")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("父分类编号")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分类名称")
    private String name;

    @Schema(description = "分类编码")
    @ExcelProperty("分类编码")
    private String code;

    @Schema(description = "文件类型(0质量手册 1程序文件 2SOP 3记录表单 4技术标准 5管理制度)")
    @ExcelProperty("文件类型")
    private Integer categoryType;

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
