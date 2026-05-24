package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 培训参训人员分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTrainingParticipantPageReqVO extends PageParam {

    @Schema(description = "培训记录编号", example = "1")
    private Long recordId;

    @Schema(description = "参训人员", example = "1")
    private Long userId;

    @Schema(description = "部门", example = "1")
    private Long deptId;

    @Schema(description = "考核结果(0合格 1不合格 2未考核)", example = "0")
    private Integer examResult;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
