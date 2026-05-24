package cn.iocoder.yudao.module.gap.dal.dataobject.treatment;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 种子处理记录 DO
 */
@TableName("gap_seed_treatment")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapSeedTreatmentDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 种子批次编号
     */
    private Long seedBatchId;
    /**
     * 处理方式(0消毒 1浸种 2催芽 3包衣)
     */
    private Integer treatmentType;
    /**
     * 处理日期
     */
    private LocalDate treatmentDate;
    /**
     * 处理方法
     */
    private String method;
    /**
     * 药剂名称
     */
    private String medicineName;
    /**
     * 药剂用量
     */
    private String medicineDosage;
    /**
     * 处理时长
     */
    private String duration;
    /**
     * 操作人员
     */
    private Long operatorId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
