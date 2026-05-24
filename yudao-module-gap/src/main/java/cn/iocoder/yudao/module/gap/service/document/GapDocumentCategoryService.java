package cn.iocoder.yudao.module.gap.service.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentCategoryDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 文件分类 Service 接口
 *
 * @author 芋道源码
 */
public interface GapDocumentCategoryService {

    /**
     * 创建文件分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDocumentCategory(@Valid GapDocumentCategorySaveReqVO createReqVO);

    /**
     * 更新文件分类
     *
     * @param updateReqVO 更新信息
     */
    void updateDocumentCategory(@Valid GapDocumentCategorySaveReqVO updateReqVO);

    /**
     * 删除文件分类
     *
     * @param id 编号
     */
    void deleteDocumentCategory(Long id);

    /**
     * 获得文件分类
     *
     * @param id 编号
     * @return 文件分类
     */
    GapDocumentCategoryDO getDocumentCategory(Long id);

    /**
     * 获得文件分类分页
     *
     * @param pageReqVO 分页查询
     * @return 文件分类分页
     */
    PageResult<GapDocumentCategoryDO> getDocumentCategoryPage(GapDocumentCategoryPageReqVO pageReqVO);

    /**
     * 获得文件分类列表
     *
     * @return 文件分类列表
     */
    List<GapDocumentCategoryDO> getDocumentCategoryList();

    /**
     * 根据父分类ID获得子分类列表
     *
     * @param parentId 父分类编号
     * @return 子分类列表
     */
    List<GapDocumentCategoryDO> getDocumentCategoryListByParentId(Long parentId);

    /**
     * 校验文件分类存在
     *
     * @param id 编号
     * @return 文件分类
     */
    GapDocumentCategoryDO validateDocumentCategoryExists(Long id);

}
