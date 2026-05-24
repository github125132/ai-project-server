package cn.iocoder.yudao.module.gap.dal.dataobject.training;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
/**
 * GAP training_course DO
 *
 * @author 芋道源码
 */
@TableName("gap_training_course")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTrainingCourseDO extends BaseDO {
    /**
     * 课程编号
     */
    private Long id;
    /**
     * 课程编码
     */
    private String code;
    /**
     * 课程名称
     */
    private String name;
    /**
     * 类别(0GAP法规 1SOP 2安全生产 3职业道德 4专业技术 5质量管理)
     */
    private Integer category;
    /**
     * 课程内容
     */
    private String content;
    /**
     * 课时(小时)
     */
    private Integer duration;
    /**
     * 讲师
     */
    private String instructor;
    /**
     * 讲师单位
     */
    private String instructorOrg;
    /**
     * 培训资料附件
     */
    private String materialUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
