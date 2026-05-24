package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 留样记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_sample_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapSampleRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 留样编号
     */
    private String sampleNo;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 关联检验任务
     */
    private Long inspectTaskId;
    /**
     * 留样量(kg)
     */
    private BigDecimal sampleQuantity;
    /**
     * 取样日期
     */
    private LocalDate sampleDate;
    /**
     * 留样位置
     */
    private String storageLocation;
    /**
     * 留样条件
     */
    private String storageCondition;
    /**
     * 留样有效期
     */
    private LocalDate expiryDate;
    /**
     * 销毁日期
     */
    private LocalDate destroyDate;
    /**
     * 销毁方式
     */
    private String destroyMethod;
    /**
     * 销毁人
     */
    private Long destroyerId;
    /**
     * 见证人
     */
    private Long witnessId;
    /**
     * 状态(0留样中 1已到期 2已销毁)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
