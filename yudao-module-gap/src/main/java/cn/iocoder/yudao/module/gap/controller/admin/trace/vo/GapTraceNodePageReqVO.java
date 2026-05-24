package cn.iocoder.yudao.module.gap.controller.admin.trace.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - GAP 溯源节点分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapTraceNodePageReqVO extends PageParam {

    @Schema(description = "溯源批次编号", example = "1")
    private Long traceBatchId;

    @Schema(description = "追溯码", example = "TRACE-2024001")
    private String traceCode;

    @Schema(description = "节点类型(0种植 1农事 2采收 3加工 4包装 5入库 6检验 7放行 8出库 9运输)", example = "0")
    private Integer nodeType;

    @Schema(description = "节点名称", example = "播种")
    private String nodeName;

    @Schema(description = "节点时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] nodeTime;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
