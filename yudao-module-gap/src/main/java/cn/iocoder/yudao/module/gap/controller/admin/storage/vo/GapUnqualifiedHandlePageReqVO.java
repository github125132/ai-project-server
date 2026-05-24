package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 不合格品处理分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapUnqualifiedHandlePageReqVO extends PageParam {

    @Schema(description = "处理单号", example = "UQ-20240101-001")
    private String recordNo;

    @Schema(description = "来源类型(0采收 1加工 2检验 3仓储)", example = "0")
    private Integer sourceType;

    @Schema(description = "批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "处理方式(0返工 1降级 2销毁 3退货)", example = "0")
    private Integer handleMethod;

    @Schema(description = "状态(0待处理 1处理中 2已处理)", example = "0")
    private Integer status;

    @Schema(description = "处理日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] handleDate;

}
