package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 记录模板分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapRecordTemplatePageReqVO extends PageParam {

    @Schema(description = "分类编号", example = "1")
    private Long categoryId;

    @Schema(description = "模板编号", example = "TPL-001")
    private String templateNo;

    @Schema(description = "模板名称", example = "农事记录")
    private String name;

    @Schema(description = "模板类型(0原始记录 1台账 2报告)", example = "0")
    private Integer templateType;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
