package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 养护检查记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapStorageCheckRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "检查单号")
    @ExcelProperty("检查单号")
    private String recordNo;

    @Schema(description = "仓库编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("仓库编号")
    private Long warehouseId;

    @Schema(description = "分区编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("分区编号")
    private Long areaId;

    @Schema(description = "检查日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("检查日期")
    private LocalDate checkDate;

    @Schema(description = "检查类型(0日常巡检 1定期养护 2特殊检查)")
    @ExcelProperty("检查类型")
    private Integer checkType;

    @Schema(description = "温度(°C)")
    @ExcelProperty("温度(°C)")
    private BigDecimal temperature;

    @Schema(description = "湿度(%)")
    @ExcelProperty("湿度(%)")
    private BigDecimal humidity;

    @Schema(description = "通风情况(0良好 1一般 2差)")
    @ExcelProperty("通风情况")
    private Integer ventilation;

    @Schema(description = "光照情况(0正常 1异常)")
    @ExcelProperty("光照情况")
    private Integer lighting;

    @Schema(description = "虫害检查(0无 1有)")
    @ExcelProperty("虫害检查")
    private Integer pestCheck;

    @Schema(description = "霉变检查(0无 1有)")
    @ExcelProperty("霉变检查")
    private Integer moldCheck;

    @Schema(description = "异味检查(0无 1有)")
    @ExcelProperty("异味检查")
    private Integer odorCheck;

    @Schema(description = "异常描述")
    @ExcelProperty("异常描述")
    private String abnormalDesc;

    @Schema(description = "处理措施")
    @ExcelProperty("处理措施")
    private String handlingMeasure;

    @Schema(description = "处理人")
    @ExcelProperty("处理人")
    private Long handlerId;

    @Schema(description = "检查人", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("检查人")
    private Long checkerId;

    @Schema(description = "状态(0正常 1有异常已处理 2有异常待处理)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
