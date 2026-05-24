package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP PesticideResidue分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapPesticideResiduePageReqVO extends PageParam {

    @Schema(description = "检验任务编号")
    private Long taskId;

    @Schema(description = "检验报告编号")
    private Long reportId;

    @Schema(description = "批次号")
    private String batchNo;

    @Schema(description = "农药名称")
    private String pesticideName;

    @Schema(description = "农药类别(有机氯/有机磷/氨基甲酸酯等)")
    private String pesticideCategory;

    @Schema(description = "是否禁用农药")
    private Boolean isBanned;

    @Schema(description = "检出值(mg/kg)")
    private BigDecimal detectedValue;

    @Schema(description = "限量值(mg/kg)")
    private BigDecimal limitValue;

    @Schema(description = "单位")
    private String unit;

    @Schema(description = "检测限")
    private BigDecimal detectionLimit;

    @Schema(description = "结论(0合格 1不合格 2未检出)")
    private Integer conclusion;

    @Schema(description = "状态")
    private Integer status;

}
