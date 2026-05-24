package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP FertilizationDetail新增/修改 Request VO")
@Data
public class GapFertilizationDetailSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "施肥记录编号")
    private Long recordId;

    @Schema(description = "肥料产品编号")
    private Long productId;

    @Schema(description = "肥料名称")
    private String productName;

    @Schema(description = "用量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "有效成分")
    private String activeIngredient;

    @Schema(description = "施用面积(亩)")
    private BigDecimal applicationArea;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

}
