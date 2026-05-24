package cn.iocoder.yudao.module.gap.dal.dataobject.input;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP waste_disposal DO
 *
 * @author 芋道源码
 */
@TableName("gap_waste_disposal")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapWasteDisposalDO extends BaseDO {
    /**
     * 编号
     */
    private Long id;
    /**
     * 处理单号
     */
    private String recordNo;
    /**
     * 废弃物类型(0农药包装 1农药残液 2肥料袋 3其他)
     */
    private Integer wasteType;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 来源记录编号
     */
    private Long sourceRecordId;
    /**
     * 数量
     */
    private BigDecimal quantity;
    /**
     * 单位
     */
    private String unit;
    /**
     * 处理日期
     */
    private LocalDate disposalDate;
    /**
     * 处理方式
     */
    private String disposalMethod;
    /**
     * 处理地点
     */
    private String disposalLocation;
    /**
     * 处理人
     */
    private Long handlerId;
    /**
     * 见证人
     */
    private Long witnessId;
    /**
     * 处理照片
     */
    private String photoUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
