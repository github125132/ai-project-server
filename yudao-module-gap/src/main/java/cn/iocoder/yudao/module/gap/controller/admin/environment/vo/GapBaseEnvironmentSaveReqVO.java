package cn.iocoder.yudao.module.gap.controller.admin.environment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP BaseEnvironment新增/修改 Request VO")
@Data
public class GapBaseEnvironmentSaveReqVO {

    @Schema(description = "", example = "1024")
    private Long id;

    @Schema(description = "")
    private Long baseId;

    @Schema(description = "")
    private LocalDate assessDate;

    @Schema(description = "")
    private String assessOrg;

    @Schema(description = "")
    private String assessPerson;

    @Schema(description = "")
    private String surroundings;

    @Schema(description = "")
    private String pollutionSource;

    @Schema(description = "")
    private String airQuality;

    @Schema(description = "")
    private String noiseLevel;

    @Schema(description = "")
    private Integer assessResult;

    @Schema(description = "")
    private String reportUrl;

    @Schema(description = "")
    private Integer status;

    @Schema(description = "")
    private String remark;

}
