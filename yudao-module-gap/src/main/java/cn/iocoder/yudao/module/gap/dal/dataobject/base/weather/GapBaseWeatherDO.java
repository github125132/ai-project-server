package cn.iocoder.yudao.module.gap.dal.dataobject.base.weather;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@TableName("gap_base_weather")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapBaseWeatherDO extends BaseDO {

    private Long id;
    private Long baseId;
    private LocalDate recordDate;
    private BigDecimal maxTemp;
    private BigDecimal minTemp;
    private BigDecimal avgTemp;
    private BigDecimal precipitation;
    private BigDecimal humidity;
    private BigDecimal sunshineHours;
    private BigDecimal windSpeed;
    private String windDirection;
    private String weatherDesc;
    private Integer frostFreeDays;
    private Integer dataSource;
    private String remark;

}
