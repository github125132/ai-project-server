package cn.iocoder.yudao.module.gap.controller.admin.process.vo;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - GAP 加工工序明细分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GapProcessDetailPageReqVO extends PageParam {

    @Schema(description = "加工记录编号", example = "1")
    private Long processRecordId;

    @Schema(description = "工序序号", example = "1")
    private Integer processStep;

    @Schema(description = "工序名称", example = "清洗")
    private String processName;

    @Schema(description = "检查结果(0合格 1不合格)", example = "0")
    private Integer checkResult;

}
