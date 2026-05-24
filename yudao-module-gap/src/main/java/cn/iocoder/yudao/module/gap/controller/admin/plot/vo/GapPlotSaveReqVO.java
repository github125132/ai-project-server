package cn.iocoder.yudao.module.gap.controller.admin.plot.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP Plot新增/修改 Request VO")
@Data
public class GapPlotSaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

    @Schema(description = "")
    private String code;

    @Schema(description = "")
    private String name;

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private BigDecimal area;

    @Schema(description = "")
    private String soilType;

    @Schema(description = "")
    private BigDecimal soilPh;

    @Schema(description = "")
    private BigDecimal elevation;

    @Schema(description = "")
    private BigDecimal slope;

    @Schema(description = "")
    private String exposure;

    @Schema(description = "")
    private String previousCrop;

    @Schema(description = "")
    private Long currentVarietyId;

    @Schema(description = "")
    private Long currentBatchId;

    @Schema(description = "")
    private Integer status;

    @Schema(description = "")
    private String gisBoundary;

    @Schema(description = "")
    private String remark;

}
