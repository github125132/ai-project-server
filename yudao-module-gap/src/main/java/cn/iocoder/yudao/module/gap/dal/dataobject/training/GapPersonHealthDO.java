package cn.iocoder.yudao.module.gap.dal.dataobject.training;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.time.LocalDate;

/**
 * GAP person_health DO
 *
 * @author 芋道源码
 */
@TableName("gap_person_health")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPersonHealthDO extends BaseDO {
    /**
     * 编号
     */
    private Long id;
    /**
     * 人员编号
     */
    private Long userId;
    /**
     * 体检日期
     */
    private LocalDate checkDate;
    /**
     * 体检机构
     */
    private String checkOrg;
    /**
     * 检查项目
     */
    private String checkItem;
    /**
     * 检查结果
     */
    private String checkResult;
    /**
     * 是否传染病
     */
    private Boolean isContagious;
    /**
     * 是否皮肤病
     */
    private Boolean isSkinDisease;
    /**
     * 是否合格
     */
    private Boolean isQualified;
    /**
     * 健康证号
     */
    private String healthCertNo;
    /**
     * 健康证附件
     */
    private String healthCertUrl;
    /**
     * 有效期至
     */
    private LocalDate validityDate;
    /**
     * 下次体检日期
     */
    private LocalDate nextCheckDate;
    /**
     * 是否已发送到期预警
     */
    private Boolean warningSent;
    /**
     * 状态(0有效 1即将过期 2已过期)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
