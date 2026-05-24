package cn.iocoder.yudao.module.gap.service.water;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.water.GapBaseWaterDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseWaterService {

    Long createGapBaseWater(@Valid GapBaseWaterSaveReqVO createReqVO);

    void updateGapBaseWater(@Valid GapBaseWaterSaveReqVO updateReqVO);

    void deleteGapBaseWater(Long id);

    GapBaseWaterDO getGapBaseWater(Long id);

    PageResult<GapBaseWaterDO> getGapBaseWaterPage(GapBaseWaterPageReqVO pageReqVO);

    GapBaseWaterDO validateGapBaseWaterExists(Long id);
}
