package cn.iocoder.yudao.module.gap.service.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapRecallRecordDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapRecallRecordService {

    Long createGapRecallRecord(@Valid GapRecallRecordSaveReqVO createReqVO);

    void updateGapRecallRecord(@Valid GapRecallRecordSaveReqVO updateReqVO);

    void deleteGapRecallRecord(Long id);

    GapRecallRecordDO getGapRecallRecord(Long id);

    PageResult<GapRecallRecordDO> getGapRecallRecordPage(GapRecallRecordPageReqVO pageReqVO);

    GapRecallRecordDO validateGapRecallRecordExists(Long id);
}
