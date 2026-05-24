package cn.iocoder.yudao.module.gap.dal.dataobject.farming;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 农事记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_farming_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapFarmingRecordDO extends BaseDO {

    /**
     * 记录编号
     */
    private Long id;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 农事类型(0整地 1播种 2育苗 3移栽 4中耕 5除草 6灌溉 7施肥 8整枝 9覆盖 10病虫害防治 11采收)
     */
    private Integer recordType;
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
     * 品种编号
     */
    private Long varietyId;
    /**
     * 操作日期
     */
    private LocalDate operateDate;
    /**
     * 天气情况
     */
    private String weather;
    /**
     * 气温
     */
    private BigDecimal temperature;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 监督人
     */
    private Long supervisorId;
    /**
     * 工时(h)
     */
    private BigDecimal workHours;
    /**
     * 用工人数
     */
    private Integer workersCount;
    /**
     * 作业面积(亩)
     */
    private BigDecimal workArea;
    /**
     * 是否核对气象
     */
    private Boolean isWeatherChecked;
    /**
     * 现场照片
     */
    private String photoUrl;
    /**
     * 状态(0草稿 1已提交 2已审核)
     */
    private Integer status;
    /**
     * 审核人
     */
    private Long auditUserId;
    /**
     * 审核时间
     */
    private LocalDateTime auditTime;
    /**
     * 备注
     */
    private String remark;

}
