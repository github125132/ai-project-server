package cn.iocoder.yudao.module.gap.dal.dataobject.storage;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 养护检查记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_storage_check")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapStorageCheckDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 检查单号
     */
    private String recordNo;
    /**
     * 仓库编号
     */
    private Long warehouseId;
    /**
     * 分区编号
     */
    private Long areaId;
    /**
     * 检查日期
     */
    private LocalDate checkDate;
    /**
     * 检查类型(0日常巡检 1定期养护 2特殊检查)
     */
    private Integer checkType;
    /**
     * 温度(°C)
     */
    private BigDecimal temperature;
    /**
     * 湿度(%)
     */
    private BigDecimal humidity;
    /**
     * 通风情况(0良好 1一般 2差)
     */
    private Integer ventilation;
    /**
     * 光照情况(0正常 1异常)
     */
    private Integer lighting;
    /**
     * 虫害检查(0无 1有)
     */
    private Integer pestCheck;
    /**
     * 霉变检查(0无 1有)
     */
    private Integer moldCheck;
    /**
     * 异味检查(0无 1有)
     */
    private Integer odorCheck;
    /**
     * 异常描述
     */
    private String abnormalDesc;
    /**
     * 处理措施
     */
    private String handlingMeasure;
    /**
     * 处理人
     */
    private Long handlerId;
    /**
     * 检查人
     */
    private Long checkerId;
    /**
     * 状态(0正常 1有异常已处理 2有异常待处理)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
