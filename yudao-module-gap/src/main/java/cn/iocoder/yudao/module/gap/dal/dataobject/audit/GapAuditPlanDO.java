package cn.iocoder.yudao.module.gap.dal.dataobject.audit;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP audit_plan DO
 *
 * @author 芋道源码
 */
@TableName("gap_audit_plan")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapAuditPlanDO extends BaseDO {
    /**
     * 计划编号
     */
    private Long id;
    /**
     * 计划编号
     */
    private String planNo;
    /**
     * 年度
     */
    private Integer year;
    /**
     * 计划名称
     */
    private String planName;
    /**
     * 审核类型(0内部审核 1管理评审 2专项检查)
     */
    private Integer auditType;
    /**
     * 审核范围
     */
    private String auditScope;
    /**
     * 计划开始日期
     */
    private LocalDate plannedStartDate;
    /**
     * 计划结束日期
     */
    private LocalDate plannedEndDate;
    /**
     * 审核组长
     */
    private Long auditorLeaderId;
    /**
     * 审核组员
     */
    private String auditorIds;
    /**
     * 被审核部门
     */
    private String auditedDeptIds;
    /**
     * 审批人
     */
    private Long approverId;
    /**
     * 审批时间
     */
    private LocalDateTime approveTime;
    /**
     * 状态(0草稿 1待审批 2已批准 3执行中 4已完成)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
