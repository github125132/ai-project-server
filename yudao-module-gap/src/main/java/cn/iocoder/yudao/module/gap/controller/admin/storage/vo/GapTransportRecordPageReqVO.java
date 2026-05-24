package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 运输记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTransportRecordPageReqVO extends PageParam {

    @Schema(description = "运输单号", example = "TR-20240101-001")
    private String transportNo;

    @Schema(description = "药材批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "出库记录编号", example = "1")
    private Long outRecordId;

    @Schema(description = "车辆编号/车牌号", example = "京A12345")
    private String vehicleNo;

    @Schema(description = "状态(0待运输 1运输中 2已送达 3异常)", example = "0")
    private Integer status;

    @Schema(description = "运输开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] transportStartTime;

}
