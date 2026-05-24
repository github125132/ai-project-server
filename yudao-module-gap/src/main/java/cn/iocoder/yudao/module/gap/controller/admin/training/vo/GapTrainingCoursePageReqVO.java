package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 培训课程分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTrainingCoursePageReqVO extends PageParam {

    @Schema(description = "课程编码", example = "COURSE-001")
    private String code;

    @Schema(description = "课程名称", example = "GAP法规")
    private String name;

    @Schema(description = "类别(0GAP法规 1SOP 2安全生产 3职业道德 4专业技术 5质量管理)", example = "0")
    private Integer category;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
