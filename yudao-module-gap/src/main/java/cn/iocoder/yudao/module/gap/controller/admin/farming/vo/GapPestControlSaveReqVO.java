package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(description = "管理后台 - GAP 病虫害防治方案新增/修改 Request VO")
@Data
public class GapPestControlSaveReqVO {

    @Schema(description = "方案编号", example = "1024")
    private Long id;

    @Schema(description = "方案编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PC-2024-001")
    @NotEmpty(message = "方案编号不能为空")
    private String planNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "病虫害名称", example = "根腐病")
    private String pestName;

    @Schema(description = "类型(0病害 1虫害 2草害 3鼠害)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "类型不能为空")
    private Integer pestType;

    @Schema(description = "防治原则", example = "预防为主，综合防治")
    private String controlPrinciple;

    @Schema(description = "农业防治措施")
    private String agriculturalMethod;

    @Schema(description = "物理防治措施")
    private String physicalMethod;

    @Schema(description = "生物防治措施")
    private String biologicalMethod;

    @Schema(description = "化学防治措施")
    private String chemicalMethod;

    @Schema(description = "批准使用农药编号列表", example = "1,2,3")
    private String approvedPesticideIds;

    @Schema(description = "预防时期", example = "春季萌芽前")
    private String preventionPeriod;

    @Schema(description = "预警阈值", example = "虫口密度≥5头/株")
    private String warningThreshold;

    @Schema(description = "状态(0草稿 1已审批 2执行中 3已完成)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
