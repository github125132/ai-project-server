package cn.iocoder.yudao.module.gap.dal.dataobject.base.plot;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

@TableName("gap_plot")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPlotDO extends BaseDO {

    private Long id;
    private String code;
    private String name;
    private Long baseId;
    private BigDecimal area;
    private String soilType;
    private BigDecimal soilPh;
    private BigDecimal elevation;
    private BigDecimal slope;
    private String exposure;
    private String previousCrop;
    private Long currentVarietyId;
    private Long currentBatchId;
    private Integer status;
    private String gisBoundary;
    private String remark;

}
