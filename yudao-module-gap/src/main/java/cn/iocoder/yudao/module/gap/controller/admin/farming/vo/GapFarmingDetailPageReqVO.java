package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 农事记录明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapFarmingDetailPageReqVO extends PageParam {

    @Schema(description = "农事记录编号", example = "1")
    private Long recordId;

    @Schema(description = "明细类型(0整地深度 1播种量 2移栽密度 3除草方式 4灌溉量 5肥料种类 6施肥量 7整枝方式 8覆盖材料 9防治对象 10采收量)", example = "0")
    private Integer detailType;

    @Schema(description = "项目/物品名称", example = "整地深度")
    private String itemName;

}
