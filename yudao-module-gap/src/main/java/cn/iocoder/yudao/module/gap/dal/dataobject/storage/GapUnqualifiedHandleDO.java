package cn.iocoder.yudao.module.gap.dal.dataobject.storage;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 不合格品处理 DO
 *
 * @author 芋道源码
 */
@TableName("gap_unqualified_handle")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapUnqualifiedHandleDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 处理单号
     */
    private String recordNo;
    /**
     * 来源类型(0采收 1加工 2检验 3仓储)
     */
    private Integer sourceType;
    /**
     * 来源记录编号
     */
    private Long sourceRecordId;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 不合格原因
     */
    private String unqualifiedReason;
    /**
     * 数量(kg)
     */
    private BigDecimal quantity;
    /**
     * 处理方式(0返工 1降级 2销毁 3退货)
     */
    private Integer handleMethod;
    /**
     * 处理结果
     */
    private String handleResult;
    /**
     * 处理日期
     */
    private LocalDate handleDate;
    /**
     * 处理人
     */
    private Long handlerId;
    /**
     * 监督人
     */
    private Long supervisorId;
    /**
     * 处理照片
     */
    private String photoUrl;
    /**
     * 状态(0待处理 1处理中 2已处理)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
