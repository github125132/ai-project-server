package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - GAP SOP Response VO")
@Data
@ExcelIgnoreUnannotated
public class GapSopRespVO {

    @Schema(description = "SOP编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "1024")
    @ExcelProperty("SOP编号")
    private Long id;

    @Schema(description = "SOP编号", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("SOP编号")
    private String sopNo;

    @Schema(description = "SOP名称", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("SOP名称")
    private String name;

    @Schema(description = "类别(0种植 1采收 2加工 3仓储 4检验 5设备 6卫生)")
    @ExcelProperty("类别")
    private Integer category;

    @Schema(description = "版本号")
    @ExcelProperty("版本号")
    private String version;

    @Schema(description = "目的")
    @ExcelProperty("目的")
    private String purpose;

    @Schema(description = "适用范围")
    @ExcelProperty("适用范围")
    private String scope;

    @Schema(description = "职责")
    @ExcelProperty("职责")
    private String responsibility;

    @Schema(description = "操作步骤")
    @ExcelProperty("操作步骤")
    private String procedure;

    @Schema(description = "注意事项")
    @ExcelProperty("注意事项")
    private String precautions;

    @Schema(description = "相关文件")
    @ExcelProperty("相关文件")
    private String relatedDocs;

    @Schema(description = "相关记录")
    @ExcelProperty("相关记录")
    private String relatedRecords;

    @Schema(description = "生效日期")
    @ExcelProperty("生效日期")
    private LocalDate effectiveDate;

    @Schema(description = "附件")
    @ExcelProperty("附件")
    private String fileUrl;

    @Schema(description = "批准人")
    @ExcelProperty("批准人")
    private Long approverId;

    @Schema(description = "批准日期")
    @ExcelProperty("批准日期")
    private LocalDate approveDate;

    @Schema(description = "状态(0草稿 1已批准 2已废止)")
    @ExcelProperty("状态")
    private Integer status;

    @Schema(description = "备注")
    @ExcelProperty("备注")
    private String remark;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
