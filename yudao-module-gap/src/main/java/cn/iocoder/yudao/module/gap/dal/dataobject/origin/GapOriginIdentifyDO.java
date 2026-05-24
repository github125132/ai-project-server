package cn.iocoder.yudao.module.gap.dal.dataobject.origin;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 基源鉴定 DO
 */
@TableName("gap_origin_identify")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapOriginIdentifyDO extends BaseDO {

    /**
     * 鉴定编号
     */
    private Long id;
    /**
     * 鉴定报告编号
     */
    private String identifyNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 种子批次编号
     */
    private Long seedBatchId;
    /**
     * 鉴定方法(形态学/DNA条形码等)
     */
    private String identifyMethod;
    /**
     * 鉴定机构
     */
    private String identifyOrg;
    /**
     * 鉴定人
     */
    private String identifyPerson;
    /**
     * 鉴定日期
     */
    private LocalDate identifyDate;
    /**
     * 鉴定结果
     */
    private String identifyResult;
    /**
     * 鉴定结论
     */
    private String conclusion;
    /**
     * 鉴定报告附件
     */
    private String reportUrl;
    /**
     * 标本照片附件
     */
    private String specimenUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
