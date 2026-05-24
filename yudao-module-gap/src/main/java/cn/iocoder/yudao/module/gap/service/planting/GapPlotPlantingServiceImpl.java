package cn.iocoder.yudao.module.gap.service.planting;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.planting.GapPlotPlantingDO;
import cn.iocoder.yudao.module.gap.dal.mysql.planting.GapPlotPlantingMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapPlotPlantingServiceImpl implements GapPlotPlantingService {

    @Resource
    private GapPlotPlantingMapper PlotPlantingMapper;

    @Override
    public Long createGapPlotPlanting(GapPlotPlantingSaveReqVO createReqVO) {
        GapPlotPlantingDO entity = BeanUtils.toBean(createReqVO, GapPlotPlantingDO.class);
        PlotPlantingMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapPlotPlanting(GapPlotPlantingSaveReqVO updateReqVO) {
        validateGapPlotPlantingExists(updateReqVO.getId());
        GapPlotPlantingDO updateObj = BeanUtils.toBean(updateReqVO, GapPlotPlantingDO.class);
        PlotPlantingMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapPlotPlanting(Long id) {
        validateGapPlotPlantingExists(id);
        PlotPlantingMapper.deleteById(id);
    }

    @Override
    public GapPlotPlantingDO getGapPlotPlanting(Long id) {
        return PlotPlantingMapper.selectById(id);
    }

    @Override
    public PageResult<GapPlotPlantingDO> getGapPlotPlantingPage(GapPlotPlantingPageReqVO pageReqVO) {
        return PlotPlantingMapper.selectPage(pageReqVO);
    }

    @Override
    public GapPlotPlantingDO validateGapPlotPlantingExists(Long id) {
        GapPlotPlantingDO entity = PlotPlantingMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
