package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP FertilizationDetail分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapFertilizationDetailPageReqVO extends PageParam {

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

}
