package cn.iocoder.yudao.module.gap.controller.admin.origin.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 基源鉴定分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapOriginIdentifyPageReqVO extends PageParam {

    @Schema(description = "鉴定报告编号", example = "ID-2024-001")
    private String identifyNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "种子批次编号", example = "1")
    private Long seedBatchId;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
