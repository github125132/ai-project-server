package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapWasteDisposalDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapWasteDisposalService {

    Long createGapWasteDisposal(@Valid GapWasteDisposalSaveReqVO createReqVO);

    void updateGapWasteDisposal(@Valid GapWasteDisposalSaveReqVO updateReqVO);

    void deleteGapWasteDisposal(Long id);

    GapWasteDisposalDO getGapWasteDisposal(Long id);

    PageResult<GapWasteDisposalDO> getGapWasteDisposalPage(GapWasteDisposalPageReqVO pageReqVO);

    GapWasteDisposalDO validateGapWasteDisposalExists(Long id);
}
