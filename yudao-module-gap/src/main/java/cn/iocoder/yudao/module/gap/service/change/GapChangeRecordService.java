package cn.iocoder.yudao.module.gap.service.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapChangeRecordDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapChangeRecordService {

    Long createGapChangeRecord(@Valid GapChangeRecordSaveReqVO createReqVO);

    void updateGapChangeRecord(@Valid GapChangeRecordSaveReqVO updateReqVO);

    void deleteGapChangeRecord(Long id);

    GapChangeRecordDO getGapChangeRecord(Long id);

    PageResult<GapChangeRecordDO> getGapChangeRecordPage(GapChangeRecordPageReqVO pageReqVO);

    GapChangeRecordDO validateGapChangeRecordExists(Long id);
}
