package cn.iocoder.yudao.module.gap.controller.admin.base.vo.water;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 水源检测 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseWaterRespVO {

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
