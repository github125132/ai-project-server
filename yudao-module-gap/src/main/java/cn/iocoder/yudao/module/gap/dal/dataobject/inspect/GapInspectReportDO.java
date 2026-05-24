package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 检验报告 DO
 *
 * @author 芋道源码
 */
@TableName("gap_inspect_report")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInspectReportDO extends BaseDO {

    /**
     * 报告编号
     */
    private Long id;
    /**
     * 报告编号
     */
    private String reportNo;
    /**
     * 检验任务编号
     */
    private Long taskId;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 样品编号
     */
    private String sampleNo;
    /**
     * 报告类型(0全检 1委托 2抽检)
     */
    private Integer reportType;
    /**
     * 检验机构
     */
    private String inspectOrg;
    /**
     * 检验日期
     */
    private LocalDate inspectDate;
    /**
     * 报告日期
     */
    private LocalDate reportDate;
    /**
     * 综合结论(0合格 1不合格)
     */
    private Integer overallConclusion;
    /**
     * 综合结论描述
     */
    private String overallConclusionDesc;
    /**
     * 报告附件
     */
    private String reportUrl;
    /**
     * 检验人
     */
    private Long inspectorId;
    /**
     * 复核人
     */
    private Long reviewerId;
    /**
     * 批准人
     */
    private Long approverId;
    /**
     * 批准时间
     */
    private LocalDateTime approveTime;
    /**
     * 状态(0草稿 1已审核 2已批准)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
