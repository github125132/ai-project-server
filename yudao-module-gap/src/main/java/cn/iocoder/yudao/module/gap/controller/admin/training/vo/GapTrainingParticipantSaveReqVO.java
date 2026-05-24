package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 培训参训人员新增/修改 Request VO")
@Data
public class GapTrainingParticipantSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "培训记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "培训记录编号不能为空")
    private Long recordId;

    @Schema(description = "参训人员", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "参训人员不能为空")
    private Long userId;

    @Schema(description = "部门", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "部门不能为空")
    private Long deptId;

    @Schema(description = "岗位", example = "1")
    private Long postId;

    @Schema(description = "是否出席", example = "true")
    private Boolean isAttended;

    @Schema(description = "签到时间")
    private LocalDateTime attendanceTime;

    @Schema(description = "考核成绩", example = "85.5")
    private BigDecimal examScore;

    @Schema(description = "考核结果(0合格 1不合格 2未考核)", example = "0")
    private Integer examResult;

    @Schema(description = "证书编号", example = "CERT-001")
    private String certNo;

    @Schema(description = "证书附件")
    private String certUrl;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
