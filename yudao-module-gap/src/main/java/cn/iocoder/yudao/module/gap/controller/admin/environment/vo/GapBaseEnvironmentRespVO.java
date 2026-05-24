package cn.iocoder.yudao.module.gap.controller.admin.environment.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP BaseEnvironment Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseEnvironmentRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private LocalDate assessDate;

    @Schema(description = "")
    @ExcelProperty("")
    private String assessOrg;

    @Schema(description = "")
    @ExcelProperty("")
    private String assessPerson;

    @Schema(description = "")
    @ExcelProperty("")
    private String surroundings;

    @Schema(description = "")
    @ExcelProperty("")
    private String pollutionSource;

    @Schema(description = "")
    @ExcelProperty("")
    private String airQuality;

    @Schema(description = "")
    @ExcelProperty("")
    private String noiseLevel;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer assessResult;

    @Schema(description = "")
    @ExcelProperty("")
    private String reportUrl;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer status;

    @Schema(description = "")
    @ExcelProperty("")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
