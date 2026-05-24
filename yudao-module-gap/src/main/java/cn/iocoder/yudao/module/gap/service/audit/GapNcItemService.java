package cn.iocoder.yudao.module.gap.service.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapNcItemDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 不符合项 Service 接口
 *
 * @author 芋道源码
 */
public interface GapNcItemService {

    /**
     * 创建不符合项
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createNcItem(@Valid GapNcItemSaveReqVO createReqVO);

    /**
     * 更新不符合项
     *
     * @param updateReqVO 更新信息
     */
    void updateNcItem(@Valid GapNcItemSaveReqVO updateReqVO);

    /**
     * 删除不符合项
     *
     * @param id 编号
     */
    void deleteNcItem(Long id);

    /**
     * 获得不符合项
     *
     * @param id 编号
     * @return 不符合项
     */
    GapNcItemDO getNcItem(Long id);

    /**
     * 获得不符合项分页
     *
     * @param pageReqVO 分页查询
     * @return 不符合项分页
     */
    PageResult<GapNcItemDO> getNcItemPage(GapNcItemPageReqVO pageReqVO);

    /**
     * 获得不符合项列表
     *
     * @return 不符合项列表
     */
    List<GapNcItemDO> getNcItemList();

    /**
     * 获得不符合项列表
     *
     * @param ids 编号集合
     * @return 不符合项列表
     */
    List<GapNcItemDO> getNcItemList(Collection<Long> ids);

    /**
     * 根据审核计划获得不符合项列表
     *
     * @param planId 审核计划编号
     * @return 不符合项列表
     */
    List<GapNcItemDO> getNcItemListByPlanId(Long planId);

    /**
     * 校验不符合项存在
     *
     * @param id 编号
     * @return 不符合项
     */
    GapNcItemDO validateNcItemExists(Long id);

}
