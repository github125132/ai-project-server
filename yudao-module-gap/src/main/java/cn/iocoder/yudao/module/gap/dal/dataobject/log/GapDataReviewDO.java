package cn.iocoder.yudao.module.gap.dal.dataobject.log;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * GAP 关键数据复核记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_data_review")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapDataReviewDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 记录编号
     */
    private Long recordId;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 复核类型(0录入复核 1定期复核 2专项复核)
     */
    private Integer reviewType;
    /**
     * 复核内容
     */
    private String reviewContent;
    /**
     * 复核结果(0合格 1不合格)
     */
    private Integer reviewResult;
    /**
     * 发现问题
     */
    private String findings;
    /**
     * 复核人
     */
    private Long reviewerId;
    /**
     * 复核时间
     */
    private LocalDateTime reviewTime;
    /**
     * 纠正措施
     */
    private String correctiveAction;
    /**
     * 状态(0待复核 1已复核 2已纠正)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
