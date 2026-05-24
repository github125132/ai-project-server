package cn.iocoder.yudao.module.gap.controller.admin.training.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 人员健康档案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapPersonHealthRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "人员编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("人员编号")
    private Long userId;

    @Schema(description = "体检日期", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("体检日期")
    private LocalDate checkDate;

    @Schema(description = "体检机构")
    @ExcelProperty("体检机构")
    private String checkOrg;

    @Schema(description = "检查项目")
    @ExcelProperty("检查项目")
    private String checkItem;

    @Schema(description = "检查结果")
    @ExcelProperty("检查结果")
    private String checkResult;

    @Schema(description = "是否传染病")
    @ExcelProperty("是否传染病")
    private Boolean isContagious;

    @Schema(description = "是否皮肤病")
    @ExcelProperty("是否皮肤病")
    private Boolean isSkinDisease;

    @Schema(description = "是否合格")
    @ExcelProperty("是否合格")
    private Boolean isQualified;

    @Schema(description = "健康证号")
    @ExcelProperty("健康证号")
    private String healthCertNo;

    @Schema(description = "健康证附件")
    @ExcelProperty("健康证附件")
    private String healthCertUrl;

    @Schema(description = "有效期至")
    @ExcelProperty("有效期至")
    private LocalDate validityDate;

    @Schema(description = "下次体检日期")
    @ExcelProperty("下次体检日期")
    private LocalDate nextCheckDate;

    @Schema(description = "是否已发送到期预警")
    @ExcelProperty("是否已发送到期预警")
    private Boolean warningSent;

    @Schema(description = "状态(0有效 1即将过期 2已过期)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
