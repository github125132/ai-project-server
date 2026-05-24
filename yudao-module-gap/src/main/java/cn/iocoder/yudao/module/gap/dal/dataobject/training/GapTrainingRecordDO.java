package cn.iocoder.yudao.module.gap.dal.dataobject.training;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GAP training_record DO
 *
 * @author 芋道源码
 */
@TableName("gap_training_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTrainingRecordDO extends BaseDO {
    /**
     * 记录编号
     */
    private Long id;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 培训计划编号
     */
    private Long planId;
    /**
     * 课程编号
     */
    private Long courseId;
    /**
     * 培训日期
     */
    private LocalDate trainingDate;
    /**
     * 开始时间
     */
    private LocalDateTime trainingStartTime;
    /**
     * 结束时间
     */
    private LocalDateTime trainingEndTime;
    /**
     * 培训地点
     */
    private String trainingLocation;
    /**
     * 讲师
     */
    private String instructor;
    /**
     * 参加人数
     */
    private Integer participantCount;
    /**
     * 培训内容快照
     */
    private String contentSnapshot;
    /**
     * 签到表附件
     */
    private String attendanceUrl;
    /**
     * 培训照片
     */
    private String photoUrl;
    /**
     * 状态(0已计划 1已完成 2已考核)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
