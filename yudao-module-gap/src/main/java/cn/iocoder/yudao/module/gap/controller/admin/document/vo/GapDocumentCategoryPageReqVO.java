package cn.iocoder.yudao.module.gap.controller.admin.document.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 文件分类分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapDocumentCategoryPageReqVO extends PageParam {

    @Schema(description = "父分类编号", example = "0")
    private Long parentId;

    @Schema(description = "分类名称", example = "质量手册")
    private String name;

    @Schema(description = "分类编码", example = "QM")
    private String code;

    @Schema(description = "文件类型(0质量手册 1程序文件 2SOP 3记录表单 4技术标准 5管理制度)", example = "0")
    private Integer categoryType;

    @Schema(description = "状态", example = "0")
    private Integer status;

}
