package cn.iocoder.yudao.module.gap.dal.dataobject.process;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 加工记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_process_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapProcessRecordDO extends BaseDO {

    /**
     * 记录编号
     */
    private Long id;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 采收记录编号
     */
    private Long harvestRecordId;
    /**
     * 加工批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 加工日期
     */
    private LocalDate processDate;
    /**
     * 加工场所
     */
    private String processLocation;
    /**
     * 鲜品投入量(kg)
     */
    private BigDecimal freshWeightIn;
    /**
     * 干品产出量(kg)
     */
    private BigDecimal dryWeightOut;
    /**
     * 出成率(%)
     */
    private BigDecimal yieldRate;
    /**
     * 加工SOP编号
     */
    private Long sopId;
    /**
     * 操作人员
     */
    private String operatorIds;
    /**
     * 监督人
     */
    private Long supervisorId;
    /**
     * 加工开始时间
     */
    private LocalDateTime processStartTime;
    /**
     * 加工结束时间
     */
    private LocalDateTime processEndTime;
    /**
     * 使用设备编号
     */
    private String equipmentIds;
    /**
     * 用水来源
     */
    private String waterSource;
    /**
     * 水质检测编号
     */
    private Long waterTestId;
    /**
     * 状态(0加工中 1已完成 2检验中)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
