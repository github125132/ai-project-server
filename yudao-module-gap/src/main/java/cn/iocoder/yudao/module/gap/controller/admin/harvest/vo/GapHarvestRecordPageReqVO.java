package cn.iocoder.yudao.module.gap.controller.admin.harvest.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 采收记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapHarvestRecordPageReqVO extends PageParam {

    @Schema(description = "记录单号", example = "HR-20240101-001")
    private String recordNo;

    @Schema(description = "采收计划编号", example = "1")
    private Long harvestPlanId;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "采收批次号(关联追溯)", example = "TRACE-001")
    private String batchNo;

    @Schema(description = "状态(0已采收 1已运送 2已加工)", example = "0")
    private Integer status;

    @Schema(description = "采收日期开始")
    private LocalDate harvestDateStart;

    @Schema(description = "采收日期结束")
    private LocalDate harvestDateEnd;

}
