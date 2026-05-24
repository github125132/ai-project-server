package cn.iocoder.yudao.module.gap.dal.dataobject.input;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * GAP 投入品分类 DO
 *
 * @author 芋道源码
 */
@TableName("gap_input_category")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInputCategoryDO extends BaseDO {

    /**
     * 分类编号
     */
    private Long id;
    /**
     * 父分类编号
     */
    private Long parentId;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类编码
     */
    private String code;
    /**
     * 大类(0农药 1肥料 2生物制剂 3其他)
     */
    private Integer categoryType;
    /**
     * 是否禁用
     */
    private Boolean banned;
    /**
     * 禁用原因
     */
    private String banReason;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
