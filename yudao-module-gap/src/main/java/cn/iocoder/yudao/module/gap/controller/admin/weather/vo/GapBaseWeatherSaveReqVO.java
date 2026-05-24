package cn.iocoder.yudao.module.gap.controller.admin.weather.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP BaseWeather新增/修改 Request VO")
@Data
public class GapBaseWeatherSaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private LocalDate recordDate;

    @Schema(description = "")
    private BigDecimal maxTemp;

    @Schema(description = "")
    private BigDecimal minTemp;

    @Schema(description = "")
    private BigDecimal avgTemp;

    @Schema(description = "")
    private BigDecimal precipitation;

    @Schema(description = "")
    private BigDecimal humidity;

    @Schema(description = "")
    private BigDecimal sunshineHours;

    @Schema(description = "")
    private BigDecimal windSpeed;

    @Schema(description = "")
    private String windDirection;

    @Schema(description = "")
    private String weatherDesc;

    @Schema(description = "")
    private Integer frostFreeDays;

    @Schema(description = "")
    private Integer dataSource;

    @Schema(description = "")
    private String remark;

}
