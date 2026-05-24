package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP waste_disposal Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapWasteDisposalRespVO {

    @Schema(description = "编号")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "处理单号")
    @ExcelProperty("处理单号")
    private String recordNo;

    @Schema(description = "废弃物类型(0农药包装 1农药残液 2肥料袋 3其他)")
    @ExcelProperty("废弃物类型(0农药包装 1农药残液 2肥料袋 3其他)")
    private Integer wasteType;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "来源记录编号")
    @ExcelProperty("来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "数量")
    @ExcelProperty("数量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "处理日期")
    @ExcelProperty("处理日期")
    private LocalDate disposalDate;

    @Schema(description = "处理方式")
    @ExcelProperty("处理方式")
    private String disposalMethod;

    @Schema(description = "处理地点")
    @ExcelProperty("处理地点")
    private String disposalLocation;

    @Schema(description = "处理人")
    @ExcelProperty("处理人")
    private Long handlerId;

    @Schema(description = "见证人")
    @ExcelProperty("见证人")
    private Long witnessId;

    @Schema(description = "处理照片")
    @ExcelProperty("处理照片")
    private String photoUrl;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
