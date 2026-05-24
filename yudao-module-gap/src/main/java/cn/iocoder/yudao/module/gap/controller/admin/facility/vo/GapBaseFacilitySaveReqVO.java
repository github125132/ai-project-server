package cn.iocoder.yudao.module.gap.controller.admin.facility.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP BaseFacility新增/修改 Request VO")
@Data
public class GapBaseFacilitySaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

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

    @Schema(description = "")
    private String remark;

}
