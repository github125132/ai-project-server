package cn.iocoder.yudao.module.gap.service.trace;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceBatchDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapTraceBatchService {

    Long createGapTraceBatch(@Valid GapTraceBatchSaveReqVO createReqVO);

    void updateGapTraceBatch(@Valid GapTraceBatchSaveReqVO updateReqVO);

    void deleteGapTraceBatch(Long id);

    GapTraceBatchDO getGapTraceBatch(Long id);

    PageResult<GapTraceBatchDO> getGapTraceBatchPage(GapTraceBatchPageReqVO pageReqVO);

    GapTraceBatchDO validateGapTraceBatchExists(Long id);
}
