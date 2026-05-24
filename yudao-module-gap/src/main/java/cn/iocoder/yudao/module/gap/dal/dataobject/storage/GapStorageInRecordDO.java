package cn.iocoder.yudao.module.gap.dal.dataobject.storage;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 药材入库记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_storage_in_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapStorageInRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 入库单号
     */
    private String recordNo;
    /**
     * 药材批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 加工记录编号
     */
    private Long processRecordId;
    /**
     * 包装记录编号
     */
    private Long packageRecordId;
    /**
     * 仓库编号
     */
    private Long warehouseId;
    /**
     * 分区编号
     */
    private Long areaId;
    /**
     * 入库日期
     */
    private LocalDate inDate;
    /**
     * 入库数量(kg)
     */
    private BigDecimal quantity;
    /**
     * 包装件数
     */
    private Integer packageCount;
    /**
     * 质量状态(0待验 1合格 2不合格)
     */
    private Integer qualityStatus;
    /**
     * 外观检查
     */
    private String appearanceCheck;
    /**
     * 标签检查
     */
    private String labelCheck;
    /**
     * 验收人
     */
    private Long inspectorId;
    /**
     * 储存条件
     */
    private String storageCondition;
    /**
     * 温度(°C)
     */
    private BigDecimal temperature;
    /**
     * 湿度(%)
     */
    private BigDecimal humidity;
    /**
     * 复验日期
     */
    private LocalDate reinspectDate;
    /**
     * 有效期至
     */
    private LocalDate validityDate;
    /**
     * 状态(0待验 1已入库 2已移库 3已出库)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
