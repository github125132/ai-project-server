package cn.iocoder.yudao.module.gap.service.harvest;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestPlanDO;
import cn.iocoder.yudao.module.gap.dal.mysql.harvest.GapHarvestPlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.HARVEST_RECORD_NOT_EXISTS;

/**
 * GAP 采收计划 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapHarvestPlanServiceImpl implements GapHarvestPlanService {

    @Resource
    private GapHarvestPlanMapper harvestPlanMapper;

    @Override
    public Long createHarvestPlan(GapHarvestPlanSaveReqVO createReqVO) {
        // 1. 校验计划编号唯一
        validatePlanNoUnique(null, createReqVO.getPlanNo());

        // 2. 插入
        GapHarvestPlanDO harvestPlan = BeanUtils.toBean(createReqVO, GapHarvestPlanDO.class);
        harvestPlanMapper.insert(harvestPlan);
        return harvestPlan.getId();
    }

    @Override
    public void updateHarvestPlan(GapHarvestPlanSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateHarvestPlanExists(updateReqVO.getId());
        // 1.2 校验计划编号唯一
        validatePlanNoUnique(updateReqVO.getId(), updateReqVO.getPlanNo());

        // 2. 更新
        GapHarvestPlanDO updateObj = BeanUtils.toBean(updateReqVO, GapHarvestPlanDO.class);
        harvestPlanMapper.updateById(updateObj);
    }

    @Override
    public void deleteHarvestPlan(Long id) {
        // 1. 校验存在
        validateHarvestPlanExists(id);

        // 2. 删除
        harvestPlanMapper.deleteById(id);
    }

    @Override
    public GapHarvestPlanDO getHarvestPlan(Long id) {
        return harvestPlanMapper.selectById(id);
    }

    @Override
    public PageResult<GapHarvestPlanDO> getHarvestPlanPage(GapHarvestPlanPageReqVO pageReqVO) {
        return harvestPlanMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapHarvestPlanDO> getHarvestPlanList() {
        return harvestPlanMapper.selectList();
    }

    @Override
    public List<GapHarvestPlanDO> getHarvestPlanListByBaseId(Long baseId) {
        return harvestPlanMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapHarvestPlanDO> getHarvestPlanListByPlotId(Long plotId) {
        return harvestPlanMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapHarvestPlanDO validateHarvestPlanExists(Long id) {
        GapHarvestPlanDO harvestPlan = harvestPlanMapper.selectById(id);
        if (harvestPlan == null) {
            throw exception(HARVEST_RECORD_NOT_EXISTS);
        }
        return harvestPlan;
    }

    private void validatePlanNoUnique(Long id, String planNo) {
        if (planNo == null || planNo.isEmpty()) {
            return;
        }
        GapHarvestPlanDO harvestPlan = harvestPlanMapper.selectByPlanNo(planNo);
        if (harvestPlan == null) {
            return;
        }
        if (ObjUtil.notEqual(id, harvestPlan.getId())) {
            throw exception(HARVEST_BATCH_NO_DUPLICATE);
        }
    }

}
