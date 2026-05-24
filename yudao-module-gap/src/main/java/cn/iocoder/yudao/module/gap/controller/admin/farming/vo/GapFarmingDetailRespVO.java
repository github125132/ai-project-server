package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 农事记录明细 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapFarmingDetailRespVO {

    @Schema(description = "明细编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("明细编号")
    private Long id;

    @Schema(description = "农事记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("农事记录编号")
    private Long recordId;

    @Schema(description = "明细类型(0整地深度 1播种量 2移栽密度 3除草方式 4灌溉量 5肥料种类 6施肥量 7整枝方式 8覆盖材料 9防治对象 10采收量)")
    @ExcelProperty("明细类型")
    private Integer detailType;

    @Schema(description = "项目/物品名称")
    @ExcelProperty("项目/物品名称")
    private String itemName;

    @Schema(description = "数值/用量")
    @ExcelProperty("数值/用量")
    private String itemValue;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String itemUnit;

    @Schema(description = "规格说明")
    @ExcelProperty("规格说明")
    private String itemSpec;

    @Schema(description = "操作前状态")
    @ExcelProperty("操作前状态")
    private String beforeStatus;

    @Schema(description = "操作后状态")
    @ExcelProperty("操作后状态")
    private String afterStatus;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
