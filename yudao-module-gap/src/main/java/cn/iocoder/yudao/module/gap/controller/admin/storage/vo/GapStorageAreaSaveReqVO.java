package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Schema(description = "管理后台 - GAP 仓库分区新增/修改 Request VO")
@Data
public class GapStorageAreaSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "关联WMS仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "仓库编号不能为空")
    private Long warehouseId;

    @Schema(description = "分区编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "AREA-001")
    @NotEmpty(message = "分区编码不能为空")
    private String code;

    @Schema(description = "分区名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "待验区A")
    @NotEmpty(message = "分区名称不能为空")
    private String name;

    @Schema(description = "区域类型(0待验区 1合格区 2不合格区 3退货区 4发货区)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "区域类型不能为空")
    private Integer areaType;

    @Schema(description = "面积(m²)", example = "100.00")
    private BigDecimal area;

    @Schema(description = "位置描述")
    private String locationDesc;

    @Schema(description = "容量(kg)", example = "5000.0000")
    private BigDecimal capacity;

    @Schema(description = "状态(0正常 1停用)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "状态不能为空")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
