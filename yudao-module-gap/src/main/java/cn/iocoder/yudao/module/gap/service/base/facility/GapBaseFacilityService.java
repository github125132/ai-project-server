package cn.iocoder.yudao.module.gap.service.base.facility;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilitySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.facility.GapBaseFacilityDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseFacilityService {

    Long createFacility(@Valid GapBaseFacilitySaveReqVO createReqVO);

    void updateFacility(@Valid GapBaseFacilitySaveReqVO updateReqVO);

    void deleteFacility(Long id);

    GapBaseFacilityDO getFacility(Long id);

    PageResult<GapBaseFacilityDO> getFacilityPage(GapBaseFacilityPageReqVO pageReqVO);

    List<GapBaseFacilityDO> getFacilityListByBaseId(Long baseId);

    GapBaseFacilityDO validateFacilityExists(Long id);

}
