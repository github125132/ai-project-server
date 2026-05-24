package cn.iocoder.yudao.module.gap.dal.dataobject.storage;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 药材出库记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_storage_out_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapStorageOutRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 出库单号
     */
    private String recordNo;
    /**
     * 入库记录编号
     */
    private Long inRecordId;
    /**
     * 药材批次号
     */
    private String batchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 仓库编号
     */
    private Long warehouseId;
    /**
     * 分区编号
     */
    private Long areaId;
    /**
     * 出库日期
     */
    private LocalDate outDate;
    /**
     * 出库数量(kg)
     */
    private BigDecimal quantity;
    /**
     * 出库件数
     */
    private Integer packageCount;
    /**
     * 出库类型(0销售 1调拨 2取样 3退货 4销毁)
     */
    private Integer outType;
    /**
     * 接收方
     */
    private String receiver;
    /**
     * 接收方联系人
     */
    private String receiverContact;
    /**
     * 接收地址
     */
    private String receiverAddress;
    /**
     * 运输单号
     */
    private String transportNo;
    /**
     * 放行单编号
     */
    private Long releaseId;
    /**
     * 出库人
     */
    private Long operatorId;
    /**
     * 复核人
     */
    private Long checkerId;
    /**
     * 状态(0待出库 1已出库)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
