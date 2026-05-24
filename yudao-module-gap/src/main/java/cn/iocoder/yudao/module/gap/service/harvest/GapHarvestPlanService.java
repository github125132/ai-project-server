package cn.iocoder.yudao.module.gap.service.harvest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestPlanDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 采收计划 Service 接口
 *
 * @author 芋道源码
 */
public interface GapHarvestPlanService {

    /**
     * 创建采收计划
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHarvestPlan(@Valid GapHarvestPlanSaveReqVO createReqVO);

    /**
     * 更新采收计划
     *
     * @param updateReqVO 更新信息
     */
    void updateHarvestPlan(@Valid GapHarvestPlanSaveReqVO updateReqVO);

    /**
     * 删除采收计划
     *
     * @param id 编号
     */
    void deleteHarvestPlan(Long id);

    /**
     * 获得采收计划
     *
     * @param id 编号
     * @return 采收计划
     */
    GapHarvestPlanDO getHarvestPlan(Long id);

    /**
     * 获得采收计划分页
     *
     * @param pageReqVO 分页查询
     * @return 采收计划分页
     */
    PageResult<GapHarvestPlanDO> getHarvestPlanPage(GapHarvestPlanPageReqVO pageReqVO);

    /**
     * 获得采收计划列表
     *
     * @return 采收计划列表
     */
    List<GapHarvestPlanDO> getHarvestPlanList();

    /**
     * 根据基地编号获得采收计划列表
     *
     * @param baseId 基地编号
     * @return 采收计划列表
     */
    List<GapHarvestPlanDO> getHarvestPlanListByBaseId(Long baseId);

    /**
     * 根据地块编号获得采收计划列表
     *
     * @param plotId 地块编号
     * @return 采收计划列表
     */
    List<GapHarvestPlanDO> getHarvestPlanListByPlotId(Long plotId);

    /**
     * 校验采收计划存在
     *
     * @param id 编号
     * @return 采收计划
     */
    GapHarvestPlanDO validateHarvestPlanExists(Long id);

}
