package cn.iocoder.yudao.module.gap.service.trace;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceBatchDO;
import cn.iocoder.yudao.module.gap.dal.mysql.trace.GapTraceBatchMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRACE_BATCH_NOT_EXISTS;

@Service
@Validated
public class GapTraceBatchServiceImpl implements GapTraceBatchService {

    @Resource
    private GapTraceBatchMapper TraceBatchMapper;

    @Override
    public Long createGapTraceBatch(GapTraceBatchSaveReqVO createReqVO) {
        GapTraceBatchDO entity = BeanUtils.toBean(createReqVO, GapTraceBatchDO.class);
        TraceBatchMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapTraceBatch(GapTraceBatchSaveReqVO updateReqVO) {
        validateGapTraceBatchExists(updateReqVO.getId());
        GapTraceBatchDO updateObj = BeanUtils.toBean(updateReqVO, GapTraceBatchDO.class);
        TraceBatchMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapTraceBatch(Long id) {
        validateGapTraceBatchExists(id);
        TraceBatchMapper.deleteById(id);
    }

    @Override
    public GapTraceBatchDO getGapTraceBatch(Long id) {
        return TraceBatchMapper.selectById(id);
    }

    @Override
    public PageResult<GapTraceBatchDO> getGapTraceBatchPage(GapTraceBatchPageReqVO pageReqVO) {
        return TraceBatchMapper.selectPage(pageReqVO);
    }

    @Override
    public GapTraceBatchDO validateGapTraceBatchExists(Long id) {
        GapTraceBatchDO entity = TraceBatchMapper.selectById(id);
        if (entity == null) {
            throw exception(TRACE_BATCH_NOT_EXISTS);
        }
        return entity;
    }
}
