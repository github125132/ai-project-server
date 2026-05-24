package cn.iocoder.yudao.module.gap.controller.admin.plot.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP Plot Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapPlotRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private String code;

    @Schema(description = "")
    @ExcelProperty("")
    private String name;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal area;

    @Schema(description = "")
    @ExcelProperty("")
    private String soilType;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal soilPh;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal elevation;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal slope;

    @Schema(description = "")
    @ExcelProperty("")
    private String exposure;

    @Schema(description = "")
    @ExcelProperty("")
    private String previousCrop;

    @Schema(description = "")
    @ExcelProperty("")
    private Long currentVarietyId;

    @Schema(description = "")
    @ExcelProperty("")
    private Long currentBatchId;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer status;

    @Schema(description = "")
    @ExcelProperty("")
    private String gisBoundary;

    @Schema(description = "")
    @ExcelProperty("")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
