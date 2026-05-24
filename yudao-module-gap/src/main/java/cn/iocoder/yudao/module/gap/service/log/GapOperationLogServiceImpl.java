package cn.iocoder.yudao.module.gap.service.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapOperationLogDO;
import cn.iocoder.yudao.module.gap.dal.mysql.log.GapOperationLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapOperationLogServiceImpl implements GapOperationLogService {

    @Resource
    private GapOperationLogMapper OperationLogMapper;

    @Override
    public Long createGapOperationLog(GapOperationLogSaveReqVO createReqVO) {
        GapOperationLogDO entity = BeanUtils.toBean(createReqVO, GapOperationLogDO.class);
        OperationLogMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapOperationLog(GapOperationLogSaveReqVO updateReqVO) {
        validateGapOperationLogExists(updateReqVO.getId());
        GapOperationLogDO updateObj = BeanUtils.toBean(updateReqVO, GapOperationLogDO.class);
        OperationLogMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapOperationLog(Long id) {
        validateGapOperationLogExists(id);
        OperationLogMapper.deleteById(id);
    }

    @Override
    public GapOperationLogDO getGapOperationLog(Long id) {
        return OperationLogMapper.selectById(id);
    }

    @Override
    public PageResult<GapOperationLogDO> getGapOperationLogPage(GapOperationLogPageReqVO pageReqVO) {
        return OperationLogMapper.selectPage(pageReqVO);
    }

    @Override
    public GapOperationLogDO validateGapOperationLogExists(Long id) {
        GapOperationLogDO entity = OperationLogMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
