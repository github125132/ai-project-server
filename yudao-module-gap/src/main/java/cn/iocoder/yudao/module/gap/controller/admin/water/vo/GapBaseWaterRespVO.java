package cn.iocoder.yudao.module.gap.controller.admin.water.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP BaseWater Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseWaterRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer waterType;

    @Schema(description = "")
    @ExcelProperty("")
    private String sampleNo;

    @Schema(description = "")
    @ExcelProperty("")
    private LocalDate sampleDate;

    @Schema(description = "")
    @ExcelProperty("")
    private String sampleLocation;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal phValue;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal cod;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal bod5;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal ammoniaNitrogen;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal totalNitrogen;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal totalPhosphorus;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal cadmium;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal lead;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal arsenic;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal mercury;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal chromium;

    @Schema(description = "")
    @ExcelProperty("")
    private String reportUrl;

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
