package cn.iocoder.yudao.module.gap.controller.admin.variety.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 品种档案分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapVarietyPageReqVO extends PageParam {

    @Schema(description = "品种编码", example = "VAR-001")
    private String code;

    @Schema(description = "品种名称", example = "三七")
    private String name;

    @Schema(description = "状态(0正常 1停用)", example = "0")
    private Integer status;

    @Schema(description = "科", example = "五加科")
    private String family;

    @Schema(description = "药用部位", example = "根及根茎")
    private String medicinalPart;

}
