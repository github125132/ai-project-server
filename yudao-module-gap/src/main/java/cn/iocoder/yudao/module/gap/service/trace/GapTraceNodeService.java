package cn.iocoder.yudao.module.gap.service.trace;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodeSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceNodeDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapTraceNodeService {

    Long createGapTraceNode(@Valid GapTraceNodeSaveReqVO createReqVO);

    void updateGapTraceNode(@Valid GapTraceNodeSaveReqVO updateReqVO);

    void deleteGapTraceNode(Long id);

    GapTraceNodeDO getGapTraceNode(Long id);

    PageResult<GapTraceNodeDO> getGapTraceNodePage(GapTraceNodePageReqVO pageReqVO);

    GapTraceNodeDO validateGapTraceNodeExists(Long id);
}
