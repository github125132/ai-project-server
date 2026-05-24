package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训课程 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTrainingCourseRespVO {

    @Schema(description = "课程编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("课程编号")
    private Long id;

    @Schema(description = "课程编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "COURSE-001")
    @ExcelProperty("课程编码")
    private String code;

    @Schema(description = "课程名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "GAP法规培训")
    @ExcelProperty("课程名称")
    private String name;

    @Schema(description = "类别(0GAP法规 1SOP 2安全生产 3职业道德 4专业技术 5质量管理)")
    @ExcelProperty("类别")
    private Integer category;

    @Schema(description = "课程内容")
    @ExcelProperty("课程内容")
    private String content;

    @Schema(description = "课时(小时)")
    @ExcelProperty("课时")
    private Integer duration;

    @Schema(description = "讲师")
    @ExcelProperty("讲师")
    private String instructor;

    @Schema(description = "讲师单位")
    @ExcelProperty("讲师单位")
    private String instructorOrg;

    @Schema(description = "培训资料附件")
    @ExcelProperty("培训资料附件")
    private String materialUrl;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
