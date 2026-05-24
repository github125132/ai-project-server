package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 投入品库存 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInputInventoryRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("产品编号")
    private Long productId;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "供应商编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("供应商编号")
    private Long supplierId;

    @Schema(description = "采购日期")
    @ExcelProperty("采购日期")
    private LocalDate purchaseDate;

    @Schema(description = "库存数量", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("库存数量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "存放位置")
    @ExcelProperty("存放位置")
    private String warehouseLocation;

    @Schema(description = "生产日期")
    @ExcelProperty("生产日期")
    private LocalDate productionDate;

    @Schema(description = "有效期至")
    @ExcelProperty("有效期至")
    private LocalDate validityDate;

    @Schema(description = "状态(0正常 1近效期 2过期 3用完)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
