package cn.iocoder.yudao.module.gap.dal.dataobject.input;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 投入品库存 DO
 *
 * @author 芋道源码
 */
@TableName("gap_input_inventory")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInputInventoryDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 产品编号
     */
    private Long productId;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 供应商编号
     */
    private Long supplierId;
    /**
     * 采购日期
     */
    private LocalDate purchaseDate;
    /**
     * 库存数量
     */
    private BigDecimal quantity;
    /**
     * 单位
     */
    private String unit;
    /**
     * 存放位置
     */
    private String warehouseLocation;
    /**
     * 生产日期
     */
    private LocalDate productionDate;
    /**
     * 有效期至
     */
    private LocalDate validityDate;
    /**
     * 状态(0正常 1近效期 2过期 3用完)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
