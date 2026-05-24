package cn.iocoder.yudao.module.gap.dal.dataobject.base.planting;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@TableName("gap_plot_planting")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPlotPlantingDO extends BaseDO {

    private Long id;
    private Long plotId;
    private Long baseId;
    private Long varietyId;
    private String batchNo;
    private LocalDate plantingDate;
    private LocalDate harvestDate;
    private BigDecimal area;
    private String plantingDensity;
    private String plantingMethod;
    private BigDecimal yieldEstimate;
    private BigDecimal yieldActual;
    private Integer status;
    private String remark;

}
