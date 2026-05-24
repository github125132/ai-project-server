package cn.iocoder.yudao.module.gap.dal.dataobject.harvest;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 采收记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_harvest_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapHarvestRecordDO extends BaseDO {

    /**
     * 记录编号
     */
    private Long id;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 采收计划编号
     */
    private Long harvestPlanId;
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
     * 采收日期
     */
    private LocalDate harvestDate;
    /**
     * 采收时段
     */
    private String harvestTime;
    /**
     * 天气情况
     */
    private String weather;
    /**
     * 气温
     */
    private BigDecimal temperature;
    /**
     * 采收面积(亩)
     */
    private BigDecimal harvestArea;
    /**
     * 鲜品重量(kg)
     */
    private BigDecimal freshWeight;
    /**
     * 采收方式
     */
    private String harvestMethod;
    /**
     * 采收工具
     */
    private String harvestTool;
    /**
     * 采收人员
     */
    private String operatorIds;
    /**
     * 监督人
     */
    private Long supervisorId;
    /**
     * 采收批次号(关联追溯)
     */
    private String batchNo;
    /**
     * 采收合格证号
     */
    private String harvestCertNo;
    /**
     * 采收照片
     */
    private String photoUrl;
    /**
     * 状态(0已采收 1已运送 2已加工)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
