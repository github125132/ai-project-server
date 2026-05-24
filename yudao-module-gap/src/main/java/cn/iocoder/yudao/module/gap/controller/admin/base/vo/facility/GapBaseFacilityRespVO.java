package cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 基地设施设备 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapBaseFacilityRespVO {

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;
}
