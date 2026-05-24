package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训参训人员 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTrainingParticipantRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "培训记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("培训记录编号")
    private Long recordId;

    @Schema(description = "参训人员", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("参训人员")
    private Long userId;

    @Schema(description = "部门", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("部门")
    private Long deptId;

    @Schema(description = "岗位")
    @ExcelProperty("岗位")
    private Long postId;

    @Schema(description = "是否出席")
    @ExcelProperty("是否出席")
    private Boolean isAttended;

    @Schema(description = "签到时间")
    @ExcelProperty("签到时间")
    private LocalDateTime attendanceTime;

    @Schema(description = "考核成绩")
    @ExcelProperty("考核成绩")
    private BigDecimal examScore;

    @Schema(description = "考核结果(0合格 1不合格 2未考核)")
    @ExcelProperty("考核结果")
    private Integer examResult;

    @Schema(description = "证书编号")
    @ExcelProperty("证书编号")
    private String certNo;

    @Schema(description = "证书附件")
    @ExcelProperty("证书附件")
    private String certUrl;

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
