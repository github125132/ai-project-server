package cn.iocoder.yudao.module.gap.dal.dataobject.seed;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 种子种苗批次 DO
 */
@TableName("gap_seed_batch")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapSeedBatchDO extends BaseDO {

    /**
     * 批次编号
     */
    private Long id;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 类型(0种子 1种苗)
     */
    private Integer seedType;
    /**
     * 来源(0自繁 1外购 2野生采集)
     */
    private Integer sourceType;
    /**
     * 供应商编号
     */
    private Long supplierId;
    /**
     * 数量
     */
    private BigDecimal quantity;
    /**
     * 单位
     */
    private String unit;
    /**
     * 采购/采集日期
     */
    private LocalDate purchaseDate;
    /**
     * 储存位置
     */
    private String storageLocation;
    /**
     * 储存条件
     */
    private String storageCondition;
    /**
     * 有效期限
     */
    private LocalDate validityPeriod;
    /**
     * 基源鉴定编号
     */
    private Long originIdentifyId;
    /**
     * 检疫证号
     */
    private String quarantineCertNo;
    /**
     * 检疫证书附件
     */
    private String quarantineCertUrl;
    /**
     * 纯度(%)
     */
    private BigDecimal purity;
    /**
     * 发芽率(%)
     */
    private BigDecimal germinationRate;
    /**
     * 水分(%)
     */
    private BigDecimal moisture;
    /**
     * 净度(%)
     */
    private BigDecimal cleanliness;
    /**
     * 状态(0待验 1合格 2不合格 3已使用)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
