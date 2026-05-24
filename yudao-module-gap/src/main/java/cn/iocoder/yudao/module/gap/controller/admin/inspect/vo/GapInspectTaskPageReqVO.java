package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP InspectTask分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapInspectTaskPageReqVO extends PageParam {

    @Schema(description = "任务单号")
    private String taskNo;

    @Schema(description = "任务类型(0原料检验 1过程检验 2成品检验 3农残检测 4重金属检测 5委托检验)")
    private Integer taskType;

    @Schema(description = "来源类型(0采收 1加工 2入库 3在库 4出库)")
    private Integer sourceType;

    @Schema(description = "来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    private Long varietyId;

    @Schema(description = "质量标准编号")
    private Long standardId;

    @Schema(description = "取样量")
    private BigDecimal sampleQuantity;

    @Schema(description = "取样单位")
    private String sampleUnit;

    @Schema(description = "取样日期")
    private LocalDate sampleDate;

    @Schema(description = "取样人")
    private Long samplerId;

    @Schema(description = "取样方法")
    private String sampleMethod;

    @Schema(description = "取样地点")
    private String sampleLocation;

    @Schema(description = "检验机构(内部/委托)")
    private String inspectOrg;

    @Schema(description = "计划完成日期")
    private LocalDate plannedCompleteDate;

    @Schema(description = "实际完成日期")
    private LocalDate actualCompleteDate;

    @Schema(description = "检验人")
    private Long inspectorId;

    @Schema(description = "状态(0待取样 1已取样 2检验中 3已完成 4不合格)")
    private Integer status;

}
