package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * GAP 农残检测明细 DO
 *
 * @author 芋道源码
 */
@TableName("gap_pesticide_residue")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPesticideResidueDO extends BaseDO {

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
     * 农药名称
     */
    private String pesticideName;
    /**
     * 农药类别(有机氯/有机磷/氨基甲酸酯等)
     */
    private String pesticideCategory;
    /**
     * 是否禁用农药
     */
    private Boolean isBanned;
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
     * 检测限
     */
    private BigDecimal detectionLimit;
    /**
     * 结论(0合格 1不合格 2未检出)
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
