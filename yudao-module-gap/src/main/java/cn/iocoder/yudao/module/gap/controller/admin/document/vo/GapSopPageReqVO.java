package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP SOP分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapSopPageReqVO extends PageParam {

    @Schema(description = "SOP编号", example = "SOP-001")
    private String sopNo;

    @Schema(description = "SOP名称", example = "种植")
    private String name;

    @Schema(description = "类别(0种植 1采收 2加工 3仓储 4检验 5设备 6卫生)", example = "0")
    private Integer category;

    @Schema(description = "状态(0草稿 1已批准 2已废止)", example = "0")
    private Integer status;

    @Schema(description = "批准人", example = "1")
    private Long approverId;

}
