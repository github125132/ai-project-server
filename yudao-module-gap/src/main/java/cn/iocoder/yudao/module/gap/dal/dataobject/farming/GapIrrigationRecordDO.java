package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 灌溉记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_irrigation_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapIrrigationRecordDO extends BaseDO {

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
     * 灌溉日期
     */
    private LocalDate irrigateDate;
    /**
     * 灌溉时段
     */
    private String irrigateTime;
    /**
     * 灌溉方式
     */
    private String irrigateMethod;
    /**
     * 水源
     */
    private String waterSource;
    /**
     * 用水量(m³)
     */
    private BigDecimal waterVolume;
    /**
     * 灌溉面积(亩)
     */
    private BigDecimal irrigateArea;
    /**
     * 灌溉前土壤湿度(%)
     */
    private BigDecimal soilMoistureBefore;
    /**
     * 灌溉后土壤湿度(%)
     */
    private BigDecimal soilMoistureAfter;
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
