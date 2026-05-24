package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP FertilizationDetail Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapFertilizationDetailRespVO {

    @Schema(description = "编号")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "施肥记录编号")
    @ExcelProperty("施肥记录编号")
    private Long recordId;

    @Schema(description = "肥料产品编号")
    @ExcelProperty("肥料产品编号")
    private Long productId;

    @Schema(description = "肥料名称")
    @ExcelProperty("肥料名称")
    private String productName;

    @Schema(description = "用量")
    @ExcelProperty("用量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "有效成分")
    @ExcelProperty("有效成分")
    private String activeIngredient;

    @Schema(description = "施用面积(亩)")
    @ExcelProperty("施用面积(亩)")
    private BigDecimal applicationArea;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
