package cn.iocoder.yudao.module.gap.controller.admin.trace.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 溯源节点 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapTraceNodeRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "溯源批次编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("溯源批次编号")
    private Long traceBatchId;

    @Schema(description = "追溯码")
    @ExcelProperty("追溯码")
    private String traceCode;

    @Schema(description = "节点类型(0种植 1农事 2采收 3加工 4包装 5入库 6检验 7放行 8出库 9运输)")
    @ExcelProperty("节点类型")
    private Integer nodeType;

    @Schema(description = "节点名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("节点名称")
    private String nodeName;

    @Schema(description = "节点时间")
    @ExcelProperty("节点时间")
    private LocalDateTime nodeTime;

    @Schema(description = "源记录编号")
    @ExcelProperty("源记录编号")
    private Long sourceRecordId;

    @Schema(description = "源记录单号")
    @ExcelProperty("源记录单号")
    private String sourceRecordNo;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private String operatorName;

    @Schema(description = "地点")
    @ExcelProperty("地点")
    private String location;

    @Schema(description = "节点描述")
    @ExcelProperty("节点描述")
    private String description;

    @Schema(description = "照片附件")
    @ExcelProperty("照片附件")
    private String photoUrl;

    @Schema(description = "节点详情(JSON)")
    @ExcelProperty("节点详情")
    private String detailJson;

    @Schema(description = "排序")
    @ExcelProperty("排序")
    private Integer sort;

    @Schema(description = "状态")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
