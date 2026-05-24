package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - GAP 文件分类新增/修改 Request VO")
@Data
public class GapDocumentCategorySaveReqVO {

    @Schema(description = "分类编号", example = "1024")
    private Long id;

    @Schema(description = "父分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "父分类编号不能为空")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "质量手册")
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    @Schema(description = "分类编码", example = "QM")
    private String code;

    @Schema(description = "文件类型(0质量手册 1程序文件 2SOP 3记录表单 4技术标准 5管理制度)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "文件类型不能为空")
    private Integer categoryType;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "排序不能为空")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
