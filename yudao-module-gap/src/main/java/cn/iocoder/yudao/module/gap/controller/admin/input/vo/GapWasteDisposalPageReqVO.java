package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP waste_disposal分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapWasteDisposalPageReqVO extends PageParam {

    @Schema(description = "处理单号")
    private String recordNo;

    @Schema(description = "废弃物类型(0农药包装 1农药残液 2肥料袋 3其他)")
    private Integer wasteType;

    @Schema(description = "基地编号")
    private Long baseId;

    @Schema(description = "来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "数量")
    private BigDecimal quantity;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "处理日期")
    private LocalDate disposalDate;

    @Schema(description = "处理方式")
    private String disposalMethod;

    @Schema(description = "处理地点")
    private String disposalLocation;

    @Schema(description = "处理人")
    private Long handlerId;

    @Schema(description = "见证人")
    private Long witnessId;

    @Schema(description = "处理照片")
    private String photoUrl;

    @Schema(description = "状态")
    private Integer status;

}
