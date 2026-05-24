package cn.iocoder.yudao.module.gap.controller.admin.facility.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP BaseFacility Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseFacilityRespVO {

    @Schema(description = "")
    @ExcelProperty("")
    private Long id;

    @Schema(description = "")
    @ExcelProperty("")
    private Long baseId;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer facilityType;

    @Schema(description = "")
    @ExcelProperty("")
    private String name;

    @Schema(description = "")
    @ExcelProperty("")
    private String code;

    @Schema(description = "")
    @ExcelProperty("")
    private String specification;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer quantity;

    @Schema(description = "")
    @ExcelProperty("")
    private String unit;

    @Schema(description = "")
    @ExcelProperty("")
    private LocalDate buildDate;

    @Schema(description = "")
    @ExcelProperty("")
    private Integer status;

    @Schema(description = "")
    @ExcelProperty("")
    private String locationDesc;

    @Schema(description = "")
    @ExcelProperty("")
    private String photoUrl;

    @Schema(description = "")
    @ExcelProperty("")
    private String remark;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
