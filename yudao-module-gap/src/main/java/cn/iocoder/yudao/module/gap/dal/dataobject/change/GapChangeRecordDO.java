package cn.iocoder.yudao.module.gap.dal.dataobject.change;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP 变更记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_change_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapChangeRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 变更单号
     */
    private String changeNo;
    /**
     * 变更类型(0基地 1品种 2工艺 3设备 4人员 5SOP 6供应商)
     */
    private Integer changeType;
    /**
     * 变更标题
     */
    private String changeTitle;
    /**
     * 变更描述
     */
    private String changeDesc;
    /**
     * 变更前状态
     */
    private String beforeStatus;
    /**
     * 变更后状态
     */
    private String afterStatus;
    /**
     * 影响分析
     */
    private String affectAnalysis;
    /**
     * 风险评估
     */
    private String riskAssessment;
    /**
     * 验证计划
     */
    private String validationPlan;
    /**
     * 提出人
     */
    private Long proposerId;
    /**
     * 提出日期
     */
    private LocalDate proposeDate;
    /**
     * 计划实施日期
     */
    private LocalDate plannedDate;
    /**
     * 实际实施日期
     */
    private LocalDate actualDate;
    /**
     * 审批人
     */
    private Long approverId;
    /**
     * 审批时间
     */
    private LocalDateTime approveTime;
    /**
     * 审批意见
     */
    private String approveOpinion;
    /**
     * 审批流程实例ID(关联bpm)
     */
    private String processInstanceId;
    /**
     * 状态(0待评估 1评估中 2待审批 3已批准 4已实施 5已验证 6已关闭)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
