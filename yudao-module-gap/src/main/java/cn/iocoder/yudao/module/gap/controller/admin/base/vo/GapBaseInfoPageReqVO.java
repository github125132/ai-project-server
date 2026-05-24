package cn.iocoder.yudao.module.gap.controller.admin.base.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 基地信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapBaseInfoPageReqVO extends PageParam {

    @Schema(description = "基地编码", example = "BASE-001")
    private String code;

    @Schema(description = "基地名称", example = "云南")
    private String name;

    @Schema(description = "状态(0正常 1停用)", example = "0")
    private Integer status;

    @Schema(description = "省份", example = "云南省")
    private String province;

    @Schema(description = "城市", example = "文山")
    private String city;

}
