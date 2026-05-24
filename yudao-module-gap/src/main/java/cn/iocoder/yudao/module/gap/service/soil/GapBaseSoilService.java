package cn.iocoder.yudao.module.gap.service.soil;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.soil.GapBaseSoilDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseSoilService {

    Long createGapBaseSoil(@Valid GapBaseSoilSaveReqVO createReqVO);

    void updateGapBaseSoil(@Valid GapBaseSoilSaveReqVO updateReqVO);

    void deleteGapBaseSoil(Long id);

    GapBaseSoilDO getGapBaseSoil(Long id);

    PageResult<GapBaseSoilDO> getGapBaseSoilPage(GapBaseSoilPageReqVO pageReqVO);

    GapBaseSoilDO validateGapBaseSoilExists(Long id);
}
