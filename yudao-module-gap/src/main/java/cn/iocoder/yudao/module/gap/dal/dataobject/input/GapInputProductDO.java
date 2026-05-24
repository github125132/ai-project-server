package cn.iocoder.yudao.module.gap.dal.dataobject.input;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GAP 投入品产品 DO
 *
 * @author 芋道源码
 */
@TableName("gap_input_product")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInputProductDO extends BaseDO {

    /**
     * 产品编号
     */
    private Long id;
    /**
     * 产品编码
     */
    private String code;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 分类编号
     */
    private Long categoryId;
    /**
     * 大类(0农药 1肥料 2生物制剂 3其他)
     */
    private Integer categoryType;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 规格
     */
    private String specification;
    /**
     * 生产厂家
     */
    private String manufacturer;
    /**
     * 登记证号
     */
    private String registrationNo;
    /**
     * 生产许可证号
     */
    private String productionLicense;
    /**
     * 有效成分
     */
    private String activeIngredient;
    /**
     * 含量
     */
    private String content;
    /**
     * 单位
     */
    private String unit;
    /**
     * 剂型
     */
    private String formulation;
    /**
     * 是否禁用农药
     */
    private Boolean banned;
    /**
     * 是否限用
     */
    private Boolean restricted;
    /**
     * 限用说明
     */
    private String restrictedNote;
    /**
     * 安全间隔期(天)
     */
    private Integer safetyInterval;
    /**
     * 最大残留限量
     */
    private String maxResidueLimit;
    /**
     * 适用作物/范围
     */
    private String usageScope;
    /**
     * 储存条件
     */
    private String storageCondition;
    /**
     * 保质期(月)
     */
    private Integer shelfLife;
    /**
     * 状态(0正常 1停用)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
