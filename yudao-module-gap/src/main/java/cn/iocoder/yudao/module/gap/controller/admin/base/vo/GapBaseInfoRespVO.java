package cn.iocoder.yudao.module.gap.controller.admin.base.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 基地信息 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseInfoRespVO {

    @Schema(description = "基地编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("基地编号")
    private Long id;

    @Schema(description = "基地编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "BASE-001")
    @ExcelProperty("基地编码")
    private String code;

    @Schema(description = "基地名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "云南文山三七基地")
    @ExcelProperty("基地名称")
    private String name;

    @Schema(description = "省份")
    @ExcelProperty("省份")
    private String province;

    @Schema(description = "城市")
    @ExcelProperty("城市")
    private String city;

    @Schema(description = "区县")
    @ExcelProperty("区县")
    private String district;

    @Schema(description = "详细地址")
    @ExcelProperty("详细地址")
    private String address;

    @Schema(description = "经度")
    @ExcelProperty("经度")
    private BigDecimal longitude;

    @Schema(description = "纬度")
    @ExcelProperty("纬度")
    private BigDecimal latitude;

    @Schema(description = "总面积(亩)")
    @ExcelProperty("总面积(亩)")
    private BigDecimal area;

    @Schema(description = "种植面积(亩)")
    @ExcelProperty("种植面积(亩)")
    private BigDecimal plantingArea;

    @Schema(description = "海拔(m)")
    @ExcelProperty("海拔(m)")
    private BigDecimal altitude;

    @Schema(description = "状态(0正常 1停用)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "环境评估状态")
    @ExcelProperty("环境评估状态")
    private Integer envAssessStatus;

    @Schema(description = "环境评估日期")
    @ExcelProperty("环境评估日期")
    private LocalDate envAssessDate;

    @Schema(description = "环境评估报告附件")
    @ExcelProperty("环境评估报告附件")
    private String envAssessReportUrl;

    @Schema(description = "基地负责人")
    @ExcelProperty("基地负责人")
    private Long responsibleUserId;

    @Schema(description = "生产负责人")
    @ExcelProperty("生产负责人")
    private Long managerUserId;

    @Schema(description = "质量负责人")
    @ExcelProperty("质量负责人")
    private Long qualityUserId;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
