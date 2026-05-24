package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 加工记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapProcessRecordPageReqVO extends PageParam {

    @Schema(description = "记录单号", example = "PR-20240101-001")
    private String recordNo;

    @Schema(description = "采收记录编号", example = "1")
    private Long harvestRecordId;

    @Schema(description = "加工批次号", example = "BATCH-001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "状态(0加工中 1已完成 2检验中)", example = "0")
    private Integer status;

    @Schema(description = "加工日期开始")
    private LocalDate processDateStart;

    @Schema(description = "加工日期结束")
    private LocalDate processDateEnd;

}
