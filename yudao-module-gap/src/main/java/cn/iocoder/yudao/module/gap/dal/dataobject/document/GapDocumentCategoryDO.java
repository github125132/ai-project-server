package cn.iocoder.yudao.module.gap.dal.dataobject.document;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * GAP 文件分类 DO
 *
 * @author 芋道源码
 */
@TableName("gap_document_category")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapDocumentCategoryDO extends BaseDO {

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
     * 文件类型(0质量手册 1程序文件 2SOP 3记录表单 4技术标准 5管理制度)
     */
    private Integer categoryType;
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
