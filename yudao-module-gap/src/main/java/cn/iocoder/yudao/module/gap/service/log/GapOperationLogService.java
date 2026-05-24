package cn.iocoder.yudao.module.gap.service.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapOperationLogDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapOperationLogService {

    Long createGapOperationLog(@Valid GapOperationLogSaveReqVO createReqVO);

    void updateGapOperationLog(@Valid GapOperationLogSaveReqVO updateReqVO);

    void deleteGapOperationLog(Long id);

    GapOperationLogDO getGapOperationLog(Long id);

    PageResult<GapOperationLogDO> getGapOperationLogPage(GapOperationLogPageReqVO pageReqVO);

    GapOperationLogDO validateGapOperationLogExists(Long id);
}
