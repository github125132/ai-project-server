package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 仓库分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapStorageAreaPageReqVO extends PageParam {

    @Schema(description = "关联WMS仓库编号", example = "1")
    private Long warehouseId;

    @Schema(description = "分区编码", example = "AREA-001")
    private String code;

    @Schema(description = "分区名称", example = "待验区A")
    private String name;

    @Schema(description = "区域类型(0待验区 1合格区 2不合格区 3退货区 4发货区)", example = "0")
    private Integer areaType;

    @Schema(description = "状态(0正常 1停用)", example = "0")
    private Integer status;

}
