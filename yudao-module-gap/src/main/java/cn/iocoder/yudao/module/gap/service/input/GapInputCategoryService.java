package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputCategoryDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 投入品分类 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInputCategoryService {

    /**
     * 创建投入品分类
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInputCategory(@Valid GapInputCategorySaveReqVO createReqVO);

    /**
     * 更新投入品分类
     *
     * @param updateReqVO 更新信息
     */
    void updateInputCategory(@Valid GapInputCategorySaveReqVO updateReqVO);

    /**
     * 删除投入品分类
     *
     * @param id 编号
     */
    void deleteInputCategory(Long id);

    /**
     * 获得投入品分类
     *
     * @param id 编号
     * @return 投入品分类
     */
    GapInputCategoryDO getInputCategory(Long id);

    /**
     * 获得投入品分类分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品分类分页
     */
    PageResult<GapInputCategoryDO> getInputCategoryPage(GapInputCategoryPageReqVO pageReqVO);

    /**
     * 获得投入品分类列表
     *
     * @return 投入品分类列表
     */
    List<GapInputCategoryDO> getInputCategoryList();

    /**
     * 根据父分类编号获得子分类列表
     *
     * @param parentId 父分类编号
     * @return 子分类列表
     */
    List<GapInputCategoryDO> getInputCategoryListByParentId(Long parentId);

    /**
     * 校验投入品分类存在
     *
     * @param id 编号
     * @return 投入品分类
     */
    GapInputCategoryDO validateInputCategoryExists(Long id);

}
