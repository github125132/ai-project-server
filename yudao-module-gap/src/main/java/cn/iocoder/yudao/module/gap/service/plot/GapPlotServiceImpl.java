package cn.iocoder.yudao.module.gap.service.plot;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.plot.GapPlotDO;
import cn.iocoder.yudao.module.gap.dal.mysql.plot.GapPlotMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.PLOT_NOT_EXISTS;

@Service
@Validated
public class GapPlotServiceImpl implements GapPlotService {

    @Resource
    private GapPlotMapper PlotMapper;

    @Override
    public Long createGapPlot(GapPlotSaveReqVO createReqVO) {
        GapPlotDO entity = BeanUtils.toBean(createReqVO, GapPlotDO.class);
        PlotMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapPlot(GapPlotSaveReqVO updateReqVO) {
        validateGapPlotExists(updateReqVO.getId());
        GapPlotDO updateObj = BeanUtils.toBean(updateReqVO, GapPlotDO.class);
        PlotMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapPlot(Long id) {
        validateGapPlotExists(id);
        PlotMapper.deleteById(id);
    }

    @Override
    public GapPlotDO getGapPlot(Long id) {
        return PlotMapper.selectById(id);
    }

    @Override
    public PageResult<GapPlotDO> getGapPlotPage(GapPlotPageReqVO pageReqVO) {
        return PlotMapper.selectPage(pageReqVO);
    }

    @Override
    public GapPlotDO validateGapPlotExists(Long id) {
        GapPlotDO entity = PlotMapper.selectById(id);
        if (entity == null) {
            throw exception(PLOT_NOT_EXISTS);
        }
        return entity;
    }
}
