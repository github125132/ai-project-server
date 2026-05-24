package cn.iocoder.yudao.module.gap.service.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditPlanDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 审核计划 Service 接口
 *
 * @author 芋道源码
 */
public interface GapAuditPlanService {

    /**
     * 创建审核计划
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAuditPlan(@Valid GapAuditPlanSaveReqVO createReqVO);

    /**
     * 更新审核计划
     *
     * @param updateReqVO 更新信息
     */
    void updateAuditPlan(@Valid GapAuditPlanSaveReqVO updateReqVO);

    /**
     * 删除审核计划
     *
     * @param id 编号
     */
    void deleteAuditPlan(Long id);

    /**
     * 获得审核计划
     *
     * @param id 编号
     * @return 审核计划
     */
    GapAuditPlanDO getAuditPlan(Long id);

    /**
     * 获得审核计划分页
     *
     * @param pageReqVO 分页查询
     * @return 审核计划分页
     */
    PageResult<GapAuditPlanDO> getAuditPlanPage(GapAuditPlanPageReqVO pageReqVO);

    /**
     * 获得审核计划列表
     *
     * @return 审核计划列表
     */
    List<GapAuditPlanDO> getAuditPlanList();

    /**
     * 获得审核计划列表
     *
     * @param ids 编号集合
     * @return 审核计划列表
     */
    List<GapAuditPlanDO> getAuditPlanList(Collection<Long> ids);

    /**
     * 校验审核计划存在
     *
     * @param id 编号
     * @return 审核计划
     */
    GapAuditPlanDO validateAuditPlanExists(Long id);

}
