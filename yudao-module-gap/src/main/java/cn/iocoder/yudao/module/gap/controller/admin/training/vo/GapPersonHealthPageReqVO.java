package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 人员健康档案分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPersonHealthPageReqVO extends PageParam {

    @Schema(description = "人员编号", example = "1")
    private Long userId;

    @Schema(description = "状态(0有效 1即将过期 2已过期)", example = "0")
    private Integer status;

    @Schema(description = "是否合格", example = "true")
    private Boolean isQualified;

    @Schema(description = "体检日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] checkDate;

    @Schema(description = "有效期至")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] validityDate;

}
