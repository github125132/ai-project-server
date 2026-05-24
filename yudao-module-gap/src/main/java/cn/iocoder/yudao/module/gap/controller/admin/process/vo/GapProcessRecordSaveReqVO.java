package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 加工记录新增/修改 Request VO")
@Data
public class GapProcessRecordSaveReqVO {

    @Schema(description = "记录编号", example = "1024")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "PR-20240101-001")
    @NotEmpty(message = "记录单号不能为空")
    private String recordNo;

    @Schema(description = "采收记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "采收记录编号不能为空")
    private Long harvestRecordId;

    @Schema(description = "加工批次号", example = "BATCH-001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "加工日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "加工日期不能为空")
    private LocalDate processDate;

    @Schema(description = "加工场所", example = "一号加工车间")
    private String processLocation;

    @Schema(description = "鲜品投入量(kg)", example = "500.00")
    private BigDecimal freshWeightIn;

    @Schema(description = "干品产出量(kg)", example = "100.00")
    private BigDecimal dryWeightOut;

    @Schema(description = "出成率(%)", example = "20.00")
    private BigDecimal yieldRate;

    @Schema(description = "加工SOP编号", example = "1")
    private Long sopId;

    @Schema(description = "操作人员", example = "1,2,3")
    private String operatorIds;

    @Schema(description = "监督人", example = "1")
    private Long supervisorId;

    @Schema(description = "加工开始时间")
    private LocalDateTime processStartTime;

    @Schema(description = "加工结束时间")
    private LocalDateTime processEndTime;

    @Schema(description = "使用设备编号", example = "1,2")
    private String equipmentIds;

    @Schema(description = "用水来源", example = "山泉水")
    private String waterSource;

    @Schema(description = "水质检测编号", example = "1")
    private Long waterTestId;

    @Schema(description = "状态(0加工中 1已完成 2检验中)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
