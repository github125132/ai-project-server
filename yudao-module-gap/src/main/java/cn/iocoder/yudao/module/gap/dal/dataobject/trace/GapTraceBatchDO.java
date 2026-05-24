package cn.iocoder.yudao.module.gap.dal.dataobject.trace;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 溯源批次 DO
 *
 * @author 芋道源码
 */
@TableName("gap_trace_batch")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTraceBatchDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 追溯码
     */
    private String traceCode;
    /**
     * 批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 品种名称(快照)
     */
    private String varietyName;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 基地名称(快照)
     */
    private String baseName;
    /**
     * 基地地址(快照)
     */
    private String baseAddress;
    /**
     * 地块编号
     */
    private Long plotId;
    /**
     * 地块名称(快照)
     */
    private String plotName;
    /**
     * 种子批次编号
     */
    private Long seedBatchId;
    /**
     * 种植日期
     */
    private LocalDate plantingDate;
    /**
     * 采收日期
     */
    private LocalDate harvestDate;
    /**
     * 加工日期
     */
    private LocalDate processDate;
    /**
     * 包装日期
     */
    private LocalDate packageDate;
    /**
     * 包装规格
     */
    private BigDecimal packageWeight;
    /**
     * 总重量(kg)
     */
    private BigDecimal totalWeight;
    /**
     * 包装件数
     */
    private Integer packageCount;
    /**
     * 质量状态(0合格 1不合格)
     */
    private Integer qualityStatus;
    /**
     * 检验报告编号
     */
    private Long inspectReportId;
    /**
     * 放行单编号
     */
    private Long releaseId;
    /**
     * 二维码图片
     */
    private String qrCodeUrl;
    /**
     * 状态(0种植中 1已采收 2已加工 3已入库 4已放行 5已出库 6已销售)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
