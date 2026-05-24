package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPlantingPlanDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapPlantingPlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.PLANTING_PLAN_NOT_EXISTS;

/**
 * GAP 种植计划 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapPlantingPlanServiceImpl implements GapPlantingPlanService {

    @Resource
    private GapPlantingPlanMapper plantingPlanMapper;

    @Override
    public Long createPlantingPlan(GapPlantingPlanSaveReqVO createReqVO) {
        // 插入
        GapPlantingPlanDO plantingPlan = BeanUtils.toBean(createReqVO, GapPlantingPlanDO.class);
        plantingPlanMapper.insert(plantingPlan);
        return plantingPlan.getId();
    }

    @Override
    public void updatePlantingPlan(GapPlantingPlanSaveReqVO updateReqVO) {
        // 校验存在
        validatePlantingPlanExists(updateReqVO.getId());

        // 更新
        GapPlantingPlanDO updateObj = BeanUtils.toBean(updateReqVO, GapPlantingPlanDO.class);
        plantingPlanMapper.updateById(updateObj);
    }

    @Override
    public void deletePlantingPlan(Long id) {
        // 校验存在
        validatePlantingPlanExists(id);

        // 删除
        plantingPlanMapper.deleteById(id);
    }

    @Override
    public GapPlantingPlanDO getPlantingPlan(Long id) {
        return plantingPlanMapper.selectById(id);
    }

    @Override
    public PageResult<GapPlantingPlanDO> getPlantingPlanPage(GapPlantingPlanPageReqVO pageReqVO) {
        return plantingPlanMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPlantingPlanDO> getPlantingPlanList() {
        return plantingPlanMapper.selectList();
    }

    @Override
    public List<GapPlantingPlanDO> getPlantingPlanListByBaseId(Long baseId) {
        return plantingPlanMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapPlantingPlanDO> getPlantingPlanListByPlotId(Long plotId) {
        return plantingPlanMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapPlantingPlanDO validatePlantingPlanExists(Long id) {
        GapPlantingPlanDO plantingPlan = plantingPlanMapper.selectById(id);
        if (plantingPlan == null) {
            throw exception(PLANTING_PLAN_NOT_EXISTS);
        }
        return plantingPlan;
    }

}
