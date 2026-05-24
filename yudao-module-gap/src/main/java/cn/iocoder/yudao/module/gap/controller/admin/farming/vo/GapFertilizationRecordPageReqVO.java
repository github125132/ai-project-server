package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP FertilizationRecord分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapFertilizationRecordPageReqVO extends PageParam {

    @Schema(description = "记录单号")
    private String recordNo;

    @Schema(description = "基地编号")
    private Long baseId;

    @Schema(description = "地块编号")
    private Long plotId;

    @Schema(description = "地块种植批次")
    private String plotBatchNo;

    @Schema(description = "施肥日期")
    private LocalDate fertilizeDate;

    @Schema(description = "肥料类型(0基肥 1追肥 2叶面肥)")
    private Integer fertilizeType;

    @Schema(description = "施肥时期")
    private String fertilizeStage;

    @Schema(description = "施肥方法")
    private String fertilizeMethod;

    @Schema(description = "操作人")
    private Long operatorId;

    @Schema(description = "状态")
    private Integer status;

}
