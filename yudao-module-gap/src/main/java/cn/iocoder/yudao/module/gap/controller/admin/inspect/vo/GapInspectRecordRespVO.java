package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP InspectRecord Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapInspectRecordRespVO {

    @Schema(description = "记录编号")
    @ExcelProperty("记录编号")
    private Long id;

    @Schema(description = "检验单号")
    @ExcelProperty("检验单号")
    private String recordNo;

    @Schema(description = "检验任务编号")
    @ExcelProperty("检验任务编号")
    private Long taskId;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "质量标准编号")
    @ExcelProperty("质量标准编号")
    private Long standardId;

    @Schema(description = "检验类型(0性状 1鉴别 2检查 3含量测定 4农残 5重金属)")
    @ExcelProperty("检验类型(0性状 1鉴别 2检查 3含量测定 4农残 5重金属)")
    private Integer inspectType;

    @Schema(description = "检验日期")
    @ExcelProperty("检验日期")
    private LocalDate inspectDate;

    @Schema(description = "检验方法")
    @ExcelProperty("检验方法")
    private String inspectMethod;

    @Schema(description = "检验仪器")
    @ExcelProperty("检验仪器")
    private String instrument;

    @Schema(description = "检验结果值")
    @ExcelProperty("检验结果值")
    private String resultValue;

    @Schema(description = "标准值")
    @ExcelProperty("标准值")
    private String standardValue;

    @Schema(description = "单位")
    @ExcelProperty("单位")
    private String unit;

    @Schema(description = "单项结论(0合格 1不合格 2未检)")
    @ExcelProperty("单项结论(0合格 1不合格 2未检)")
    private Integer conclusion;

    @Schema(description = "检验人")
    @ExcelProperty("检验人")
    private Long inspectorId;

    @Schema(description = "复核人")
    @ExcelProperty("复核人")
    private Long reviewerId;

    @Schema(description = "原始记录附件")
    @ExcelProperty("原始记录附件")
    private String originalRecordUrl;

    @Schema(description = "检验照片")
    @ExcelProperty("检验照片")
    private String photoUrl;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
