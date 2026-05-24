package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 业务操作日志分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapOperationLogPageReqVO extends PageParam {

    @Schema(description = "日志类型(0新增 1修改 2删除 3查询 4导入 5导出 6审批)", example = "0")
    private Integer logType;

    @Schema(description = "业务模块", example = "base-info")
    private String moduleType;

    @Schema(description = "表名", example = "gap_base_info")
    private String tableName;

    @Schema(description = "记录编号", example = "1")
    private Long recordId;

    @Schema(description = "操作人", example = "1")
    private Long operatorId;

    @Schema(description = "结果(0成功 1失败)", example = "0")
    private Integer result;

    @Schema(description = "操作时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] operateTime;

}
