package cn.iocoder.yudao.module.gap.controller.admin.soil.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP BaseSoil新增/修改 Request VO")
@Data
public class GapBaseSoilSaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

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

    @Schema(description = "")
    private String remark;

}
