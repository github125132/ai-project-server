package cn.iocoder.yudao.module.gap.service.plot;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.plot.GapPlotDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapPlotService {

    Long createGapPlot(@Valid GapPlotSaveReqVO createReqVO);

    void updateGapPlot(@Valid GapPlotSaveReqVO updateReqVO);

    void deleteGapPlot(Long id);

    GapPlotDO getGapPlot(Long id);

    PageResult<GapPlotDO> getGapPlotPage(GapPlotPageReqVO pageReqVO);

    GapPlotDO validateGapPlotExists(Long id);
}
