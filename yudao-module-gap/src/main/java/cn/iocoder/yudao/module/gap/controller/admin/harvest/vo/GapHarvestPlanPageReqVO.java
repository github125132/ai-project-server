package cn.iocoder.yudao.module.gap.controller.admin.harvest.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 采收计划分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapHarvestPlanPageReqVO extends PageParam {

    @Schema(description = "计划编号", example = "HP-20240101-001")
    private String planNo;

    @Schema(description = "种植计划编号", example = "1")
    private Long plantingPlanId;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "BATCH-001")
    private String plotBatchNo;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3已执行 4已取消)", example = "0")
    private Integer status;

    @Schema(description = "计划采收日期开始")
    private LocalDate plannedHarvestDateStart;

    @Schema(description = "计划采收日期结束")
    private LocalDate plannedHarvestDateEnd;

}
