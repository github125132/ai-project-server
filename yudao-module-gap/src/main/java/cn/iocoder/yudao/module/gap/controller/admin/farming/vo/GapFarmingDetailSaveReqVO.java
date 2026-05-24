package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - GAP 农事记录明细新增/修改 Request VO")
@Data
public class GapFarmingDetailSaveReqVO {

    @Schema(description = "明细编号", example = "1024")
    private Long id;

    @Schema(description = "农事记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "农事记录编号不能为空")
    private Long recordId;

    @Schema(description = "明细类型(0整地深度 1播种量 2移栽密度 3除草方式 4灌溉量 5肥料种类 6施肥量 7整枝方式 8覆盖材料 9防治对象 10采收量)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "明细类型不能为空")
    private Integer detailType;

    @Schema(description = "项目/物品名称", example = "整地深度")
    private String itemName;

    @Schema(description = "数值/用量", example = "20")
    private String itemValue;

    @Schema(description = "单位", example = "cm")
    private String itemUnit;

    @Schema(description = "规格说明")
    private String itemSpec;

    @Schema(description = "操作前状态")
    private String beforeStatus;

    @Schema(description = "操作后状态")
    private String afterStatus;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "排序不能为空")
    private Integer sort;

    @Schema(description = "备注")
    private String remark;

}
