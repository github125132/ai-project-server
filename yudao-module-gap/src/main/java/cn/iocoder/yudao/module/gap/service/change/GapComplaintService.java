package cn.iocoder.yudao.module.gap.service.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapComplaintDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapComplaintService {

    Long createGapComplaint(@Valid GapComplaintSaveReqVO createReqVO);

    void updateGapComplaint(@Valid GapComplaintSaveReqVO updateReqVO);

    void deleteGapComplaint(Long id);

    GapComplaintDO getGapComplaint(Long id);

    PageResult<GapComplaintDO> getGapComplaintPage(GapComplaintPageReqVO pageReqVO);

    GapComplaintDO validateGapComplaintExists(Long id);
}
