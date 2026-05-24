package cn.iocoder.yudao.module.gap.service.base.planting;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.planting.GapPlotPlantingDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.planting.GapPlotPlantingMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapPlotPlantingServiceImpl implements GapPlotPlantingService {

    @Resource
    private GapPlotPlantingMapper plantingMapper;

    @Override
    public Long createPlanting(GapPlotPlantingSaveReqVO createReqVO) {
        GapPlotPlantingDO planting = BeanUtils.toBean(createReqVO, GapPlotPlantingDO.class);
        plantingMapper.insert(planting);
        return planting.getId();
    }

    @Override
    public void updatePlanting(GapPlotPlantingSaveReqVO updateReqVO) {
        validatePlantingExists(updateReqVO.getId());
        GapPlotPlantingDO updateObj = BeanUtils.toBean(updateReqVO, GapPlotPlantingDO.class);
        plantingMapper.updateById(updateObj);
    }

    @Override
    public void deletePlanting(Long id) {
        validatePlantingExists(id);
        plantingMapper.deleteById(id);
    }

    @Override
    public GapPlotPlantingDO getPlanting(Long id) {
        return plantingMapper.selectById(id);
    }

    @Override
    public PageResult<GapPlotPlantingDO> getPlantingPage(GapPlotPlantingPageReqVO pageReqVO) {
        return plantingMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPlotPlantingDO> getPlantingListByPlotId(Long plotId) {
        return plantingMapper.selectList(GapPlotPlantingDO::getPlotId, plotId);
    }

    @Override
    public List<GapPlotPlantingDO> getPlantingListByBaseId(Long baseId) {
        return plantingMapper.selectList(GapPlotPlantingDO::getBaseId, baseId);
    }

    @Override
    public GapPlotPlantingDO validatePlantingExists(Long id) {
        GapPlotPlantingDO planting = plantingMapper.selectById(id);
        if (planting == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return planting;
    }

}
