package cn.iocoder.yudao.module.gap.controller.admin.inspect.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - GAP SampleRecord新增/修改 Request VO")
@Data
public class GapSampleRecordSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "留样编号")
    private String sampleNo;

    @Schema(description = "批次号")
    private String batchNo;

    @Schema(description = "品种编号")
    private Long varietyId;

    @Schema(description = "关联检验任务")
    private Long inspectTaskId;

    @Schema(description = "留样量(kg)")
    private BigDecimal sampleQuantity;

    @Schema(description = "取样日期")
    private LocalDate sampleDate;

    @Schema(description = "留样位置")
    private String storageLocation;

    @Schema(description = "留样条件")
    private String storageCondition;

    @Schema(description = "留样有效期")
    private LocalDate expiryDate;

    @Schema(description = "销毁日期")
    private LocalDate destroyDate;

    @Schema(description = "销毁方式")
    private String destroyMethod;

    @Schema(description = "销毁人")
    private Long destroyerId;

    @Schema(description = "见证人")
    private Long witnessId;

    @Schema(description = "状态(0留样中 1已到期 2已销毁)")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
