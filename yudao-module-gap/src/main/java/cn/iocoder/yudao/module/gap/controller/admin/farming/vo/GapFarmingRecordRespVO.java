package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 农事记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapFarmingRecordRespVO {

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("记录编号")
    private Long id;

    @Schema(description = "记录单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "农事类型(0整地 1播种 2育苗 3移栽 4中耕 5除草 6灌溉 7施肥 8整枝 9覆盖 10病虫害防治 11采收)")
    @ExcelProperty("农事类型")
    private Integer recordType;

    @Schema(description = "基地编号")
    @ExcelProperty("基地编号")
    private Long baseId;

    @Schema(description = "地块编号")
    @ExcelProperty("地块编号")
    private Long plotId;

    @Schema(description = "地块种植批次")
    @ExcelProperty("地块种植批次")
    private String plotBatchNo;

    @Schema(description = "品种编号")
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "操作日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("操作日期")
    private LocalDate operateDate;

    @Schema(description = "天气情况")
    @ExcelProperty("天气情况")
    private String weather;

    @Schema(description = "气温")
    @ExcelProperty("气温")
    private BigDecimal temperature;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "监督人")
    @ExcelProperty("监督人")
    private Long supervisorId;

    @Schema(description = "工时(h)")
    @ExcelProperty("工时(h)")
    private BigDecimal workHours;

    @Schema(description = "用工人数")
    @ExcelProperty("用工人数")
    private Integer workersCount;

    @Schema(description = "作业面积(亩)")
    @ExcelProperty("作业面积(亩)")
    private BigDecimal workArea;

    @Schema(description = "是否核对气象")
    @ExcelProperty("是否核对气象")
    private Boolean isWeatherChecked;

    @Schema(description = "现场照片")
    @ExcelProperty("现场照片")
    private String photoUrl;

    @Schema(description = "状态(0草稿 1已提交 2已审核)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "审核人")
    @ExcelProperty("审核人")
    private Long auditUserId;

    @Schema(description = "审核时间")
    @ExcelProperty("审核时间")
    private LocalDateTime auditTime;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
