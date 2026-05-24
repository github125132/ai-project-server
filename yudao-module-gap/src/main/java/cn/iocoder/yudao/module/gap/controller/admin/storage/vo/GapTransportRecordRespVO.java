package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 运输记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTransportRecordRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "运输单号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("运输单号")
    private String transportNo;

    @Schema(description = "药材批次号")
    @ExcelProperty("药材批次号")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "出库记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("出库记录编号")
    private Long outRecordId;

    @Schema(description = "车辆编号/车牌号")
    @ExcelProperty("车辆编号/车牌号")
    private String vehicleNo;

    @Schema(description = "司机姓名")
    @ExcelProperty("司机姓名")
    private String driverName;

    @Schema(description = "司机电话")
    @ExcelProperty("司机电话")
    private String driverPhone;

    @Schema(description = "运输开始时间")
    @ExcelProperty("运输开始时间")
    private LocalDateTime transportStartTime;

    @Schema(description = "运输结束时间")
    @ExcelProperty("运输结束时间")
    private LocalDateTime transportEndTime;

    @Schema(description = "起运地")
    @ExcelProperty("起运地")
    private String fromLocation;

    @Schema(description = "目的地")
    @ExcelProperty("目的地")
    private String toLocation;

    @Schema(description = "运输数量(kg)")
    @ExcelProperty("运输数量(kg)")
    private BigDecimal quantity;

    @Schema(description = "件数")
    @ExcelProperty("件数")
    private Integer packageCount;

    @Schema(description = "车辆清洁检查")
    @ExcelProperty("车辆清洁检查")
    private Boolean vehicleCleanCheck;

    @Schema(description = "防雨措施")
    @ExcelProperty("防雨措施")
    private Boolean weatherProtection;

    @Schema(description = "封签号")
    @ExcelProperty("封签号")
    private String sealNo;

    @Schema(description = "温湿度监控记录")
    @ExcelProperty("温湿度监控记录")
    private String tempMonitorUrl;

    @Schema(description = "收货人")
    @ExcelProperty("收货人")
    private String receiverName;

    @Schema(description = "签收单附件")
    @ExcelProperty("签收单附件")
    private String receiverSignUrl;

    @Schema(description = "状态(0待运输 1运输中 2已送达 3异常)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
