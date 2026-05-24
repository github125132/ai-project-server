package cn.iocoder.yudao.module.gap.controller.admin.storage.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP 不合格品处理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapUnqualifiedHandleRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "处理单号")
    @ExcelProperty("处理单号")
    private String recordNo;

    @Schema(description = "来源类型(0采收 1加工 2检验 3仓储)")
    @ExcelProperty("来源类型")
    private Integer sourceType;

    @Schema(description = "来源记录编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("来源记录编号")
    private Long sourceRecordId;

    @Schema(description = "批次号")
    @ExcelProperty("批次号")
    private String batchNo;

    @Schema(description = "品种编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("品种编号")
    private Long varietyId;

    @Schema(description = "不合格原因")
    @ExcelProperty("不合格原因")
    private String unqualifiedReason;

    @Schema(description = "数量(kg)")
    @ExcelProperty("数量(kg)")
    private BigDecimal quantity;

    @Schema(description = "处理方式(0返工 1降级 2销毁 3退货)")
    @ExcelProperty("处理方式")
    private Integer handleMethod;

    @Schema(description = "处理结果")
    @ExcelProperty("处理结果")
    private String handleResult;

    @Schema(description = "处理日期")
    @ExcelProperty("处理日期")
    private LocalDate handleDate;

    @Schema(description = "处理人", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("处理人")
    private Long handlerId;

    @Schema(description = "监督人")
    @ExcelProperty("监督人")
    private Long supervisorId;

    @Schema(description = "处理照片")
    @ExcelProperty("处理照片")
    private String photoUrl;

    @Schema(description = "状态(0待处理 1处理中 2已处理)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
