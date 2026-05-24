package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 数据变更日志分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapDataChangeLogPageReqVO extends PageParam {

    @Schema(description = "表名", example = "gap_base_info")
    private String tableName;

    @Schema(description = "记录编号", example = "1")
    private Long recordId;

    @Schema(description = "变更类型(0新增 1修改 2删除)", example = "0")
    private Integer changeType;

    @Schema(description = "字段名", example = "name")
    private String fieldName;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "操作时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] operateTime;

}
