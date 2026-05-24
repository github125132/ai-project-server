package cn.iocoder.yudao.module.gap.controller.admin.seed.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 种子种苗批次分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapSeedBatchPageReqVO extends PageParam {

    @Schema(description = "批次号", example = "SB-2024-001")
    private String batchNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "类型(0种子 1种苗)", example = "0")
    private Integer seedType;

    @Schema(description = "来源(0自繁 1外购 2野生采集)", example = "1")
    private Integer sourceType;

    @Schema(description = "状态(0待验 1合格 2不合格 3已使用)", example = "0")
    private Integer status;

}
