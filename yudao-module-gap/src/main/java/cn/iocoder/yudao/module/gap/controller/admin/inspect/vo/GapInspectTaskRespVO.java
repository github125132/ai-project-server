package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP InspectTask Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInspectTaskRespVO {

    @Schema(description = "任务编号")
    @ExcelProperty("任务编号")
    private Long id;

    @Schema(description = "任务单号")
    @ExcelProperty("任务单号")
    private String taskNo;

    @Schema(description = "任务类型(0原料检验 1过程检验 2成品检验 3农残检测 4重金属检测 5委托检验)")
    @ExcelProperty("任务类型(0原料检验 1过程检验 2成品检验 3农残检测 4重金属检测 5委托检验)")
    private Integer taskType;

    @Schema(description = "来源类型(0采收 1加工 2入库 3在库 4出库)")
    @ExcelProperty("来源类型(0采收 1加工 2入库 3在库 4出库)")
    private Integer sourceType;

    @Schema(description = "来源记录编号")
    @ExcelProperty("来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "质量标准编号")
    @ExcelProperty("质量标准编号")
    private Long standardId;

    @Schema(description = "取样量")
    @ExcelProperty("取样量")
    private BigDecimal sampleQuantity;

    @Schema(description = "取样单位")
    @ExcelProperty("取样单位")
    private String sampleUnit;

    @Schema(description = "取样日期")
    @ExcelProperty("取样日期")
    private LocalDate sampleDate;

    @Schema(description = "取样人")
    @ExcelProperty("取样人")
    private Long samplerId;

    @Schema(description = "取样方法")
    @ExcelProperty("取样方法")
    private String sampleMethod;

    @Schema(description = "取样地点")
    @ExcelProperty("取样地点")
    private String sampleLocation;

    @Schema(description = "检验机构(内部/委托)")
    @ExcelProperty("检验机构(内部/委托)")
    private String inspectOrg;

    @Schema(description = "计划完成日期")
    @ExcelProperty("计划完成日期")
    private LocalDate plannedCompleteDate;

    @Schema(description = "实际完成日期")
    @ExcelProperty("实际完成日期")
    private LocalDate actualCompleteDate;

    @Schema(description = "检验人")
    @ExcelProperty("检验人")
    private Long inspectorId;

    @Schema(description = "状态(0待取样 1已取样 2检验中 3已完成 4不合格)")
    @ExcelProperty("状态(0待取样 1已取样 2检验中 3已完成 4不合格)")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
