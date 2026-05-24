package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 培训计划分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTrainingPlanPageReqVO extends PageParam {

    @Schema(description = "计划编号", example = "PLAN-2024-001")
    private String planNo;

    @Schema(description = "计划名称", example = "GAP法规")
    private String planName;

    @Schema(description = "年度", example = "2024")
    private Integer year;

    @Schema(description = "课程编号", example = "1")
    private Long courseId;

    @Schema(description = "培训类型(0新员工 1在岗 2转岗 3晋升 4继续教育)", example = "0")
    private Integer trainingType;

    @Schema(description = "状态(0草稿 1待审批 2已批准 3执行中 4已完成)", example = "0")
    private Integer status;

}
