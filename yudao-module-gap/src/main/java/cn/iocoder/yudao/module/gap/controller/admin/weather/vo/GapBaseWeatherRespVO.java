package cn.iocoder.yudao.module.gap.controller.admin.weather.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP BaseWeather Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseWeatherRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private LocalDate recordDate;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal maxTemp;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal minTemp;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal avgTemp;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal precipitation;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal humidity;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal sunshineHours;

    @Schema(description = "")
    @ExcelProperty("")
    private BigDecimal windSpeed;

    @Schema(description = "")
    @ExcelProperty("")
    private String windDirection;

    @Schema(description = "")
    @ExcelProperty("")
    private String weatherDesc;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer frostFreeDays;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer dataSource;

    @Schema(description = "")
    @ExcelProperty("")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
