package cn.iocoder.yudao.module.gap.dal.dataobject.process;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 包装记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_package_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapPackageRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 加工记录编号
     */
    private Long processRecordId;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 包装日期
     */
    private LocalDate packageDate;
    /**
     * 包装材料
     */
    private String packageMaterial;
    /**
     * 包材批次号
     */
    private String materialBatchNo;
    /**
     * 包装规格(kg/包)
     */
    private BigDecimal packageWeight;
    /**
     * 包装数量
     */
    private Integer packageCount;
    /**
     * 总重量(kg)
     */
    private BigDecimal totalWeight;
    /**
     * 标签内容
     */
    private String labelContent;
    /**
     * 标签样张附件
     */
    private String labelSampleUrl;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 监督人
     */
    private Long supervisorId;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
