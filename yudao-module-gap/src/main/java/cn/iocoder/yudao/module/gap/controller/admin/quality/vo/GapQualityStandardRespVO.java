package cn.iocoder.yudao.module.gap.controller.admin.quality.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP QualityStandard Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapQualityStandardRespVO {

    @Schema(description = "标准编号")
    @ExcelProperty("标准编号")
    private Long id;

    @Schema(description = "标准编码")
    @ExcelProperty("标准编码")
    private String code;

    @Schema(description = "标准名称")
    @ExcelProperty("标准名称")
    private String name;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "标准级别(0企业内控 1国家标准 2行业标准)")
    @ExcelProperty("标准级别(0企业内控 1国家标准 2行业标准)")
    private Integer standardLevel;

    @Schema(description = "版本号")
    @ExcelProperty("版本号")
    private String version;

    @Schema(description = "生效日期")
    @ExcelProperty("生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "失效日期")
    @ExcelProperty("失效日期")
    private LocalDate expiryDate;

    @Schema(description = "基源要求")
    @ExcelProperty("基源要求")
    private String sourceSpecies;

    @Schema(description = "性状描述")
    @ExcelProperty("性状描述")
    private String appearanceDesc;

    @Schema(description = "鉴别方法")
    @ExcelProperty("鉴别方法")
    private String identificationMethod;

    @Schema(description = "检查项目")
    @ExcelProperty("检查项目")
    private String inspectionItems;

    @Schema(description = "水分限度(%)")
    @ExcelProperty("水分限度(%)")
    private BigDecimal moistureLimit;

    @Schema(description = "灰分限度(%)")
    @ExcelProperty("灰分限度(%)")
    private BigDecimal ashLimit;

    @Schema(description = "浸出物限度(%)")
    @ExcelProperty("浸出物限度(%)")
    private BigDecimal extractLimit;

    @Schema(description = "含量测定限度")
    @ExcelProperty("含量测定限度")
    private String contentLimit;

    @Schema(description = "农药残留限度")
    @ExcelProperty("农药残留限度")
    private String pesticideLimit;

    @Schema(description = "重金属限度")
    @ExcelProperty("重金属限度")
    private String heavyMetalLimit;

    @Schema(description = "霉菌限度")
    @ExcelProperty("霉菌限度")
    private String mouldLimit;

    @Schema(description = "黄曲霉毒素限度")
    @ExcelProperty("黄曲霉毒素限度")
    private String aflatoxinLimit;

    @Schema(description = "批准人")
    @ExcelProperty("批准人")
    private Long approverId;

    @Schema(description = "批准时间")
    @ExcelProperty("批准时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1已批准 2已废止)")
    @ExcelProperty("状态(0草稿 1已批准 2已废止)")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
