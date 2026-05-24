package cn.iocoder.yudao.module.gap.service.origin;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifyPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.origin.GapOriginIdentifyDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

public interface GapOriginIdentifyService {

    Long createOriginIdentify(@Valid GapOriginIdentifySaveReqVO createReqVO);

    void updateOriginIdentify(@Valid GapOriginIdentifySaveReqVO updateReqVO);

    void deleteOriginIdentify(Long id);

    GapOriginIdentifyDO getOriginIdentify(Long id);

    PageResult<GapOriginIdentifyDO> getOriginIdentifyPage(GapOriginIdentifyPageReqVO pageReqVO);

    List<GapOriginIdentifyDO> getOriginIdentifyList();

    List<GapOriginIdentifyDO> getOriginIdentifyList(Collection<Long> ids);

    List<GapOriginIdentifyDO> getOriginIdentifyListByVarietyId(Long varietyId);

    List<GapOriginIdentifyDO> getOriginIdentifyListBySeedBatchId(Long seedBatchId);

    GapOriginIdentifyDO validateOriginIdentifyExists(Long id);

}
