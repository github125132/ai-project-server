package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputProductDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 投入品产品 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInputProductService {

    /**
     * 创建投入品产品
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInputProduct(@Valid GapInputProductSaveReqVO createReqVO);

    /**
     * 更新投入品产品
     *
     * @param updateReqVO 更新信息
     */
    void updateInputProduct(@Valid GapInputProductSaveReqVO updateReqVO);

    /**
     * 删除投入品产品
     *
     * @param id 编号
     */
    void deleteInputProduct(Long id);

    /**
     * 获得投入品产品
     *
     * @param id 编号
     * @return 投入品产品
     */
    GapInputProductDO getInputProduct(Long id);

    /**
     * 获得投入品产品分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品产品分页
     */
    PageResult<GapInputProductDO> getInputProductPage(GapInputProductPageReqVO pageReqVO);

    /**
     * 获得投入品产品列表
     *
     * @return 投入品产品列表
     */
    List<GapInputProductDO> getInputProductList();

    /**
     * 获得投入品产品列表
     *
     * @param ids 产品编号集合
     * @return 投入品产品列表
     */
    List<GapInputProductDO> getInputProductList(Collection<Long> ids);

    /**
     * 根据分类编号获得产品列表
     *
     * @param categoryId 分类编号
     * @return 产品列表
     */
    List<GapInputProductDO> getInputProductListByCategoryId(Long categoryId);

    /**
     * 校验投入品产品存在
     *
     * @param id 编号
     * @return 投入品产品
     */
    GapInputProductDO validateInputProductExists(Long id);

}
