package cn.iocoder.yudao.module.gap.controller.admin.farming.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 病虫害防治方案分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPestControlPageReqVO extends PageParam {

    @Schema(description = "方案编号", example = "PC-2024-001")
    private String planNo;

    @Schema(description = "品种编号", example = "1")
    private Long varietyId;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "病虫害名称", example = "根腐病")
    private String pestName;

    @Schema(description = "类型(0病害 1虫害 2草害 3鼠害)", example = "0")
    private Integer pestType;

    @Schema(description = "状态(0草稿 1已审批 2执行中 3已完成)", example = "0")
    private Integer status;

}
