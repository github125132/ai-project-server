package cn.iocoder.yudao.module.gap.service.treatment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.treatment.GapSeedTreatmentDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

public interface GapSeedTreatmentService {

    Long createSeedTreatment(@Valid GapSeedTreatmentSaveReqVO createReqVO);

    void updateSeedTreatment(@Valid GapSeedTreatmentSaveReqVO updateReqVO);

    void deleteSeedTreatment(Long id);

    GapSeedTreatmentDO getSeedTreatment(Long id);

    PageResult<GapSeedTreatmentDO> getSeedTreatmentPage(GapSeedTreatmentPageReqVO pageReqVO);

    List<GapSeedTreatmentDO> getSeedTreatmentList();

    List<GapSeedTreatmentDO> getSeedTreatmentList(Collection<Long> ids);

    List<GapSeedTreatmentDO> getSeedTreatmentListBySeedBatchId(Long seedBatchId);

    GapSeedTreatmentDO validateSeedTreatmentExists(Long id);

}
