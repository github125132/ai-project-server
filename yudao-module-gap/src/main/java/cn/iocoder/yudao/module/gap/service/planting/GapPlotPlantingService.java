package cn.iocoder.yudao.module.gap.service.planting;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.planting.GapPlotPlantingDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapPlotPlantingService {

    Long createGapPlotPlanting(@Valid GapPlotPlantingSaveReqVO createReqVO);

    void updateGapPlotPlanting(@Valid GapPlotPlantingSaveReqVO updateReqVO);

    void deleteGapPlotPlanting(Long id);

    GapPlotPlantingDO getGapPlotPlanting(Long id);

    PageResult<GapPlotPlantingDO> getGapPlotPlantingPage(GapPlotPlantingPageReqVO pageReqVO);

    GapPlotPlantingDO validateGapPlotPlantingExists(Long id);
}
