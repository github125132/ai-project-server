package cn.iocoder.yudao.module.gap.service.environment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.environment.GapBaseEnvironmentDO;
import cn.iocoder.yudao.module.gap.dal.mysql.environment.GapBaseEnvironmentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseEnvironmentServiceImpl implements GapBaseEnvironmentService {

    @Resource
    private GapBaseEnvironmentMapper BaseEnvironmentMapper;

    @Override
    public Long createGapBaseEnvironment(GapBaseEnvironmentSaveReqVO createReqVO) {
        GapBaseEnvironmentDO entity = BeanUtils.toBean(createReqVO, GapBaseEnvironmentDO.class);
        BaseEnvironmentMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapBaseEnvironment(GapBaseEnvironmentSaveReqVO updateReqVO) {
        validateGapBaseEnvironmentExists(updateReqVO.getId());
        GapBaseEnvironmentDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseEnvironmentDO.class);
        BaseEnvironmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapBaseEnvironment(Long id) {
        validateGapBaseEnvironmentExists(id);
        BaseEnvironmentMapper.deleteById(id);
    }

    @Override
    public GapBaseEnvironmentDO getGapBaseEnvironment(Long id) {
        return BaseEnvironmentMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseEnvironmentDO> getGapBaseEnvironmentPage(GapBaseEnvironmentPageReqVO pageReqVO) {
        return BaseEnvironmentMapper.selectPage(pageReqVO);
    }

    @Override
    public GapBaseEnvironmentDO validateGapBaseEnvironmentExists(Long id) {
        GapBaseEnvironmentDO entity = BaseEnvironmentMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
