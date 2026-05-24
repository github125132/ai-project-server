package cn.iocoder.yudao.module.gap.service.base.soil;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.soil.GapBaseSoilDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseSoilService {

    Long createSoil(@Valid GapBaseSoilSaveReqVO createReqVO);

    void updateSoil(@Valid GapBaseSoilSaveReqVO updateReqVO);

    void deleteSoil(Long id);

    GapBaseSoilDO getSoil(Long id);

    PageResult<GapBaseSoilDO> getSoilPage(GapBaseSoilPageReqVO pageReqVO);

    List<GapBaseSoilDO> getSoilListByBaseId(Long baseId);

    List<GapBaseSoilDO> getSoilListByPlotId(Long plotId);

    GapBaseSoilDO validateSoilExists(Long id);

}
