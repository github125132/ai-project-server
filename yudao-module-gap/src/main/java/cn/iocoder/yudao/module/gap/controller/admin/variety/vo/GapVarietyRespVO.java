package cn.iocoder.yudao.module.gap.controller.admin.variety.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 品种档案 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapVarietyRespVO {

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("品种编号")
    private Long id;

    @Schema(description = "品种编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "VAR-001")
    @ExcelProperty("品种编码")
    private String code;

    @Schema(description = "品种名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "三七")
    @ExcelProperty("品种名称")
    private String name;

    @Schema(description = "拉丁学名")
    @ExcelProperty("拉丁学名")
    private String latinName;

    @Schema(description = "科")
    @ExcelProperty("科")
    private String family;

    @Schema(description = "属")
    @ExcelProperty("属")
    private String genus;

    @Schema(description = "种")
    @ExcelProperty("种")
    private String species;

    @Schema(description = "品种")
    @ExcelProperty("品种")
    private String varietyName;

    @Schema(description = "药用部位")
    @ExcelProperty("药用部位")
    private String medicinalPart;

    @Schema(description = "道地产区")
    @ExcelProperty("道地产区")
    private String originArea;

    @Schema(description = "生长周期(月)")
    @ExcelProperty("生长周期(月)")
    private Integer growthCycle;

    @Schema(description = "适宜气候")
    @ExcelProperty("适宜气候")
    private String suitableClimate;

    @Schema(description = "适宜土壤")
    @ExcelProperty("适宜土壤")
    private String suitableSoil;

    @Schema(description = "亩产(kg)")
    @ExcelProperty("亩产(kg)")
    private BigDecimal yieldPerMu;

    @Schema(description = "质量标准编号")
    @ExcelProperty("质量标准编号")
    private Long qualityStandardId;

    @Schema(description = "状态(0正常 1停用)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
