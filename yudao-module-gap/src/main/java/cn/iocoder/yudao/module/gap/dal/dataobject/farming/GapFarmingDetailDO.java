package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * GAP 农事记录明细 DO
 *
 * @author 芋道源码
 */
@TableName("gap_farming_detail")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapFarmingDetailDO extends BaseDO {

    /**
     * 明细编号
     */
    private Long id;
    /**
     * 农事记录编号
     */
    private Long recordId;
    /**
     * 明细类型(0整地深度 1播种量 2移栽密度 3除草方式 4灌溉量 5肥料种类 6施肥量 7整枝方式 8覆盖材料 9防治对象 10采收量)
     */
    private Integer detailType;
    /**
     * 项目/物品名称
     */
    private String itemName;
    /**
     * 数值/用量
     */
    private String itemValue;
    /**
     * 单位
     */
    private String itemUnit;
    /**
     * 规格说明
     */
    private String itemSpec;
    /**
     * 操作前状态
     */
    private String beforeStatus;
    /**
     * 操作后状态
     */
    private String afterStatus;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remark;

}
