package cn.iocoder.yudao.module.gap.service.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataChangeLogDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapDataChangeLogService {

    Long createGapDataChangeLog(@Valid GapDataChangeLogSaveReqVO createReqVO);

    void updateGapDataChangeLog(@Valid GapDataChangeLogSaveReqVO updateReqVO);

    void deleteGapDataChangeLog(Long id);

    GapDataChangeLogDO getGapDataChangeLog(Long id);

    PageResult<GapDataChangeLogDO> getGapDataChangeLogPage(GapDataChangeLogPageReqVO pageReqVO);

    GapDataChangeLogDO validateGapDataChangeLogExists(Long id);
}
