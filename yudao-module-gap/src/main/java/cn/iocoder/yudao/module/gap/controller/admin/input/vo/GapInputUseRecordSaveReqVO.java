package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 投入品使用记录新增/修改 Request VO")
@Data
public class GapInputUseRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "使用单号", example = "USE-20240101-001")
    private String recordNo;

    @Schema(description = "产品编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "产品编号不能为空")
    private Long productId;

    @Schema(description = "库存编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "库存编号不能为空")
    private Long inventoryId;

    @Schema(description = "产品批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "使用类型(0农药 1肥料 2其他)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "使用类型不能为空")
    private Integer useType;

    @Schema(description = "使用日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "使用日期不能为空")
    private LocalDate useDate;

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "基地编号不能为空")
    private Long baseId;

    @Schema(description = "地块编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "地块编号不能为空")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "PLANT-20240101-001")
    private String plotBatchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "使用量", example = "50.0000")
    private BigDecimal quantity;

    @Schema(description = "单位", example = "ml")
    private String unit;

    @Schema(description = "稀释倍数", example = "1:1000")
    private String dilutionRatio;

    @Schema(description = "施用面积(亩)", example = "10.0000")
    private BigDecimal applicationArea;

    @Schema(description = "施用方法", example = "喷雾")
    private String applicationMethod;

    @Schema(description = "天气条件", example = "晴")
    private String weatherCondition;

    @Schema(description = "风向", example = "东南风")
    private String windDirection;

    @Schema(description = "风速", example = "2级")
    private String windSpeed;

    @Schema(description = "气温", example = "25.5")
    private BigDecimal temperature;

    @Schema(description = "操作人员", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "操作人员不能为空")
    private Long operatorId;

    @Schema(description = "安全间隔期(天)", example = "7")
    private Integer safetyInterval;

    @Schema(description = "最早采收日期")
    private LocalDate earliestHarvestDate;

    @Schema(description = "禁用拦截校验", example = "false")
    private Boolean bannedCheck;

    @Schema(description = "使用现场照片")
    private String photoUrl;

    @Schema(description = "状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
