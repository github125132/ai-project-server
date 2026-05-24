package cn.iocoder.yudao.module.gap.service.base.water;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.water.GapBaseWaterDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseWaterService {

    Long createWater(@Valid GapBaseWaterSaveReqVO createReqVO);

    void updateWater(@Valid GapBaseWaterSaveReqVO updateReqVO);

    void deleteWater(Long id);

    GapBaseWaterDO getWater(Long id);

    PageResult<GapBaseWaterDO> getWaterPage(GapBaseWaterPageReqVO pageReqVO);

    List<GapBaseWaterDO> getWaterListByBaseId(Long baseId);

    GapBaseWaterDO validateWaterExists(Long id);

}
