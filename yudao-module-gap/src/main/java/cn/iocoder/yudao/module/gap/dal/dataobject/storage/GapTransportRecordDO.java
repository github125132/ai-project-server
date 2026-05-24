package cn.iocoder.yudao.module.gap.dal.dataobject.storage;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GAP 运输记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_transport_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTransportRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 运输单号
     */
    private String transportNo;
    /**
     * 药材批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 出库记录编号
     */
    private Long outRecordId;
    /**
     * 车辆编号/车牌号
     */
    private String vehicleNo;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 司机电话
     */
    private String driverPhone;
    /**
     * 运输开始时间
     */
    private LocalDateTime transportStartTime;
    /**
     * 运输结束时间
     */
    private LocalDateTime transportEndTime;
    /**
     * 起运地
     */
    private String fromLocation;
    /**
     * 目的地
     */
    private String toLocation;
    /**
     * 运输数量(kg)
     */
    private BigDecimal quantity;
    /**
     * 件数
     */
    private Integer packageCount;
    /**
     * 车辆清洁检查
     */
    private Boolean vehicleCleanCheck;
    /**
     * 防雨措施
     */
    private Boolean weatherProtection;
    /**
     * 封签号
     */
    private String sealNo;
    /**
     * 温湿度监控记录
     */
    private String tempMonitorUrl;
    /**
     * 收货人
     */
    private String receiverName;
    /**
     * 签收单附件
     */
    private String receiverSignUrl;
    /**
     * 状态(0待运输 1运输中 2已送达 3异常)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
