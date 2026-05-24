package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 药材出库记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapStorageOutRecordPageReqVO extends PageParam {

    @Schema(description = "出库单号", example = "OUT-20240101-001")
    private String recordNo;

    @Schema(description = "药材批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "仓库编号", example = "1")
    private Long warehouseId;

    @Schema(description = "分区编号", example = "1")
    private Long areaId;

    @Schema(description = "出库类型(0销售 1调拨 2取样 3退货 4销毁)", example = "0")
    private Integer outType;

    @Schema(description = "状态(0待出库 1已出库)", example = "0")
    private Integer status;

    @Schema(description = "出库日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] outDate;

}
