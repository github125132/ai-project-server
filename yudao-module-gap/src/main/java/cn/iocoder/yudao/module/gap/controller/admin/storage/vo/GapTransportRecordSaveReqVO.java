package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 运输记录新增/修改 Request VO")
@Data
public class GapTransportRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "运输单号", requiredMode = Schema.RequiredMode.REQUIRED, example = "TR-20240101-001")
    @NotEmpty(message = "运输单号不能为空")
    private String transportNo;

    @Schema(description = "药材批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "品种编号不能为空")
    private Long varietyId;

    @Schema(description = "出库记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "出库记录编号不能为空")
    private Long outRecordId;

    @Schema(description = "车辆编号/车牌号", example = "京A12345")
    private String vehicleNo;

    @Schema(description = "司机姓名", example = "张三")
    private String driverName;

    @Schema(description = "司机电话", example = "13800138000")
    private String driverPhone;

    @Schema(description = "运输开始时间")
    private LocalDateTime transportStartTime;

    @Schema(description = "运输结束时间")
    private LocalDateTime transportEndTime;

    @Schema(description = "起运地")
    private String fromLocation;

    @Schema(description = "目的地")
    private String toLocation;

    @Schema(description = "运输数量(kg)", example = "100.0000")
    private BigDecimal quantity;

    @Schema(description = "件数", example = "10")
    private Integer packageCount;

    @Schema(description = "车辆清洁检查", example = "true")
    private Boolean vehicleCleanCheck;

    @Schema(description = "防雨措施", example = "true")
    private Boolean weatherProtection;

    @Schema(description = "封签号", example = "SEAL-001")
    private String sealNo;

    @Schema(description = "温湿度监控记录")
    private String tempMonitorUrl;

    @Schema(description = "收货人", example = "李四")
    private String receiverName;

    @Schema(description = "签收单附件")
    private String receiverSignUrl;

    @Schema(description = "状态(0待运输 1运输中 2已送达 3异常)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
