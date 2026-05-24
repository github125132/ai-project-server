package cn.iocoder.yudao.module.gap.service.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataChangeLogDO;
import cn.iocoder.yudao.module.gap.dal.mysql.log.GapDataChangeLogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapDataChangeLogServiceImpl implements GapDataChangeLogService {

    @Resource
    private GapDataChangeLogMapper DataChangeLogMapper;

    @Override
    public Long createGapDataChangeLog(GapDataChangeLogSaveReqVO createReqVO) {
        GapDataChangeLogDO entity = BeanUtils.toBean(createReqVO, GapDataChangeLogDO.class);
        DataChangeLogMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapDataChangeLog(GapDataChangeLogSaveReqVO updateReqVO) {
        validateGapDataChangeLogExists(updateReqVO.getId());
        GapDataChangeLogDO updateObj = BeanUtils.toBean(updateReqVO, GapDataChangeLogDO.class);
        DataChangeLogMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapDataChangeLog(Long id) {
        validateGapDataChangeLogExists(id);
        DataChangeLogMapper.deleteById(id);
    }

    @Override
    public GapDataChangeLogDO getGapDataChangeLog(Long id) {
        return DataChangeLogMapper.selectById(id);
    }

    @Override
    public PageResult<GapDataChangeLogDO> getGapDataChangeLogPage(GapDataChangeLogPageReqVO pageReqVO) {
        return DataChangeLogMapper.selectPage(pageReqVO);
    }

    @Override
    public GapDataChangeLogDO validateGapDataChangeLogExists(Long id) {
        GapDataChangeLogDO entity = DataChangeLogMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
