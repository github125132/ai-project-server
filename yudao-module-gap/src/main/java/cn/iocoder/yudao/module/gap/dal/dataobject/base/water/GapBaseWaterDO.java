package cn.iocoder.yudao.module.gap.dal.dataobject.base.water;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@TableName("gap_base_water")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapBaseWaterDO extends BaseDO {

    private Long id;
    private Long baseId;
    private Integer waterType;
    private String sampleNo;
    private LocalDate sampleDate;
    private String sampleLocation;
    private BigDecimal phValue;
    private BigDecimal cod;
    private BigDecimal bod5;
    private BigDecimal ammoniaNitrogen;
    private BigDecimal totalNitrogen;
    private BigDecimal totalPhosphorus;
    private BigDecimal cadmium;
    private BigDecimal lead;
    private BigDecimal arsenic;
    private BigDecimal mercury;
    private BigDecimal chromium;
    private String reportUrl;
    private Integer status;
    private String remark;

}
