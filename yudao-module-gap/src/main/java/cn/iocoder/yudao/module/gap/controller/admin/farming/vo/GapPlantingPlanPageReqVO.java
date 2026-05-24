package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 种植计划分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPlantingPlanPageReqVO extends PageParam {

    @Schema(description = "计划编号", example = "PLAN-2024-001")
    private String planNo;

    @Schema(description = "年度", example = "2024")
    private Integer year;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3已执行 4已取消)", example = "0")
    private Integer status;

}
