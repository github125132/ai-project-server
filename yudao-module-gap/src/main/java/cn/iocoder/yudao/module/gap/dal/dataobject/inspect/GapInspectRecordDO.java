package cn.iocoder.yudao.module.gap.dal.dataobject.inspect;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 检验记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_inspect_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInspectRecordDO extends BaseDO {

    /**
     * 记录编号
     */
    private Long id;
    /**
     * 检验单号
     */
    private String recordNo;
    /**
     * 检验任务编号
     */
    private Long taskId;
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
     * 检验类型(0性状 1鉴别 2检查 3含量测定 4农残 5重金属)
     */
    private Integer inspectType;
    /**
     * 检验日期
     */
    private LocalDate inspectDate;
    /**
     * 检验方法
     */
    private String inspectMethod;
    /**
     * 检验仪器
     */
    private String instrument;
    /**
     * 检验结果值
     */
    private String resultValue;
    /**
     * 标准值
     */
    private String standardValue;
    /**
     * 单位
     */
    private String unit;
    /**
     * 单项结论(0合格 1不合格 2未检)
     */
    private Integer conclusion;
    /**
     * 检验人
     */
    private Long inspectorId;
    /**
     * 复核人
     */
    private Long reviewerId;
    /**
     * 原始记录附件
     */
    private String originalRecordUrl;
    /**
     * 检验照片
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
