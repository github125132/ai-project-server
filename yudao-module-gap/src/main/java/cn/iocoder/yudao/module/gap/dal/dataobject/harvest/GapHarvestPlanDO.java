package cn.iocoder.yudao.module.gap.dal.dataobject.harvest;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 采收计划 DO
 *
 * @author 芋道源码
 */
@TableName("gap_harvest_plan")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapHarvestPlanDO extends BaseDO {

    /**
     * 计划编号
     */
    private Long id;
    /**
     * 计划编号
     */
    private String planNo;
    /**
     * 种植计划编号
     */
    private Long plantingPlanId;
    /**
     * 品种编号
     */
    private Long varietyId;
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
     * 计划采收日期
     */
    private LocalDate plannedHarvestDate;
    /**
     * 计划采收量(kg)
     */
    private BigDecimal plannedQuantity;
    /**
     * 采收标准
     */
    private String harvestCriteria;
    /**
     * 采收方式
     */
    private String harvestMethod;
    /**
     * 采收工具
     */
    private String harvestTool;
    /**
     * 天气要求
     */
    private String weatherRequirement;
    /**
     * 采收人员列表
     */
    private String operatorIds;
    /**
     * 审批人
     */
    private Long approverId;
    /**
     * 审批时间
     */
    private LocalDateTime approveTime;
    /**
     * 状态(0草稿 1待审批 2已批准 3已执行 4已取消)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
