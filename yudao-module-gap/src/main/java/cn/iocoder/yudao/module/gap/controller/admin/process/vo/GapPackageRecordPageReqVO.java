package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Schema(description = "管理后台 - GAP 包装记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPackageRecordPageReqVO extends PageParam {

    @Schema(description = "加工记录编号", example = "1")
    private Long processRecordId;

    @Schema(description = "记录单号", example = "PK-20240101-001")
    private String recordNo;

    @Schema(description = "批次号", example = "BATCH-001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "包装日期开始")
    private LocalDate packageDateStart;

    @Schema(description = "包装日期结束")
    private LocalDate packageDateEnd;

}
