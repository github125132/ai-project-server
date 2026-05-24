package cn.iocoder.yudao.module.gap.dal.dataobject.change;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 召回记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_recall_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapRecallRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 召回编号
     */
    private String recallNo;
    /**
     * 召回日期
     */
    private LocalDate recallDate;
    /**
     * 召回批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 召回原因
     */
    private String recallReason;
    /**
     * 召回范围
     */
    private String recallScope;
    /**
     * 召回数量(kg)
     */
    private BigDecimal recallQuantity;
    /**
     * 召回方式
     */
    private String recallMethod;
    /**
     * 召回进度(%)
     */
    private BigDecimal recallProgress;
    /**
     * 已召回数量(kg)
     */
    private BigDecimal recalledQuantity;
    /**
     * 销毁数量(kg)
     */
    private BigDecimal destroyQuantity;
    /**
     * 处理结果
     */
    private String handleResult;
    /**
     * 处理人
     */
    private Long handlerId;
    /**
     * 关闭日期
     */
    private LocalDate closeDate;
    /**
     * 状态(0启动 1进行中 2已完成 3已关闭)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
