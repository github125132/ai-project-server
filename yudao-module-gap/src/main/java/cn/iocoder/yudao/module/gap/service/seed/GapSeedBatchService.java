package cn.iocoder.yudao.module.gap.service.seed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.seed.GapSeedBatchDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

public interface GapSeedBatchService {

    Long createSeedBatch(@Valid GapSeedBatchSaveReqVO createReqVO);

    void updateSeedBatch(@Valid GapSeedBatchSaveReqVO updateReqVO);

    void deleteSeedBatch(Long id);

    GapSeedBatchDO getSeedBatch(Long id);

    PageResult<GapSeedBatchDO> getSeedBatchPage(GapSeedBatchPageReqVO pageReqVO);

    List<GapSeedBatchDO> getSeedBatchList();

    List<GapSeedBatchDO> getSeedBatchList(Collection<Long> ids);

    List<GapSeedBatchDO> getSeedBatchListByVarietyId(Long varietyId);

    GapSeedBatchDO validateSeedBatchExists(Long id);

}
