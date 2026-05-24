package cn.iocoder.yudao.module.gap.dal.dataobject.document;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 记录模板 DO
 *
 * @author 芋道源码
 */
@TableName("gap_record_template")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapRecordTemplateDO extends BaseDO {

    /**
     * 模板编号
     */
    private Long id;
    /**
     * 模板编号
     */
    private String templateNo;
    /**
     * 模板名称
     */
    private String name;
    /**
     * 分类编号
     */
    private Long categoryId;
    /**
     * 模板类型(0原始记录 1台账 2报告)
     */
    private Integer templateType;
    /**
     * 模板内容(JSON)
     */
    private String content;
    /**
     * 填写规范
     */
    private String fillRules;
    /**
     * 修改规范
     */
    private String modifyRules;
    /**
     * 复核规范
     */
    private String reviewRules;
    /**
     * 保存期限(年)
     */
    private Integer retentionPeriod;
    /**
     * 生效日期
     */
    private LocalDate effectiveDate;
    /**
     * 模板附件
     */
    private String fileUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
