package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 投入品库存分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapInputInventoryPageReqVO extends PageParam {

    @Schema(description = "产品编号", example = "1")
    private Long productId;

    @Schema(description = "批次号", example = "BATCH-20240101-001")
    private String batchNo;

    @Schema(description = "供应商编号", example = "1")
    private Long supplierId;

    @Schema(description = "状态(0正常 1近效期 2过期 3用完)", example = "0")
    private Integer status;

}
