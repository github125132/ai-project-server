package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 养护检查记录新增/修改 Request VO")
@Data
public class GapStorageCheckSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "检查单号", example = "CHK-20240101-001")
    private String recordNo;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "仓库编号不能为空")
    private Long warehouseId;

    @Schema(description = "分区编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "分区编号不能为空")
    private Long areaId;

    @Schema(description = "检查日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "检查日期不能为空")
    private LocalDate checkDate;

    @Schema(description = "检查类型(0日常巡检 1定期养护 2特殊检查)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "检查类型不能为空")
    private Integer checkType;

    @Schema(description = "温度(°C)", example = "20.0")
    private BigDecimal temperature;

    @Schema(description = "湿度(%)", example = "60.0")
    private BigDecimal humidity;

    @Schema(description = "通风情况(0良好 1一般 2差)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "通风情况不能为空")
    private Integer ventilation;

    @Schema(description = "光照情况(0正常 1异常)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "光照情况不能为空")
    private Integer lighting;

    @Schema(description = "虫害检查(0无 1有)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "虫害检查不能为空")
    private Integer pestCheck;

    @Schema(description = "霉变检查(0无 1有)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "霉变检查不能为空")
    private Integer moldCheck;

    @Schema(description = "异味检查(0无 1有)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "异味检查不能为空")
    private Integer odorCheck;

    @Schema(description = "异常描述")
    private String abnormalDesc;

    @Schema(description = "处理措施")
    private String handlingMeasure;

    @Schema(description = "处理人", example = "1")
    private Long handlerId;

    @Schema(description = "检查人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "检查人不能为空")
    private Long checkerId;

    @Schema(description = "状态(0正常 1有异常已处理 2有异常待处理)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
