package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 药材出库记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapStorageOutRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "出库单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("出库单号")
    private String recordNo;

    @Schema(description = "入库记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("入库记录编号")
    private Long inRecordId;

    @Schema(description = "药材批次号")
    @ExcelProperty("药材批次号")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("仓库编号")
    private Long warehouseId;

    @Schema(description = "分区编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分区编号")
    private Long areaId;

    @Schema(description = "出库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("出库日期")
    private LocalDate outDate;

    @Schema(description = "出库数量(kg)")
    @ExcelProperty("出库数量(kg)")
    private BigDecimal quantity;

    @Schema(description = "出库件数")
    @ExcelProperty("出库件数")
    private Integer packageCount;

    @Schema(description = "出库类型(0销售 1调拨 2取样 3退货 4销毁)")
    @ExcelProperty("出库类型")
    private Integer outType;

    @Schema(description = "接收方")
    @ExcelProperty("接收方")
    private String receiver;

    @Schema(description = "接收方联系人")
    @ExcelProperty("接收方联系人")
    private String receiverContact;

    @Schema(description = "接收地址")
    @ExcelProperty("接收地址")
    private String receiverAddress;

    @Schema(description = "运输单号")
    @ExcelProperty("运输单号")
    private String transportNo;

    @Schema(description = "放行单编号")
    @ExcelProperty("放行单编号")
    private Long releaseId;

    @Schema(description = "出库人", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("出库人")
    private Long operatorId;

    @Schema(description = "复核人")
    @ExcelProperty("复核人")
    private Long checkerId;

    @Schema(description = "状态(0待出库 1已出库)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
