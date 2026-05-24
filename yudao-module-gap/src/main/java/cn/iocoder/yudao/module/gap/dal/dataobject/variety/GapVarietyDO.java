package cn.iocoder.yudao.module.gap.dal.dataobject.variety;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;

/**
 * GAP 品种档案 DO
 */
@TableName("gap_variety")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapVarietyDO extends BaseDO {

    /**
     * 品种编号
     */
    private Long id;
    /**
     * 品种编码
     */
    private String code;
    /**
     * 品种名称
     */
    private String name;
    /**
     * 拉丁学名
     */
    private String latinName;
    /**
     * 科
     */
    private String family;
    /**
     * 属
     */
    private String genus;
    /**
     * 种
     */
    private String species;
    /**
     * 品种
     */
    private String varietyName;
    /**
     * 药用部位
     */
    private String medicinalPart;
    /**
     * 道地产区
     */
    private String originArea;
    /**
     * 生长周期(月)
     */
    private Integer growthCycle;
    /**
     * 适宜气候
     */
    private String suitableClimate;
    /**
     * 适宜土壤
     */
    private String suitableSoil;
    /**
     * 亩产(kg)
     */
    private BigDecimal yieldPerMu;
    /**
     * 质量标准编号
     */
    private Long qualityStandardId;
    /**
     * 状态(0正常 1停用)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
