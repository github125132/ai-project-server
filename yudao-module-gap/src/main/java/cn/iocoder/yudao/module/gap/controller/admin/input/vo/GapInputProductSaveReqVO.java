package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - GAP 投入品产品新增/修改 Request VO")
@Data
public class GapInputProductSaveReqVO {

    @Schema(description = "产品编号", example = "1024")
    private Long id;

    @Schema(description = "产品编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "PROD-001")
    @NotEmpty(message = "产品编码不能为空")
    private String code;

    @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "吡虫啉")
    @NotEmpty(message = "产品名称不能为空")
    private String name;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "分类编号不能为空")
    private Long categoryId;

    @Schema(description = "大类(0农药 1肥料 2生物制剂 3其他)", example = "0")
    private Integer categoryType;

    @Schema(description = "品牌", example = "拜耳")
    private String brand;

    @Schema(description = "规格", example = "500ml/瓶")
    private String specification;

    @Schema(description = "生产厂家", example = "拜耳作物科学有限公司")
    private String manufacturer;

    @Schema(description = "登记证号", example = "PD20150001")
    private String registrationNo;

    @Schema(description = "生产许可证号")
    private String productionLicense;

    @Schema(description = "有效成分", example = "吡虫啉 10%")
    private String activeIngredient;

    @Schema(description = "含量", example = "10%")
    private String content;

    @Schema(description = "单位", example = "瓶")
    private String unit;

    @Schema(description = "剂型", example = "乳油")
    private String formulation;

    @Schema(description = "是否禁用农药", example = "false")
    private Boolean banned;

    @Schema(description = "是否限用", example = "false")
    private Boolean restricted;

    @Schema(description = "限用说明")
    private String restrictedNote;

    @Schema(description = "安全间隔期(天)", example = "7")
    private Integer safetyInterval;

    @Schema(description = "最大残留限量")
    private String maxResidueLimit;

    @Schema(description = "适用作物/范围", example = "水稻、小麦")
    private String usageScope;

    @Schema(description = "储存条件", example = "阴凉干燥处")
    private String storageCondition;

    @Schema(description = "保质期(月)", example = "24")
    private Integer shelfLife;

    @Schema(description = "状态(0正常 1停用)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
