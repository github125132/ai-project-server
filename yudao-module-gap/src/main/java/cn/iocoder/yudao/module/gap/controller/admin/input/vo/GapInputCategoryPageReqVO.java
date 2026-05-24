package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 投入品分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapInputCategoryPageReqVO extends PageParam {

    @Schema(description = "分类名称", example = "杀虫剂")
    private String name;

    @Schema(description = "分类编码", example = "CAT-PESTICIDE")
    private String code;

    @Schema(description = "大类(0农药 1肥料 2生物制剂 3其他)", example = "0")
    private Integer categoryType;

    @Schema(description = "父分类编号", example = "0")
    private Long parentId;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
