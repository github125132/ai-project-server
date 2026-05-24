package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 施肥记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_fertilization_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapFertilizationRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 地块编号
     */
    private Long plotId;
    /**
     * 地块种植批次
     */
    private String plotBatchNo;
    /**
     * 施肥日期
     */
    private LocalDate fertilizeDate;
    /**
     * 肥料类型(0基肥 1追肥 2叶面肥)
     */
    private Integer fertilizeType;
    /**
     * 施肥时期
     */
    private String fertilizeStage;
    /**
     * 施肥方法
     */
    private String fertilizeMethod;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
