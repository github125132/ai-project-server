package cn.iocoder.yudao.module.gap.dal.dataobject.quality;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 质量标准 DO
 *
 * @author 芋道源码
 */
@TableName("gap_quality_standard")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapQualityStandardDO extends BaseDO {

    /**
     * 标准编号
     */
    private Long id;
    /**
     * 标准编码
     */
    private String code;
    /**
     * 标准名称
     */
    private String name;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 标准级别(0企业内控 1国家标准 2行业标准)
     */
    private Integer standardLevel;
    /**
     * 版本号
     */
    private String version;
    /**
     * 生效日期
     */
    private LocalDate effectiveDate;
    /**
     * 失效日期
     */
    private LocalDate expiryDate;
    /**
     * 基源要求
     */
    private String sourceSpecies;
    /**
     * 性状描述
     */
    private String appearanceDesc;
    /**
     * 鉴别方法
     */
    private String identificationMethod;
    /**
     * 检查项目
     */
    private String inspectionItems;
    /**
     * 水分限度(%)
     */
    private BigDecimal moistureLimit;
    /**
     * 灰分限度(%)
     */
    private BigDecimal ashLimit;
    /**
     * 浸出物限度(%)
     */
    private BigDecimal extractLimit;
    /**
     * 含量测定限度
     */
    private String contentLimit;
    /**
     * 农药残留限度
     */
    private String pesticideLimit;
    /**
     * 重金属限度
     */
    private String heavyMetalLimit;
    /**
     * 霉菌限度
     */
    private String mouldLimit;
    /**
     * 黄曲霉毒素限度
     */
    private String aflatoxinLimit;
    /**
     * 批准人
     */
    private Long approverId;
    /**
     * 批准时间
     */
    private LocalDateTime approveTime;
    /**
     * 状态(0草稿 1已批准 2已废止)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
