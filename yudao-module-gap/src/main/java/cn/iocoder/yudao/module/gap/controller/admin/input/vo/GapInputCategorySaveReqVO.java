package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - GAP 投入品分类新增/修改 Request VO")
@Data
public class GapInputCategorySaveReqVO {

    @Schema(description = "分类编号", example = "1024")
    private Long id;

    @Schema(description = "父分类编号", example = "0")
    private Long parentId;

    @Schema(description = "分类名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "杀虫剂")
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    @Schema(description = "分类编码", example = "CAT-PESTICIDE")
    private String code;

    @Schema(description = "大类(0农药 1肥料 2生物制剂 3其他)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "大类不能为空")
    private Integer categoryType;

    @Schema(description = "是否禁用", example = "false")
    private Boolean banned;

    @Schema(description = "禁用原因")
    private String banReason;

    @Schema(description = "排序", example = "0")
    private Integer sort;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
