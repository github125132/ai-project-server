package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 仓库分区 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapStorageAreaRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "关联WMS仓库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("仓库编号")
    private Long warehouseId;

    @Schema(description = "分区编码", requiredMode = Schema.RequiredMode.REQUIRED, example = "AREA-001")
    @ExcelProperty("分区编码")
    private String code;

    @Schema(description = "分区名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "待验区A")
    @ExcelProperty("分区名称")
    private String name;

    @Schema(description = "区域类型(0待验区 1合格区 2不合格区 3退货区 4发货区)")
    @ExcelProperty("区域类型")
    private Integer areaType;

    @Schema(description = "面积(m²)")
    @ExcelProperty("面积(m²)")
    private BigDecimal area;

    @Schema(description = "位置描述")
    @ExcelProperty("位置描述")
    private String locationDesc;

    @Schema(description = "容量(kg)")
    @ExcelProperty("容量(kg)")
    private BigDecimal capacity;

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
