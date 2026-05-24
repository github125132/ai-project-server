package cn.iocoder.yudao.module.gap.controller.admin.planting.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP PlotPlanting Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapPlotPlantingRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private Long plotId;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private Long varietyId;

    @Schema(description = "")
    @ExcelProperty("")
    private String batchNo;

    @Schema(description = "")
    @ExcelProperty("")
    private LocalDate plantingDate;

    @Schema(description = "")
    @ExcelProperty("")
    private LocalDate harvestDate;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal area;

    @Schema(description = "")
    @ExcelProperty("")
    private String plantingDensity;

    @Schema(description = "")
    @ExcelProperty("")
    private String plantingMethod;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal yieldEstimate;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal yieldActual;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer status;

    @Schema(description = "")
    @ExcelProperty("")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
