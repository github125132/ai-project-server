package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 加工工序明细 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapProcessDetailRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "加工记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("加工记录编号")
    private Long processRecordId;

    @Schema(description = "工序序号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("工序序号")
    private Integer processStep;

    @Schema(description = "工序名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("工序名称")
    private String processName;

    @Schema(description = "开始时间")
    @ExcelProperty("开始时间")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @ExcelProperty("结束时间")
    private LocalDateTime endTime;

    @Schema(description = "时长(分钟)")
    @ExcelProperty("时长(分钟)")
    private Integer duration;

    @Schema(description = "温度(°C)")
    @ExcelProperty("温度(°C)")
    private BigDecimal temperature;

    @Schema(description = "湿度(%)")
    @ExcelProperty("湿度(%)")
    private BigDecimal humidity;

    @Schema(description = "工艺参数")
    @ExcelProperty("工艺参数")
    private String parameter;

    @Schema(description = "工序前重量(kg)")
    @ExcelProperty("工序前重量(kg)")
    private BigDecimal weightBefore;

    @Schema(description = "工序后重量(kg)")
    @ExcelProperty("工序后重量(kg)")
    private BigDecimal weightAfter;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "监督人")
    @ExcelProperty("监督人")
    private Long supervisorId;

    @Schema(description = "检查结果(0合格 1不合格)")
    @ExcelProperty("检查结果")
    private Integer checkResult;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
