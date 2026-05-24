package cn.iocoder.yudao.module.gap.controller.admin.log.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 数据变更日志新增/修改 Request VO")
@Data
public class GapDataChangeLogSaveReqVO {

    @Schema(description = "编号", example = "1024")
    private Long id;

    @Schema(description = "表名", requiredMode = Schema.RequiredMode.REQUIRED, example = "gap_base_info")
    @NotEmpty(message = "表名不能为空")
    private String tableName;

    @Schema(description = "记录编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "记录编号不能为空")
    private Long recordId;

    @Schema(description = "变更类型(0新增 1修改 2删除)", requiredMode = Schema.RequiredMode.REQUIRED, example = "0")
    @NotNull(message = "变更类型不能为空")
    private Integer changeType;

    @Schema(description = "字段名", example = "name")
    private String fieldName;

    @Schema(description = "字段中文名", example = "名称")
    private String fieldLabel;

    @Schema(description = "旧值")
    private String oldValue;

    @Schema(description = "新值")
    private String newValue;

    @Schema(description = "变更原因(GAP要求)")
    private String changeReason;

    @Schema(description = "操作人", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "操作人不能为空")
    private Long operatorId;

    @Schema(description = "操作人姓名", example = "张三")
    private String operatorName;

    @Schema(description = "操作时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "操作时间不能为空")
    private LocalDateTime operateTime;

    @Schema(description = "操作IP", example = "192.168.1.1")
    private String operateIp;

    @Schema(description = "版本号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "版本号不能为空")
    private Integer version;

    @Schema(description = "备注")
    private String remark;

}
