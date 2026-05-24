package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 药材入库记录新增/修改 Request VO")
@Data
public class GapStorageInRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "入库单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "IN-20240101-001")
    @NotEmpty(message = "入库单号不能为空")
    private String recordNo;

    @Schema(description = "药材批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "加工记录编号不能为空")
    private Long processRecordId;

    @Schema(description = "包装记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "包装记录编号不能为空")
    private Long packageRecordId;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "仓库编号不能为空")
    private Long warehouseId;

    @Schema(description = "分区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "分区编号不能为空")
    private Long areaId;

    @Schema(description = "入库日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "入库日期不能为空")
    private LocalDate inDate;

    @Schema(description = "入库数量(kg)", example = "100.0000")
    private BigDecimal quantity;

    @Schema(description = "包装件数", example = "10")
    private Integer packageCount;

    @Schema(description = "质量状态(0待验 1合格 2不合格)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "质量状态不能为空")
    private Integer qualityStatus;

    @Schema(description = "外观检查")
    private String appearanceCheck;

    @Schema(description = "标签检查")
    private String labelCheck;

    @Schema(description = "验收人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "验收人不能为空")
    private Long inspectorId;

    @Schema(description = "储存条件")
    private String storageCondition;

    @Schema(description = "温度(°C)", example = "20.0")
    private BigDecimal temperature;

    @Schema(description = "湿度(%)", example = "60.0")
    private BigDecimal humidity;

    @Schema(description = "复验日期")
    private LocalDate reinspectDate;

    @Schema(description = "有效期至")
    private LocalDate validityDate;

    @Schema(description = "状态(0待验 1已入库 2已移库 3已出库)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
