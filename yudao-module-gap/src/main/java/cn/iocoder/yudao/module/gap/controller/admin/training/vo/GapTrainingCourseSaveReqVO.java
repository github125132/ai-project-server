package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - GAP 培训课程新增/修改 Request VO")
@Data
public class GapTrainingCourseSaveReqVO {

    @Schema(description = "课程编号", example = "1024")
    private Long id;

    @Schema(description = "课程编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "COURSE-001")
    @NotEmpty(message = "课程编码不能为空")
    private String code;

    @Schema(description = "课程名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "GAP法规培训")
    @NotEmpty(message = "课程名称不能为空")
    private String name;

    @Schema(description = "类别(0GAP法规 1SOP 2安全生产 3职业道德 4专业技术 5质量管理)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "类别不能为空")
    private Integer category;

    @Schema(description = "课程内容")
    private String content;

    @Schema(description = "课时(小时)", example = "8")
    private Integer duration;

    @Schema(description = "讲师", example = "张三")
    private String instructor;

    @Schema(description = "讲师单位", example = "XX农业大学")
    private String instructorOrg;

    @Schema(description = "培训资料附件")
    private String materialUrl;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
