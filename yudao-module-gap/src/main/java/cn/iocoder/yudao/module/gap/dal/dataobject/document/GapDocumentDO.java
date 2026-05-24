package cn.iocoder.yudao.module.gap.dal.dataobject.document;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 文件档案 DO
 *
 * @author 芋道源码
 */
@TableName("gap_document")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapDocumentDO extends BaseDO {

    /**
     * 文件编号
     */
    private Long id;
    /**
     * 文件编号
     */
    private String docNo;
    /**
     * 文件名称
     */
    private String name;
    /**
     * 分类编号
     */
    private Long categoryId;
    /**
     * 版本号
     */
    private String version;
    /**
     * 文件内容/正文
     */
    private String content;
    /**
     * 适用范围
     */
    private String scope;
    /**
     * 起草人
     */
    private Long drafterId;
    /**
     * 起草日期
     */
    private LocalDate draftDate;
    /**
     * 审核人
     */
    private Long reviewerId;
    /**
     * 审核日期
     */
    private LocalDate reviewDate;
    /**
     * 审核意见
     */
    private String reviewOpinion;
    /**
     * 批准人
     */
    private Long approverId;
    /**
     * 批准日期
     */
    private LocalDate approveDate;
    /**
     * 生效日期
     */
    private LocalDate effectiveDate;
    /**
     * 失效日期
     */
    private LocalDate expiryDate;
    /**
     * 文件附件
     */
    private String fileUrl;
    /**
     * 发放范围
     */
    private String distributionScope;
    /**
     * 保存期限(年)
     */
    private Integer retentionPeriod;
    /**
     * 是否现行有效
     */
    private Boolean isEffective;
    /**
     * 替代文件编号
     */
    private Long replacedDocId;
    /**
     * 状态(0草稿 1审核中 2已批准 3已废止)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
