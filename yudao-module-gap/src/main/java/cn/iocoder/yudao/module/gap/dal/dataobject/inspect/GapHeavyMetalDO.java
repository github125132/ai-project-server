package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * GAP 重金属检测明细 DO
 *
 * @author 芋道源码
 */
@TableName("gap_heavy_metal")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapHeavyMetalDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 检验任务编号
     */
    private Long taskId;
    /**
     * 检验报告编号
     */
    private Long reportId;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 元素名称(铅/镉/砷/汞/铜)
     */
    private String elementName;
    /**
     * 检出值(mg/kg)
     */
    private BigDecimal detectedValue;
    /**
     * 限量值(mg/kg)
     */
    private BigDecimal limitValue;
    /**
     * 单位
     */
    private String unit;
    /**
     * 结论(0合格 1不合格)
     */
    private Integer conclusion;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
