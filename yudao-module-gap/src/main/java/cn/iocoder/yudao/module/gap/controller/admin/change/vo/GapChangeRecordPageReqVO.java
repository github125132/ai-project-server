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

@Schema(description = "管理后台 - GAP 变更记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapChangeRecordPageReqVO extends PageParam {

    @Schema(description = "变更类型(0基地 1品种 2工艺 3设备 4人员 5SOP 6供应商)", example = "0")
    private Integer changeType;

    @Schema(description = "变更单号", example = "CHG-2024001")
    private String changeNo;

    @Schema(description = "变更标题", example = "基地土壤改良")
    private String changeTitle;

    @Schema(description = "状态(0待评估 1评估中 2待审批 3已批准 4已实施 5已验证 6已关闭)", example = "0")
    private Integer status;

    @Schema(description = "提出人", example = "1")
    private Long proposerId;

    @Schema(description = "提出日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] proposeDate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
