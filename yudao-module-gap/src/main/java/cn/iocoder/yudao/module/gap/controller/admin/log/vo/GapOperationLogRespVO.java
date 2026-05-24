package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 业务操作日志 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapOperationLogRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "日志类型(0新增 1修改 2删除 3查询 4导入 5导出 6审批)")
    @ExcelProperty("日志类型")
    private Integer logType;

    @Schema(description = "业务模块")
    @ExcelProperty("业务模块")
    private String moduleType;

    @Schema(description = "表名")
    @ExcelProperty("表名")
    private String tableName;

    @Schema(description = "记录编号")
    @ExcelProperty("记录编号")
    private Long recordId;

    @Schema(description = "记录单号")
    @ExcelProperty("记录单号")
    private String recordNo;

    @Schema(description = "操作描述")
    @ExcelProperty("操作描述")
    private String operationDesc;

    @Schema(description = "请求数据")
    @ExcelProperty("请求数据")
    private String requestData;

    @Schema(description = "响应数据")
    @ExcelProperty("响应数据")
    private String responseData;

    @Schema(description = "操作人")
    @ExcelProperty("操作人")
    private Long operatorId;

    @Schema(description = "操作人姓名")
    @ExcelProperty("操作人姓名")
    private String operatorName;

    @Schema(description = "操作IP")
    @ExcelProperty("操作IP")
    private String operateIp;

    @Schema(description = "操作时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("操作时间")
    private LocalDateTime operateTime;

    @Schema(description = "耗时(ms)")
    @ExcelProperty("耗时(ms)")
    private Integer duration;

    @Schema(description = "结果(0成功 1失败)")
    @ExcelProperty("结果")
    private Integer result;

    @Schema(description = "错误信息")
    @ExcelProperty("错误信息")
    private String errorMsg;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
