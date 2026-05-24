package cn.iocoder.yudao.module.gap.controller.admin.change.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 投诉记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapComplaintPageReqVO extends PageParam {

    @Schema(description = "投诉类型(0质量 1包装 2运输 3其他)", example = "0")
    private Integer complaintType;

    @Schema(description = "投诉编号", example = "CMP-2024001")
    private String complaintNo;

    @Schema(description = "投诉人", example = "张三")
    private String complainant;

    @Schema(description = "状态(0待处理 1处理中 2已回复 3已关闭)", example = "0")
    private Integer status;

    @Schema(description = "涉及批次号", example = "BATCH-2024001")
    private String batchNo;

    @Schema(description = "涉及品种", example = "1")
    private Long varietyId;

    @Schema(description = "投诉日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] complaintDate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
