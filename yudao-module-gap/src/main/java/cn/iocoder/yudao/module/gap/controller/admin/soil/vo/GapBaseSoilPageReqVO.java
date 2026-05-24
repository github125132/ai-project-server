package cn.iocoder.yudao.module.gap.controller.admin.soil.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP BaseSoil分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapBaseSoilPageReqVO extends PageParam {

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private Long plotId;

    @Schema(description = "")
    private String sampleNo;

    @Schema(description = "")
    private LocalDate sampleDate;

    @Schema(description = "")
    private String sampleLocation;

    @Schema(description = "")
    private String soilType;

    @Schema(description = "")
    private BigDecimal phValue;

    @Schema(description = "")
    private BigDecimal organicMatter;

    @Schema(description = "")
    private BigDecimal nitrogen;

    @Schema(description = "")
    private BigDecimal phosphorus;

    @Schema(description = "")
    private BigDecimal potassium;

    @Schema(description = "")
    private BigDecimal cadmium;

    @Schema(description = "")
    private BigDecimal lead;

    @Schema(description = "")
    private BigDecimal arsenic;

    @Schema(description = "")
    private BigDecimal mercury;

    @Schema(description = "")
    private BigDecimal chromium;

    @Schema(description = "")
    private String reportUrl;

    @Schema(description = "")
    private Integer status;

}
