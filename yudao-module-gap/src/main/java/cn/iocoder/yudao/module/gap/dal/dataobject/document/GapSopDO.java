package cn.iocoder.yudao.module.gap.dal.dataobject.document;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP SOP库 DO
 *
 * @author 芋道源码
 */
@TableName("gap_sop")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapSopDO extends BaseDO {

    /**
     * SOP编号
     */
    private Long id;
    /**
     * SOP编号
     */
    private String sopNo;
    /**
     * SOP名称
     */
    private String name;
    /**
     * 类别(0种植 1采收 2加工 3仓储 4检验 5设备 6卫生)
     */
    private Integer category;
    /**
     * 版本号
     */
    private String version;
    /**
     * 目的
     */
    private String purpose;
    /**
     * 适用范围
     */
    private String scope;
    /**
     * 职责
     */
    private String responsibility;
    /**
     * 操作步骤
     */
    private String procedure;
    /**
     * 注意事项
     */
    private String precautions;
    /**
     * 相关文件
     */
    private String relatedDocs;
    /**
     * 相关记录
     */
    private String relatedRecords;
    /**
     * 生效日期
     */
    private LocalDate effectiveDate;
    /**
     * 附件
     */
    private String fileUrl;
    /**
     * 批准人
     */
    private Long approverId;
    /**
     * 批准日期
     */
    private LocalDate approveDate;
    /**
     * 状态(0草稿 1已批准 2已废止)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
