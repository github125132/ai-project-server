package cn.iocoder.yudao.module.gap.controller.admin.input.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 投入品供应商分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapInputSupplierPageReqVO extends PageParam {

    @Schema(description = "供应商编码", example = "SUP-001")
    private String code;

    @Schema(description = "供应商名称", example = "云南农资有限公司")
    private String name;

    @Schema(description = "联系人", example = "张三")
    private String contactPerson;

    @Schema(description = "审计结果(0合格 1不合格)", example = "0")
    private Integer auditResult;

    @Schema(description = "状态(0合格供应商 1观察 2不合格)", example = "0")
    private Integer status;

}
