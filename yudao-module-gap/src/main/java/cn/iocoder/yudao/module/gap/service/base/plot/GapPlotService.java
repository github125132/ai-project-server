package cn.iocoder.yudao.module.gap.service.base.plot;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.plot.GapPlotDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

public interface GapPlotService {

    Long createPlot(@Valid GapPlotSaveReqVO createReqVO);

    void updatePlot(@Valid GapPlotSaveReqVO updateReqVO);

    void deletePlot(Long id);

    GapPlotDO getPlot(Long id);

    PageResult<GapPlotDO> getPlotPage(GapPlotPageReqVO pageReqVO);

    List<GapPlotDO> getPlotList();

    List<GapPlotDO> getPlotList(Collection<Long> ids);

    List<GapPlotDO> getPlotListByBaseId(Long baseId);

    GapPlotDO validatePlotExists(Long id);

}
