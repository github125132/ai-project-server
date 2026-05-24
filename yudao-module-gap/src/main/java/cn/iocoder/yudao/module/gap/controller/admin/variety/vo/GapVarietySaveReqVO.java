package cn.iocoder.yudao.module.gap.controller.admin.variety.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - GAP 品种档案新增/修改 Request VO")
@Data
public class GapVarietySaveReqVO {

    @Schema(description = "品种编号", example = "1024")
    private Long id;

    @Schema(description = "品种编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "VAR-001")
    @NotEmpty(message = "品种编码不能为空")
    private String code;

    @Schema(description = "品种名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "三七")
    @NotEmpty(message = "品种名称不能为空")
    private String name;

    @Schema(description = "拉丁学名", example = "Panax notoginseng")
    private String latinName;

    @Schema(description = "科", example = "五加科")
    private String family;

    @Schema(description = "属", example = "人参属")
    private String genus;

    @Schema(description = "种", example = "三七")
    private String species;

    @Schema(description = "品种", example = "春七")
    private String varietyName;

    @Schema(description = "药用部位", example = "根及根茎")
    private String medicinalPart;

    @Schema(description = "道地产区", example = "云南文山")
    private String originArea;

    @Schema(description = "生长周期(月)", example = "36")
    private Integer growthCycle;

    @Schema(description = "适宜气候", example = "亚热带季风气候")
    private String suitableClimate;

    @Schema(description = "适宜土壤", example = "红壤、黄壤")
    private String suitableSoil;

    @Schema(description = "亩产(kg)", example = "150.00")
    private BigDecimal yieldPerMu;

    @Schema(description = "质量标准编号", example = "1")
    private Long qualityStandardId;

    @Schema(description = "状态(0正常 1停用)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
