package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputInventoryDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 投入品库存 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInputInventoryService {

    /**
     * 创建投入品库存
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInputInventory(@Valid GapInputInventorySaveReqVO createReqVO);

    /**
     * 更新投入品库存
     *
     * @param updateReqVO 更新信息
     */
    void updateInputInventory(@Valid GapInputInventorySaveReqVO updateReqVO);

    /**
     * 删除投入品库存
     *
     * @param id 编号
     */
    void deleteInputInventory(Long id);

    /**
     * 获得投入品库存
     *
     * @param id 编号
     * @return 投入品库存
     */
    GapInputInventoryDO getInputInventory(Long id);

    /**
     * 获得投入品库存分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品库存分页
     */
    PageResult<GapInputInventoryDO> getInputInventoryPage(GapInputInventoryPageReqVO pageReqVO);

    /**
     * 获得投入品库存列表
     *
     * @return 投入品库存列表
     */
    List<GapInputInventoryDO> getInputInventoryList();

    /**
     * 获得投入品库存列表
     *
     * @param ids 库存编号集合
     * @return 投入品库存列表
     */
    List<GapInputInventoryDO> getInputInventoryList(Collection<Long> ids);

    /**
     * 根据产品编号获得库存列表
     *
     * @param productId 产品编号
     * @return 库存列表
     */
    List<GapInputInventoryDO> getInputInventoryListByProductId(Long productId);

    /**
     * 校验投入品库存存在
     *
     * @param id 编号
     * @return 投入品库存
     */
    GapInputInventoryDO validateInputInventoryExists(Long id);

}
