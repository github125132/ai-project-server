package cn.iocoder.yudao.module.gap.controller.admin.treatment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 种子处理记录新增/修改 Request VO")
@Data
public class GapSeedTreatmentSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "种子批次编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "种子批次编号不能为空")
    private Long seedBatchId;

    @Schema(description = "处理方式(0消毒 1浸种 2催芽 3包衣)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "处理方式不能为空")
    private Integer treatmentType;

    @Schema(description = "处理日期")
    private LocalDate treatmentDate;

    @Schema(description = "处理方法", example = "温汤浸种")
    private String method;

    @Schema(description = "药剂名称", example = "多菌灵")
    private String medicineName;

    @Schema(description = "药剂用量", example = "500ml/亩")
    private String medicineDosage;

    @Schema(description = "处理时长", example = "2小时")
    private String duration;

    @Schema(description = "操作人员", example = "1")
    private Long operatorId;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
