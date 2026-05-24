package cn.iocoder.yudao.module.gap.controller.admin.facility.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP BaseFacility分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapBaseFacilityPageReqVO extends PageParam {

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private Integer facilityType;

    @Schema(description = "")
    private String name;

    @Schema(description = "")
    private String code;

    @Schema(description = "")
    private String specification;

    @Schema(description = "")
    private Integer quantity;

    @Schema(description = "")
    private String unit;

    @Schema(description = "")
    private LocalDate buildDate;

    @Schema(description = "")
    private Integer status;

    @Schema(description = "")
    private String locationDesc;

    @Schema(description = "")
    private String photoUrl;

}
