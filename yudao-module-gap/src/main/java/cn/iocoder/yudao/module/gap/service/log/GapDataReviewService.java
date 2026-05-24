package cn.iocoder.yudao.module.gap.service.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataReviewDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapDataReviewService {

    Long createGapDataReview(@Valid GapDataReviewSaveReqVO createReqVO);

    void updateGapDataReview(@Valid GapDataReviewSaveReqVO updateReqVO);

    void deleteGapDataReview(Long id);

    GapDataReviewDO getGapDataReview(Long id);

    PageResult<GapDataReviewDO> getGapDataReviewPage(GapDataReviewPageReqVO pageReqVO);

    GapDataReviewDO validateGapDataReviewExists(Long id);
}
