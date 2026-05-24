package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 检验任务 DO
 *
 * @author 芋道源码
 */
@TableName("gap_inspect_task")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInspectTaskDO extends BaseDO {

    /**
     * 任务编号
     */
    private Long id;
    /**
     * 任务单号
     */
    private String taskNo;
    /**
     * 任务类型(0原料检验 1过程检验 2成品检验 3农残检测 4重金属检测 5委托检验)
     */
    private Integer taskType;
    /**
     * 来源类型(0采收 1加工 2入库 3在库 4出库)
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
     * 质量标准编号
     */
    private Long standardId;
    /**
     * 取样量
     */
    private BigDecimal sampleQuantity;
    /**
     * 取样单位
     */
    private String sampleUnit;
    /**
     * 取样日期
     */
    private LocalDate sampleDate;
    /**
     * 取样人
     */
    private Long samplerId;
    /**
     * 取样方法
     */
    private String sampleMethod;
    /**
     * 取样地点
     */
    private String sampleLocation;
    /**
     * 检验机构(内部/委托)
     */
    private String inspectOrg;
    /**
     * 计划完成日期
     */
    private LocalDate plannedCompleteDate;
    /**
     * 实际完成日期
     */
    private LocalDate actualCompleteDate;
    /**
     * 检验人
     */
    private Long inspectorId;
    /**
     * 状态(0待取样 1已取样 2检验中 3已完成 4不合格)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
