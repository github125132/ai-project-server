package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 农事记录新增/修改 Request VO")
@Data
public class GapFarmingRecordSaveReqVO {

    @Schema(description = "记录编号", example = "1024")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "FR-2024-001")
    @NotEmpty(message = "记录单号不能为空")
    private String recordNo;

    @Schema(description = "农事类型(0整地 1播种 2育苗 3移栽 4中耕 5除草 6灌溉 7施肥 8整枝 9覆盖 10病虫害防治 11采收)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "农事类型不能为空")
    private Integer recordType;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "地块编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "地块编号不能为空")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "BATCH-001")
    private String plotBatchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "操作日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "操作日期不能为空")
    private LocalDate operateDate;

    @Schema(description = "天气情况", example = "晴")
    private String weather;

    @Schema(description = "气温", example = "25.5")
    private BigDecimal temperature;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "监督人", example = "2")
    private Long supervisorId;

    @Schema(description = "工时(h)", example = "8.0")
    private BigDecimal workHours;

    @Schema(description = "用工人数", example = "5")
    private Integer workersCount;

    @Schema(description = "作业面积(亩)", example = "10.0000")
    private BigDecimal workArea;

    @Schema(description = "是否核对气象", example = "false")
    private Boolean isWeatherChecked;

    @Schema(description = "现场照片")
    private String photoUrl;

    @Schema(description = "状态(0草稿 1已提交 2已审核)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "审核人", example = "1")
    private Long auditUserId;

    @Schema(description = "审核时间")
    private LocalDateTime auditTime;

    @Schema(description = "备注")
    private String remark;

}
