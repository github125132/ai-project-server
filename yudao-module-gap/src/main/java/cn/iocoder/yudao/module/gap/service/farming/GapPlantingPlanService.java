package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPlantingPlanDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 种植计划 Service 接口
 *
 * @author 芋道源码
 */
public interface GapPlantingPlanService {

    /**
     * 创建种植计划
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPlantingPlan(@Valid GapPlantingPlanSaveReqVO createReqVO);

    /**
     * 更新种植计划
     *
     * @param updateReqVO 更新信息
     */
    void updatePlantingPlan(@Valid GapPlantingPlanSaveReqVO updateReqVO);

    /**
     * 删除种植计划
     *
     * @param id 编号
     */
    void deletePlantingPlan(Long id);

    /**
     * 获得种植计划
     *
     * @param id 编号
     * @return 种植计划
     */
    GapPlantingPlanDO getPlantingPlan(Long id);

    /**
     * 获得种植计划分页
     *
     * @param pageReqVO 分页查询
     * @return 种植计划分页
     */
    PageResult<GapPlantingPlanDO> getPlantingPlanPage(GapPlantingPlanPageReqVO pageReqVO);

    /**
     * 获得种植计划列表
     *
     * @return 种植计划列表
     */
    List<GapPlantingPlanDO> getPlantingPlanList();

    /**
     * 根据基地编号获得种植计划列表
     *
     * @param baseId 基地编号
     * @return 种植计划列表
     */
    List<GapPlantingPlanDO> getPlantingPlanListByBaseId(Long baseId);

    /**
     * 根据地块编号获得种植计划列表
     *
     * @param plotId 地块编号
     * @return 种植计划列表
     */
    List<GapPlantingPlanDO> getPlantingPlanListByPlotId(Long plotId);

    /**
     * 校验种植计划存在
     *
     * @param id 编号
     * @return 种植计划
     */
    GapPlantingPlanDO validatePlantingPlanExists(Long id);

}
