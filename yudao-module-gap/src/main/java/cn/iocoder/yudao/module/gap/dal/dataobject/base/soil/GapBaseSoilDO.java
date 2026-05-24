package cn.iocoder.yudao.module.gap.dal.dataobject.base.soil;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@TableName("gap_base_soil")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapBaseSoilDO extends BaseDO {

    private Long id;
    private Long baseId;
    private Long plotId;
    private String sampleNo;
    private LocalDate sampleDate;
    private String sampleLocation;
    private String soilType;
    private BigDecimal phValue;
    private BigDecimal organicMatter;
    private BigDecimal nitrogen;
    private BigDecimal phosphorus;
    private BigDecimal potassium;
    private BigDecimal cadmium;
    private BigDecimal lead;
    private BigDecimal arsenic;
    private BigDecimal mercury;
    private BigDecimal chromium;
    private String reportUrl;
    private Integer status;
    private String remark;

}
