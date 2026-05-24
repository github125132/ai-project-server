package cn.iocoder.yudao.module.gap.controller.admin.planting.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP PlotPlanting分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPlotPlantingPageReqVO extends PageParam {

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

}
