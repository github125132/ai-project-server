package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 种植计划 DO
 *
 * @author 芋道源码
 */
@TableName("gap_planting_plan")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPlantingPlanDO extends BaseDO {

    /**
     * 计划编号
     */
    private Long id;
    /**
     * 计划编号
     */
    private String planNo;
    /**
     * 年度
     */
    private Integer year;
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
     * 计划面积(亩)
     */
    private BigDecimal plannedArea;
    /**
     * 计划产量(kg)
     */
    private BigDecimal plannedQuantity;
    /**
     * 种子批次编号
     */
    private Long seedBatchId;
    /**
     * 种子用量
     */
    private BigDecimal seedQuantity;
    /**
     * 种子单位
     */
    private String seedUnit;
    /**
     * 计划种植日期
     */
    private LocalDate plannedPlantDate;
    /**
     * 计划采收日期
     */
    private LocalDate plannedHarvestDate;
    /**
     * 种植方式
     */
    private String plantingMethod;
    /**
     * 种植密度
     */
    private String plantingDensity;
    /**
     * 轮作作物
     */
    private String rotationCrop;
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
