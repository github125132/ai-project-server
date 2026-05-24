package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 投入品使用记录分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapInputUseRecordPageReqVO extends PageParam {

    @Schema(description = "使用单号", example = "USE-20240101-001")
    private String recordNo;

    @Schema(description = "产品编号", example = "1")
    private Long productId;

    @Schema(description = "使用类型(0农药 1肥料 2其他)", example = "0")
    private Integer useType;

    @Schema(description = "基地编号", example = "1")
    private Long baseId;

    @Schema(description = "地块编号", example = "1")
    private Long plotId;

    @Schema(description = "地块种植批次", example = "PLANT-20240101-001")
    private String plotBatchNo;

    @Schema(description = "操作人员", example = "1")
    private Long operatorId;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
