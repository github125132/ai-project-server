package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY;

@Schema(description = "管理后台 - GAP 养护检查记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapStorageCheckPageReqVO extends PageParam {

    @Schema(description = "检查单号", example = "CHK-20240101-001")
    private String recordNo;

    @Schema(description = "仓库编号", example = "1")
    private Long warehouseId;

    @Schema(description = "分区编号", example = "1")
    private Long areaId;

    @Schema(description = "检查类型(0日常巡检 1定期养护 2特殊检查)", example = "0")
    private Integer checkType;

    @Schema(description = "状态(0正常 1有异常已处理 2有异常待处理)", example = "0")
    private Integer status;

    @Schema(description = "检查日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY)
    private LocalDate[] checkDate;

}
