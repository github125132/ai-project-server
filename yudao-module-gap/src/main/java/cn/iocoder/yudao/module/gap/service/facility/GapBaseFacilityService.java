package cn.iocoder.yudao.module.gap.service.facility;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilitySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.facility.GapBaseFacilityDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseFacilityService {

    Long createGapBaseFacility(@Valid GapBaseFacilitySaveReqVO createReqVO);

    void updateGapBaseFacility(@Valid GapBaseFacilitySaveReqVO updateReqVO);

    void deleteGapBaseFacility(Long id);

    GapBaseFacilityDO getGapBaseFacility(Long id);

    PageResult<GapBaseFacilityDO> getGapBaseFacilityPage(GapBaseFacilityPageReqVO pageReqVO);

    GapBaseFacilityDO validateGapBaseFacilityExists(Long id);
}
