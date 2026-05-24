package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 药材出库记录新增/修改 Request VO")
@Data
public class GapStorageOutRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "出库单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "OUT-20240101-001")
    @NotEmpty(message = "出库单号不能为空")
    private String recordNo;

    @Schema(description = "入库记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "入库记录编号不能为空")
    private Long inRecordId;

    @Schema(description = "药材批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "仓库编号不能为空")
    private Long warehouseId;

    @Schema(description = "分区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "分区编号不能为空")
    private Long areaId;

    @Schema(description = "出库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "出库日期不能为空")
    private LocalDate outDate;

    @Schema(description = "出库数量(kg)", example = "50.0000")
    private BigDecimal quantity;

    @Schema(description = "出库件数", example = "5")
    private Integer packageCount;

    @Schema(description = "出库类型(0销售 1调拨 2取样 3退货 4销毁)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "出库类型不能为空")
    private Integer outType;

    @Schema(description = "接收方")
    private String receiver;

    @Schema(description = "接收方联系人")
    private String receiverContact;

    @Schema(description = "接收地址")
    private String receiverAddress;

    @Schema(description = "运输单号")
    private String transportNo;

    @Schema(description = "放行单编号", example = "1")
    private Long releaseId;

    @Schema(description = "出库人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "出库人不能为空")
    private Long operatorId;

    @Schema(description = "复核人", example = "2")
    private Long checkerId;

    @Schema(description = "状态(0待出库 1已出库)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
