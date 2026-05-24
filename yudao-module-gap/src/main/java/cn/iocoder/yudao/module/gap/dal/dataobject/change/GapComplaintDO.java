package cn.iocoder.yudao.module.gap.dal.dataobject.change;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 投诉记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_complaint")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapComplaintDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 投诉编号
     */
    private String complaintNo;
    /**
     * 投诉日期
     */
    private LocalDate complaintDate;
    /**
     * 投诉人
     */
    private String complainant;
    /**
     * 联系方式
     */
    private String contactInfo;
    /**
     * 投诉类型(0质量 1包装 2运输 3其他)
     */
    private Integer complaintType;
    /**
     * 涉及批次号
     */
    private String batchNo;
    /**
     * 涉及品种
     */
    private Long varietyId;
    /**
     * 投诉内容
     */
    private String complaintContent;
    /**
     * 调查结果
     */
    private String investigation;
    /**
     * 处理结论
     */
    private String conclusion;
    /**
     * 处理人
     */
    private Long handlerId;
    /**
     * 处理日期
     */
    private LocalDate handleDate;
    /**
     * 回复内容
     */
    private String responseContent;
    /**
     * 回复日期
     */
    private LocalDate responseDate;
    /**
     * 客户满意度(0满意 1一般 2不满意)
     */
    private Integer customerSatisfaction;
    /**
     * 状态(0待处理 1处理中 2已回复 3已关闭)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
