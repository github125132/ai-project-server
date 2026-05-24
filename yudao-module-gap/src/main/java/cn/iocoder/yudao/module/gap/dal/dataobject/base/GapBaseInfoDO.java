package cn.iocoder.yudao.module.gap.dal.dataobject.base;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 基地信息 DO
 *
 * @author 芋道源码
 */
@TableName("gap_base_info")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapBaseInfoDO extends BaseDO {

    /**
     * 基地编号
     */
    private Long id;
    /**
     * 基地编码
     */
    private String code;
    /**
     * 基地名称
     */
    private String name;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区县
     */
    private String district;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 总面积(亩)
     */
    private BigDecimal area;
    /**
     * 种植面积(亩)
     */
    private BigDecimal plantingArea;
    /**
     * 海拔(m)
     */
    private BigDecimal altitude;
    /**
     * 状态(0正常 1停用)
     */
    private Integer status;
    /**
     * 环境评估状态
     */
    private Integer envAssessStatus;
    /**
     * 环境评估日期
     */
    private LocalDate envAssessDate;
    /**
     * 环境评估报告附件
     */
    private String envAssessReportUrl;
    /**
     * 基地负责人
     */
    private Long responsibleUserId;
    /**
     * 生产负责人
     */
    private Long managerUserId;
    /**
     * 质量负责人
     */
    private Long qualityUserId;
    /**
     * 备注
     */
    private String remark;

}
