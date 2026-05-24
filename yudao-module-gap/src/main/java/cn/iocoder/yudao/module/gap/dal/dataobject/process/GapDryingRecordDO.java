package cn.iocoder.yudao.module.gap.dal.dataobject.process;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GAP 干燥记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_drying_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapDryingRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 加工记录编号
     */
    private Long processRecordId;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 干燥方式(0晒干 1阴干 2烘干 3风干)
     */
    private Integer dryingMethod;
    /**
     * 干燥开始时间
     */
    private LocalDateTime dryingStartTime;
    /**
     * 干燥结束时间
     */
    private LocalDateTime dryingEndTime;
    /**
     * 干燥时长(小时)
     */
    private Integer dryingDuration;
    /**
     * 初始水分(%)
     */
    private BigDecimal initialMoisture;
    /**
     * 目标水分(%)
     */
    private BigDecimal targetMoisture;
    /**
     * 最终水分(%)
     */
    private BigDecimal finalMoisture;
    /**
     * 最高温度(°C)
     */
    private BigDecimal maxTemp;
    /**
     * 最低温度(°C)
     */
    private BigDecimal minTemp;
    /**
     * 平均温度(°C)
     */
    private BigDecimal avgTemp;
    /**
     * 环境湿度(%)
     */
    private BigDecimal humidity;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 水分检测编号
     */
    private Long moistureTestId;
    /**
     * 状态(0干燥中 1已完成 2不合格)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
