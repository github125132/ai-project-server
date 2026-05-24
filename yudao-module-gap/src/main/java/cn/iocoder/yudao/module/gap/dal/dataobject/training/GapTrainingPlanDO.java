package cn.iocoder.yudao.module.gap.dal.dataobject.training;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP training_plan DO
 *
 * @author 芋道源码
 */
@TableName("gap_training_plan")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTrainingPlanDO extends BaseDO {
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
     * 课程编号
     */
    private Long courseId;
    /**
     * 培训类型(0新员工 1在岗 2转岗 3晋升 4继续教育)
     */
    private Integer trainingType;
    /**
     * 目标部门
     */
    private Long targetDeptId;
    /**
     * 目标岗位
     */
    private String targetPostIds;
    /**
     * 计划开始日期
     */
    private LocalDate plannedStartDate;
    /**
     * 计划结束日期
     */
    private LocalDate plannedEndDate;
    /**
     * 计划人数
     */
    private Integer plannedParticipants;
    /**
     * 培训地点
     */
    private String trainingLocation;
    /**
     * 培训方式
     */
    private String trainingMethod;
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
