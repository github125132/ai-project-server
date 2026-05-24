package cn.iocoder.yudao.module.gap.service.base.planting;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.planting.GapPlotPlantingDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapPlotPlantingService {

    Long createPlanting(@Valid GapPlotPlantingSaveReqVO createReqVO);

    void updatePlanting(@Valid GapPlotPlantingSaveReqVO updateReqVO);

    void deletePlanting(Long id);

    GapPlotPlantingDO getPlanting(Long id);

    PageResult<GapPlotPlantingDO> getPlantingPage(GapPlotPlantingPageReqVO pageReqVO);

    List<GapPlotPlantingDO> getPlantingListByPlotId(Long plotId);

    List<GapPlotPlantingDO> getPlantingListByBaseId(Long baseId);

    GapPlotPlantingDO validatePlantingExists(Long id);

}
