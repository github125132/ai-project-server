package cn.iocoder.yudao.module.gap.dal.dataobject.audit;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.time.LocalDate;

/**
 * GAP nc_item DO
 *
 * @author 芋道源码
 */
@TableName("gap_nc_item")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapNcItemDO extends BaseDO {
    /**
     * 编号
     */
    private Long id;
    /**
     * 不符合项编号
     */
    private String ncNo;
    /**
     * 审核计划编号
     */
    private Long planId;
    /**
     * 检查表编号
     */
    private Long checklistId;
    /**
     * 检查项目编号
     */
    private Long checklistItemId;
    /**
     * 不符合类型(0一般 1严重)
     */
    private Integer ncType;
    /**
     * 不符合描述
     */
    private String ncDesc;
    /**
     * 引用条款
     */
    private String clauseReference;
    /**
     * 证据
     */
    private String evidence;
    /**
     * 责任部门
     */
    private Long auditedDeptId;
    /**
     * 责任人
     */
    private Long responsibleUserId;
    /**
     * 根本原因分析
     */
    private String rootCause;
    /**
     * 纠正措施
     */
    private String correctiveAction;
    /**
     * 纠正期限
     */
    private LocalDate correctiveDeadline;
    /**
     * 纠正完成日期
     */
    private LocalDate correctiveCompletionDate;
    /**
     * 预防措施
     */
    private String preventiveAction;
    /**
     * 预防期限
     */
    private LocalDate preventiveDeadline;
    /**
     * 预防完成日期
     */
    private LocalDate preventiveCompletionDate;
    /**
     * 验证人
     */
    private Long verifierId;
    /**
     * 验证日期
     */
    private LocalDate verifyDate;
    /**
     * 验证结果(0待验证 1有效 2无效)
     */
    private Integer verifyResult;
    /**
     * 验证意见
     */
    private String verifyOpinion;
    /**
     * 状态(0待整改 1整改中 2待验证 3已关闭)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
