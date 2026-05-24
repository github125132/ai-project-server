package cn.iocoder.yudao.module.gap.service.trace;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodeSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceNodeDO;
import cn.iocoder.yudao.module.gap.dal.mysql.trace.GapTraceNodeMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRACE_BATCH_NOT_EXISTS;

@Service
@Validated
public class GapTraceNodeServiceImpl implements GapTraceNodeService {

    @Resource
    private GapTraceNodeMapper TraceNodeMapper;

    @Override
    public Long createGapTraceNode(GapTraceNodeSaveReqVO createReqVO) {
        GapTraceNodeDO entity = BeanUtils.toBean(createReqVO, GapTraceNodeDO.class);
        TraceNodeMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapTraceNode(GapTraceNodeSaveReqVO updateReqVO) {
        validateGapTraceNodeExists(updateReqVO.getId());
        GapTraceNodeDO updateObj = BeanUtils.toBean(updateReqVO, GapTraceNodeDO.class);
        TraceNodeMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapTraceNode(Long id) {
        validateGapTraceNodeExists(id);
        TraceNodeMapper.deleteById(id);
    }

    @Override
    public GapTraceNodeDO getGapTraceNode(Long id) {
        return TraceNodeMapper.selectById(id);
    }

    @Override
    public PageResult<GapTraceNodeDO> getGapTraceNodePage(GapTraceNodePageReqVO pageReqVO) {
        return TraceNodeMapper.selectPage(pageReqVO);
    }

    @Override
    public GapTraceNodeDO validateGapTraceNodeExists(Long id) {
        GapTraceNodeDO entity = TraceNodeMapper.selectById(id);
        if (entity == null) {
            throw exception(TRACE_BATCH_NOT_EXISTS);
        }
        return entity;
    }
}
