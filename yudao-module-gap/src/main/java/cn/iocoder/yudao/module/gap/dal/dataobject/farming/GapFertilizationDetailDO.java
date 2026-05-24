package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * GAP 施肥明细 DO
 *
 * @author 芋道源码
 */
@TableName("gap_fertilization_detail")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapFertilizationDetailDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 施肥记录编号
     */
    private Long recordId;
    /**
     * 肥料产品编号
     */
    private Long productId;
    /**
     * 肥料名称
     */
    private String productName;
    /**
     * 用量
     */
    private BigDecimal quantity;
    /**
     * 单位
     */
    private String unit;
    /**
     * 有效成分
     */
    private String activeIngredient;
    /**
     * 施用面积(亩)
     */
    private BigDecimal applicationArea;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;

}
