package cn.iocoder.yudao.module.gap.dal.dataobject.process;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GAP 加工工序明细 DO
 *
 * @author 芋道源码
 */
@TableName("gap_process_detail")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapProcessDetailDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 加工记录编号
     */
    private Long processRecordId;
    /**
     * 工序序号
     */
    private Integer processStep;
    /**
     * 工序名称(0清洗 1去皮 2切制 3干燥 4挑选 5分级 6蒸制 7煮制 8烫制 9发汗)
     */
    private String processName;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 时长(分钟)
     */
    private Integer duration;
    /**
     * 温度(°C)
     */
    private BigDecimal temperature;
    /**
     * 湿度(%)
     */
    private BigDecimal humidity;
    /**
     * 工艺参数
     */
    private String parameter;
    /**
     * 工序前重量(kg)
     */
    private BigDecimal weightBefore;
    /**
     * 工序后重量(kg)
     */
    private BigDecimal weightAfter;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 监督人
     */
    private Long supervisorId;
    /**
     * 检查结果(0合格 1不合格)
     */
    private Integer checkResult;
    /**
     * 备注
     */
    private String remark;

}
