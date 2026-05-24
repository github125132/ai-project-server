package cn.iocoder.yudao.module.gap.dal.dataobject.audit;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
/**
 * GAP audit_checklist DO
 *
 * @author 芋道源码
 */
@TableName("gap_audit_checklist")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapAuditChecklistDO extends BaseDO {
    /**
     * 检查表编号
     */
    private Long id;
    /**
     * 检查表编号
     */
    private String checklistNo;
    /**
     * 审核计划编号
     */
    private Long planId;
    /**
     * 检查表名称
     */
    private String name;
    /**
     * 检查章节
     */
    private String checkChapter;
    /**
     * 适用条款
     */
    private String applicableClauses;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
