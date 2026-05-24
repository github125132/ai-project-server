package cn.iocoder.yudao.module.gap.controller.admin.soil.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP BaseSoil Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseSoilRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private Long plotId;

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
    private String soilType;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal phValue;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal organicMatter;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal nitrogen;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal phosphorus;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal potassium;

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
