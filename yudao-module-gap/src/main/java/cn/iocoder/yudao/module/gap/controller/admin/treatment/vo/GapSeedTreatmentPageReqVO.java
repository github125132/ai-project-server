package cn.iocoder.yudao.module.gap.controller.admin.treatment.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 种子处理记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapSeedTreatmentPageReqVO extends PageParam {

    @Schema(description = "种子批次编号", example = "1")
    private Long seedBatchId;

    @Schema(description = "处理方式(0消毒 1浸种 2催芽 3包衣)", example = "0")
    private Integer treatmentType;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "处理日期开始")
    private LocalDate treatmentDateBegin;

    @Schema(description = "处理日期结束")
    private LocalDate treatmentDateEnd;

}
