package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 关键数据复核记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapDataReviewPageReqVO extends PageParam {

    @Schema(description = "表名", example = "gap_base_info")
    private String tableName;

    @Schema(description = "记录编号", example = "1")
    private Long recordId;

    @Schema(description = "复核类型(0录入复核 1定期复核 2专项复核)", example = "0")
    private Integer reviewType;

    @Schema(description = "复核结果(0合格 1不合格)", example = "0")
    private Integer reviewResult;

    @Schema(description = "复核人", example = "1")
    private Long reviewerId;

    @Schema(description = "状态(0待复核 1已复核 2已纠正)", example = "0")
    private Integer status;

    @Schema(description = "复核时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] reviewTime;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
