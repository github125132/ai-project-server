package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 干燥记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapDryingRecordPageReqVO extends PageParam {

    @Schema(description = "加工记录编号", example = "1")
    private Long processRecordId;

    @Schema(description = "批次号", example = "BATCH-001")
    private String batchNo;

    @Schema(description = "干燥方式(0晒干 1阴干 2烘干 3风干)", example = "0")
    private Integer dryingMethod;

    @Schema(description = "状态(0干燥中 1已完成 2不合格)", example = "0")
    private Integer status;

}
