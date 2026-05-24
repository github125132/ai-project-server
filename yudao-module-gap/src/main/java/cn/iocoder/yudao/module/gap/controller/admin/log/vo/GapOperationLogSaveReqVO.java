package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 业务操作日志新增/修改 Request VO")
@Data
public class GapOperationLogSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "日志类型(0新增 1修改 2删除 3查询 4导入 5导出 6审批)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "日志类型不能为空")
    private Integer logType;

    @Schema(description = "业务模块", example = "base-info")
    private String moduleType;

    @Schema(description = "表名", example = "gap_base_info")
    private String tableName;

    @Schema(description = "记录编号", example = "1")
    private Long recordId;

    @Schema(description = "记录单号", example = "BASE-001")
    private String recordNo;

    @Schema(description = "操作描述")
    private String operationDesc;

    @Schema(description = "请求数据")
    private String requestData;

    @Schema(description = "响应数据")
    private String responseData;

    @Schema(description = "操作人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "操作人不能为空")
    private Long operatorId;

    @Schema(description = "操作人姓名", example = "张三")
    private String operatorName;

    @Schema(description = "操作IP", example = "192.168.1.1")
    private String operateIp;

    @Schema(description = "操作时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "操作时间不能为空")
    private LocalDateTime operateTime;

    @Schema(description = "耗时(ms)", example = "100")
    private Integer duration;

    @Schema(description = "结果(0成功 1失败)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "结果不能为空")
    private Integer result;

    @Schema(description = "错误信息")
    private String errorMsg;

    @Schema(description = "备注")
    private String remark;

}
