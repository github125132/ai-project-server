package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 数据变更日志 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapDataChangeLogRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "表名", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("表名")
    private String tableName;

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("记录编号")
    private Long recordId;

    @Schema(description = "变更类型(0新增 1修改 2删除)")
    @ExcelProperty("变更类型")
    private Integer changeType;

    @Schema(description = "字段名")
    @ExcelProperty("字段名")
    private String fieldName;

    @Schema(description = "字段中文名")
    @ExcelProperty("字段中文名")
    private String fieldLabel;

    @Schema(description = "旧值")
    @ExcelProperty("旧值")
    private String oldValue;

    @Schema(description = "新值")
    @ExcelProperty("新值")
    private String newValue;

    @Schema(description = "变更原因(GAP要求)")
    @ExcelProperty("变更原因")
    private String changeReason;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "操作人姓名")
    @ExcelProperty("操作人姓名")
    private String operatorName;

    @Schema(description = "操作时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("操作时间")
    private LocalDateTime operateTime;

    @Schema(description = "操作IP")
    @ExcelProperty("操作IP")
    private String operateIp;

    @Schema(description = "版本号")
    @ExcelProperty("版本号")
    private Integer version;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
