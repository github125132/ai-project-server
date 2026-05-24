package cn.iocoder.yudao.module.gap.service.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistItemDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 审核检查表项目 Service 接口
 *
 * @author 芋道源码
 */
public interface GapAuditChecklistItemService {

    /**
     * 创建审核检查表项目
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAuditChecklistItem(@Valid GapAuditChecklistItemSaveReqVO createReqVO);

    /**
     * 更新审核检查表项目
     *
     * @param updateReqVO 更新信息
     */
    void updateAuditChecklistItem(@Valid GapAuditChecklistItemSaveReqVO updateReqVO);

    /**
     * 删除审核检查表项目
     *
     * @param id 编号
     */
    void deleteAuditChecklistItem(Long id);

    /**
     * 获得审核检查表项目
     *
     * @param id 编号
     * @return 审核检查表项目
     */
    GapAuditChecklistItemDO getAuditChecklistItem(Long id);

    /**
     * 获得审核检查表项目分页
     *
     * @param pageReqVO 分页查询
     * @return 审核检查表项目分页
     */
    PageResult<GapAuditChecklistItemDO> getAuditChecklistItemPage(GapAuditChecklistItemPageReqVO pageReqVO);

    /**
     * 获得审核检查表项目列表
     *
     * @return 审核检查表项目列表
     */
    List<GapAuditChecklistItemDO> getAuditChecklistItemList();

    /**
     * 获得审核检查表项目列表
     *
     * @param ids 编号集合
     * @return 审核检查表项目列表
     */
    List<GapAuditChecklistItemDO> getAuditChecklistItemList(Collection<Long> ids);

    /**
     * 根据检查表获得项目列表
     *
     * @param checklistId 检查表编号
     * @return 审核检查表项目列表
     */
    List<GapAuditChecklistItemDO> getAuditChecklistItemListByChecklistId(Long checklistId);

    /**
     * 校验审核检查表项目存在
     *
     * @param id 编号
     * @return 审核检查表项目
     */
    GapAuditChecklistItemDO validateAuditChecklistItemExists(Long id);

}
