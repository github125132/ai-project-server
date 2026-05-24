package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 投入品产品分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapInputProductPageReqVO extends PageParam {

    @Schema(description = "产品编码", example = "PROD-001")
    private String code;

    @Schema(description = "产品名称", example = "吡虫啉")
    private String name;

    @Schema(description = "分类编号", example = "1")
    private Long categoryId;

    @Schema(description = "大类(0农药 1肥料 2生物制剂 3其他)", example = "0")
    private Integer categoryType;

    @Schema(description = "生产厂家", example = "拜耳作物科学有限公司")
    private String manufacturer;

    @Schema(description = "是否禁用农药", example = "false")
    private Boolean banned;

    @Schema(description = "是否限用", example = "false")
    private Boolean restricted;

    @Schema(description = "状态(0正常 1停用)", example = "0")
    private Integer status;

}
