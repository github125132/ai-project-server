package cn.iocoder.yudao.module.gap.service.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 审核检查表 Service 接口
 *
 * @author 芋道源码
 */
public interface GapAuditChecklistService {

    /**
     * 创建审核检查表
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAuditChecklist(@Valid GapAuditChecklistSaveReqVO createReqVO);

    /**
     * 更新审核检查表
     *
     * @param updateReqVO 更新信息
     */
    void updateAuditChecklist(@Valid GapAuditChecklistSaveReqVO updateReqVO);

    /**
     * 删除审核检查表
     *
     * @param id 编号
     */
    void deleteAuditChecklist(Long id);

    /**
     * 获得审核检查表
     *
     * @param id 编号
     * @return 审核检查表
     */
    GapAuditChecklistDO getAuditChecklist(Long id);

    /**
     * 获得审核检查表分页
     *
     * @param pageReqVO 分页查询
     * @return 审核检查表分页
     */
    PageResult<GapAuditChecklistDO> getAuditChecklistPage(GapAuditChecklistPageReqVO pageReqVO);

    /**
     * 获得审核检查表列表
     *
     * @return 审核检查表列表
     */
    List<GapAuditChecklistDO> getAuditChecklistList();

    /**
     * 获得审核检查表列表
     *
     * @param ids 编号集合
     * @return 审核检查表列表
     */
    List<GapAuditChecklistDO> getAuditChecklistList(Collection<Long> ids);

    /**
     * 根据审核计划获得检查表列表
     *
     * @param planId 审核计划编号
     * @return 审核检查表列表
     */
    List<GapAuditChecklistDO> getAuditChecklistListByPlanId(Long planId);

    /**
     * 校验审核检查表存在
     *
     * @param id 编号
     * @return 审核检查表
     */
    GapAuditChecklistDO validateAuditChecklistExists(Long id);

}
