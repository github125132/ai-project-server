package cn.iocoder.yudao.module.gap.controller.admin.water.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP BaseWater新增/修改 Request VO")
@Data
public class GapBaseWaterSaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private Integer waterType;

    @Schema(description = "")
    private String sampleNo;

    @Schema(description = "")
    private LocalDate sampleDate;

    @Schema(description = "")
    private String sampleLocation;

    @Schema(description = "")
    private BigDecimal phValue;

    @Schema(description = "")
    private BigDecimal cod;

    @Schema(description = "")
    private BigDecimal bod5;

    @Schema(description = "")
    private BigDecimal ammoniaNitrogen;

    @Schema(description = "")
    private BigDecimal totalNitrogen;

    @Schema(description = "")
    private BigDecimal totalPhosphorus;

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
