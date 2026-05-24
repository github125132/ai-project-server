package cn.iocoder.yudao.module.gap.controller.admin.planting.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP PlotPlanting新增/修改 Request VO")
@Data
public class GapPlotPlantingSaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

    @Schema(description = "")
    private Long plotId;

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private Long varietyId;

    @Schema(description = "")
    private String batchNo;

    @Schema(description = "")
    private LocalDate plantingDate;

    @Schema(description = "")
    private LocalDate harvestDate;

    @Schema(description = "")
    private BigDecimal area;

    @Schema(description = "")
    private String plantingDensity;

    @Schema(description = "")
    private String plantingMethod;

    @Schema(description = "")
    private BigDecimal yieldEstimate;

    @Schema(description = "")
    private BigDecimal yieldActual;

    @Schema(description = "")
    private Integer status;

    @Schema(description = "")
    private String remark;

}
