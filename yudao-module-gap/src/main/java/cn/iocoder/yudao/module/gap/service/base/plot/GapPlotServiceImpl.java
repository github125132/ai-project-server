package cn.iocoder.yudao.module.gap.service.base.plot;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.plot.GapPlotDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.plot.GapPlotMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

@Service
@Validated
public class GapPlotServiceImpl implements GapPlotService {

    @Resource
    private GapPlotMapper plotMapper;

    @Override
    public Long createPlot(GapPlotSaveReqVO createReqVO) {
        validatePlotCodeUnique(null, createReqVO.getCode());
        GapPlotDO plot = BeanUtils.toBean(createReqVO, GapPlotDO.class);
        plotMapper.insert(plot);
        return plot.getId();
    }

    @Override
    public void updatePlot(GapPlotSaveReqVO updateReqVO) {
        validatePlotExists(updateReqVO.getId());
        validatePlotCodeUnique(updateReqVO.getId(), updateReqVO.getCode());
        GapPlotDO updateObj = BeanUtils.toBean(updateReqVO, GapPlotDO.class);
        plotMapper.updateById(updateObj);
    }

    @Override
    public void deletePlot(Long id) {
        validatePlotExists(id);
        plotMapper.deleteById(id);
    }

    @Override
    public GapPlotDO getPlot(Long id) {
        return plotMapper.selectById(id);
    }

    @Override
    public PageResult<GapPlotDO> getPlotPage(GapPlotPageReqVO pageReqVO) {
        return plotMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPlotDO> getPlotList() {
        return plotMapper.selectList();
    }

    @Override
    public List<GapPlotDO> getPlotList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return plotMapper.selectByIds(ids);
    }

    @Override
    public List<GapPlotDO> getPlotListByBaseId(Long baseId) {
        return plotMapper.selectList(GapPlotDO::getBaseId, baseId);
    }

    @Override
    public GapPlotDO validatePlotExists(Long id) {
        GapPlotDO plot = plotMapper.selectById(id);
        if (plot == null) {
            throw exception(PLOT_NOT_EXISTS);
        }
        return plot;
    }

    private void validatePlotCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapPlotDO plot = plotMapper.selectByCode(code);
        if (plot == null) {
            return;
        }
        if (ObjUtil.notEqual(id, plot.getId())) {
            throw exception(PLOT_CODE_DUPLICATE);
        }
    }

}
