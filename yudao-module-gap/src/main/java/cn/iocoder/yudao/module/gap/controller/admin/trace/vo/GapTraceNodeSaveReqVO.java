package cn.iocoder.yudao.module.gap.controller.admin.trace.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 溯源节点新增/修改 Request VO")
@Data
public class GapTraceNodeSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "溯源批次编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "溯源批次编号不能为空")
    private Long traceBatchId;

    @Schema(description = "追溯码", example = "TRACE-2024001")
    private String traceCode;

    @Schema(description = "节点类型(0种植 1农事 2采收 3加工 4包装 5入库 6检验 7放行 8出库 9运输)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "节点类型不能为空")
    private Integer nodeType;

    @Schema(description = "节点名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "播种")
    @NotEmpty(message = "节点名称不能为空")
    private String nodeName;

    @Schema(description = "节点时间")
    private LocalDateTime nodeTime;

    @Schema(description = "源记录编号", example = "1")
    private Long sourceRecordId;

    @Schema(description = "源记录单号", example = "FARM-2024001")
    private String sourceRecordNo;

    @Schema(description = "操作人", example = "张三")
    private String operatorName;

    @Schema(description = "地点")
    private String location;

    @Schema(description = "节点描述")
    private String description;

    @Schema(description = "照片附件")
    private String photoUrl;

    @Schema(description = "节点详情(JSON)")
    private String detailJson;

    @Schema(description = "排序", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "排序不能为空")
    private Integer sort;

    @Schema(description = "状态", example = "0")
    private Integer status;

    @Schema(description = "备注")
    private String remark;

}
