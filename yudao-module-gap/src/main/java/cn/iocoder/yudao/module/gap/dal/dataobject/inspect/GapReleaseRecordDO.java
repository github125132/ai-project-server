package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GAP 放行审核记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_release_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapReleaseRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 放行单号
     */
    private String releaseNo;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 来源类型(0加工 1入库)
     */
    private Integer sourceType;
    /**
     * 来源记录编号
     */
    private Long sourceRecordId;
    /**
     * 数量(kg)
     */
    private BigDecimal quantity;
    /**
     * 检验报告编号
     */
    private Long inspectReportId;
    /**
     * 检验结论(0合格 1不合格)
     */
    private Integer inspectConclusion;
    /**
     * 放行审核项目
     */
    private String releaseItems;
    /**
     * 质量审核人
     */
    private Long qualityReviewerId;
    /**
     * 质量审核时间
     */
    private LocalDateTime qualityReviewTime;
    /**
     * 质量审核意见
     */
    private String qualityReviewOpinion;
    /**
     * 批准人
     */
    private Long approverId;
    /**
     * 批准时间
     */
    private LocalDateTime approveTime;
    /**
     * 批准意见
     */
    private String approveOpinion;
    /**
     * 状态(0待审核 1质量审核通过 2已批准 3拒绝)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
