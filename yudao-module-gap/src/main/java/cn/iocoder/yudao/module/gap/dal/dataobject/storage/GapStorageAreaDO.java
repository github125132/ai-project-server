package cn.iocoder.yudao.module.gap.dal.dataobject.storage;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * GAP 仓库分区 DO
 *
 * @author 芋道源码
 */
@TableName("gap_storage_area")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapStorageAreaDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 关联WMS仓库编号
     */
    private Long warehouseId;
    /**
     * 分区编码
     */
    private String code;
    /**
     * 分区名称
     */
    private String name;
    /**
     * 区域类型(0待验区 1合格区 2不合格区 3退货区 4发货区)
     */
    private Integer areaType;
    /**
     * 面积(m²)
     */
    private BigDecimal area;
    /**
     * 位置描述
     */
    private String locationDesc;
    /**
     * 容量(kg)
     */
    private BigDecimal capacity;
    /**
     * 状态(0正常 1停用)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
