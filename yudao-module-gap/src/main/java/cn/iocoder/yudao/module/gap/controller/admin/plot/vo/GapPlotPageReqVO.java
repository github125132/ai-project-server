package cn.iocoder.yudao.module.gap.controller.admin.plot.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP Plot分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPlotPageReqVO extends PageParam {

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

}
