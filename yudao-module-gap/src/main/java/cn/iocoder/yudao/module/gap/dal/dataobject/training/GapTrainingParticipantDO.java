package cn.iocoder.yudao.module.gap.dal.dataobject.training;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * GAP training_participant DO
 *
 * @author 芋道源码
 */
@TableName("gap_training_participant")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTrainingParticipantDO extends BaseDO {
    /**
     * 编号
     */
    private Long id;
    /**
     * 培训记录编号
     */
    private Long recordId;
    /**
     * 参训人员
     */
    private Long userId;
    /**
     * 部门
     */
    private Long deptId;
    /**
     * 岗位
     */
    private Long postId;
    /**
     * 是否出席
     */
    private Boolean isAttended;
    /**
     * 签到时间
     */
    private LocalDateTime attendanceTime;
    /**
     * 考核成绩
     */
    private BigDecimal examScore;
    /**
     * 考核结果(0合格 1不合格 2未考核)
     */
    private Integer examResult;
    /**
     * 证书编号
     */
    private String certNo;
    /**
     * 证书附件
     */
    private String certUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
