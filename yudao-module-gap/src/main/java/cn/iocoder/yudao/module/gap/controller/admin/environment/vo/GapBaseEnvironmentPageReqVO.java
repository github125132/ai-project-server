package cn.iocoder.yudao.module.gap.controller.admin.environment.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP BaseEnvironment分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapBaseEnvironmentPageReqVO extends PageParam {

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

}
