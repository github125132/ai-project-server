package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 病虫害防治方案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapPestControlRespVO {

    @Schema(description = "方案编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("方案编号")
    private Long id;

    @Schema(description = "方案编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("方案编号")
    private String planNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "病虫害名称")
    @ExcelProperty("病虫害名称")
    private String pestName;

    @Schema(description = "类型(0病害 1虫害 2草害 3鼠害)")
    @ExcelProperty("类型")
    private Integer pestType;

    @Schema(description = "防治原则")
    @ExcelProperty("防治原则")
    private String controlPrinciple;

    @Schema(description = "农业防治措施")
    @ExcelProperty("农业防治措施")
    private String agriculturalMethod;

    @Schema(description = "物理防治措施")
    @ExcelProperty("物理防治措施")
    private String physicalMethod;

    @Schema(description = "生物防治措施")
    @ExcelProperty("生物防治措施")
    private String biologicalMethod;

    @Schema(description = "化学防治措施")
    @ExcelProperty("化学防治措施")
    private String chemicalMethod;

    @Schema(description = "批准使用农药编号列表")
    @ExcelProperty("批准使用农药编号列表")
    private String approvedPesticideIds;

    @Schema(description = "预防时期")
    @ExcelProperty("预防时期")
    private String preventionPeriod;

    @Schema(description = "预警阈值")
    @ExcelProperty("预警阈值")
    private String warningThreshold;

    @Schema(description = "状态(0草稿 1已审批 2执行中 3已完成)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
