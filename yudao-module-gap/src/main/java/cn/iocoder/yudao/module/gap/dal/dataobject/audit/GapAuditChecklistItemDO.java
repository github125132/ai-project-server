package cn.iocoder.yudao.module.gap.dal.dataobject.audit;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
/**
 * GAP audit_checklist_item DO
 *
 * @author 芋道源码
 */
@TableName("gap_audit_checklist_item")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapAuditChecklistItemDO extends BaseDO {
    /**
     * 编号
     */
    private Long id;
    /**
     * 检查表编号
     */
    private Long checklistId;
    /**
     * 项目编号
     */
    private String itemNo;
    /**
     * 章节
     */
    private String chapter;
    /**
     * 条款
     */
    private String clause;
    /**
     * 检查内容
     */
    private String checkContent;
    /**
     * 检查方法
     */
    private String checkMethod;
    /**
     * 检查标准
     */
    private String checkStandard;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
