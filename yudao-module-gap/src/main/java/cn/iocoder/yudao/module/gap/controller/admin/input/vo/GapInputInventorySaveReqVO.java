package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 投入品库存新增/修改 Request VO")
@Data
public class GapInputInventorySaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "产品编号不能为空")
    private Long productId;

    @Schema(description = "批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "供应商编号不能为空")
    private Long supplierId;

    @Schema(description = "采购日期")
    private LocalDate purchaseDate;

    @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED, example = "100.0000")
    @NotNull(message = "库存数量不能为空")
    private BigDecimal quantity;

    @Schema(description = "单位", example = "瓶")
    private String unit;

    @Schema(description = "存放位置", example = "A区-01货架")
    private String warehouseLocation;

    @Schema(description = "生产日期")
    private LocalDate productionDate;

    @Schema(description = "有效期至")
    private LocalDate validityDate;

    @Schema(description = "状态(0正常 1近效期 2过期 3用完)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
