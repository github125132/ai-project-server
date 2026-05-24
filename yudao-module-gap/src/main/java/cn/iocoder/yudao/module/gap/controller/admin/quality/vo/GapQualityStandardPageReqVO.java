package cn.iocoder.yudao.module.gap.controller.admin.quality.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP QualityStandard分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapQualityStandardPageReqVO extends PageParam {

    @Schema(description = "标准编码")
    private String code;

    @Schema(description = "标准名称")
    private String name;

    @Schema(description = "品种编号")
    private Long varietyId;

    @Schema(description = "标准级别(0企业内控 1国家标准 2行业标准)")
    private Integer standardLevel;

    @Schema(description = "版本号")
    private String version;

    @Schema(description = "生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "失效日期")
    private LocalDate expiryDate;

    @Schema(description = "基源要求")
    private String sourceSpecies;

    @Schema(description = "性状描述")
    private String appearanceDesc;

    @Schema(description = "鉴别方法")
    private String identificationMethod;

    @Schema(description = "检查项目")
    private String inspectionItems;

    @Schema(description = "水分限度(%)")
    private BigDecimal moistureLimit;

    @Schema(description = "灰分限度(%)")
    private BigDecimal ashLimit;

    @Schema(description = "浸出物限度(%)")
    private BigDecimal extractLimit;

    @Schema(description = "含量测定限度")
    private String contentLimit;

    @Schema(description = "农药残留限度")
    private String pesticideLimit;

    @Schema(description = "重金属限度")
    private String heavyMetalLimit;

    @Schema(description = "霉菌限度")
    private String mouldLimit;

    @Schema(description = "黄曲霉毒素限度")
    private String aflatoxinLimit;

    @Schema(description = "批准人")
    private Long approverId;

    @Schema(description = "批准时间")
    private LocalDateTime approveTime;

    @Schema(description = "状态(0草稿 1已批准 2已废止)")
    private Integer status;

}
