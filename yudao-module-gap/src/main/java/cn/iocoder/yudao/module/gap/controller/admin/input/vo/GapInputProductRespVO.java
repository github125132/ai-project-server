package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 投入品产品 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInputProductRespVO {

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("产品编号")
    private Long id;

    @Schema(description = "产品编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("产品编码")
    private String code;

    @Schema(description = "产品名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("产品名称")
    private String name;

    @Schema(description = "分类编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分类编号")
    private Long categoryId;

    @Schema(description = "大类(0农药 1肥料 2生物制剂 3其他)")
    @ExcelProperty("大类")
    private Integer categoryType;

    @Schema(description = "品牌")
    @ExcelProperty("品牌")
    private String brand;

    @Schema(description = "规格")
    @ExcelProperty("规格")
    private String specification;

    @Schema(description = "生产厂家")
    @ExcelProperty("生产厂家")
    private String manufacturer;

    @Schema(description = "登记证号")
    @ExcelProperty("登记证号")
    private String registrationNo;

    @Schema(description = "生产许可证号")
    @ExcelProperty("生产许可证号")
    private String productionLicense;

    @Schema(description = "有效成分")
    @ExcelProperty("有效成分")
    private String activeIngredient;

    @Schema(description = "含量")
    @ExcelProperty("含量")
    private String content;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "剂型")
    @ExcelProperty("剂型")
    private String formulation;

    @Schema(description = "是否禁用农药")
    @ExcelProperty("是否禁用农药")
    private Boolean banned;

    @Schema(description = "是否限用")
    @ExcelProperty("是否限用")
    private Boolean restricted;

    @Schema(description = "限用说明")
    @ExcelProperty("限用说明")
    private String restrictedNote;

    @Schema(description = "安全间隔期(天)")
    @ExcelProperty("安全间隔期(天)")
    private Integer safetyInterval;

    @Schema(description = "最大残留限量")
    @ExcelProperty("最大残留限量")
    private String maxResidueLimit;

    @Schema(description = "适用作物/范围")
    @ExcelProperty("适用作物/范围")
    private String usageScope;

    @Schema(description = "储存条件")
    @ExcelProperty("储存条件")
    private String storageCondition;

    @Schema(description = "保质期(月)")
    @ExcelProperty("保质期(月)")
    private Integer shelfLife;

    @Schema(description = "状态(0正常 1停用)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
