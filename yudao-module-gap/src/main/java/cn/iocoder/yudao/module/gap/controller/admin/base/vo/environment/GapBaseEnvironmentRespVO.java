package cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 基地环境评估 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseEnvironmentRespVO {

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
