package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * GAP 病虫害防治方案 DO
 *
 * @author 芋道源码
 */
@TableName("gap_pest_control")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPestControlDO extends BaseDO {

    /**
     * 方案编号
     */
    private Long id;
    /**
     * 方案编号
     */
    private String planNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 病虫害名称
     */
    private String pestName;
    /**
     * 类型(0病害 1虫害 2草害 3鼠害)
     */
    private Integer pestType;
    /**
     * 防治原则
     */
    private String controlPrinciple;
    /**
     * 农业防治措施
     */
    private String agriculturalMethod;
    /**
     * 物理防治措施
     */
    private String physicalMethod;
    /**
     * 生物防治措施
     */
    private String biologicalMethod;
    /**
     * 化学防治措施
     */
    private String chemicalMethod;
    /**
     * 批准使用农药编号列表
     */
    private String approvedPesticideIds;
    /**
     * 预防时期
     */
    private String preventionPeriod;
    /**
     * 预警阈值
     */
    private String warningThreshold;
    /**
     * 状态(0草稿 1已审批 2执行中 3已完成)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
