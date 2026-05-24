package cn.iocoder.yudao.module.gap.service.base.environment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.environment.GapBaseEnvironmentDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.environment.GapBaseEnvironmentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;

@Service
@Validated
public class GapBaseEnvironmentServiceImpl implements GapBaseEnvironmentService {

    @Resource
    private GapBaseEnvironmentMapper environmentMapper;

    @Override
    public Long createEnvironment(GapBaseEnvironmentSaveReqVO createReqVO) {
        GapBaseEnvironmentDO env = BeanUtils.toBean(createReqVO, GapBaseEnvironmentDO.class);
        environmentMapper.insert(env);
        return env.getId();
    }

    @Override
    public void updateEnvironment(GapBaseEnvironmentSaveReqVO updateReqVO) {
        validateEnvironmentExists(updateReqVO.getId());
        GapBaseEnvironmentDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseEnvironmentDO.class);
        environmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteEnvironment(Long id) {
        validateEnvironmentExists(id);
        environmentMapper.deleteById(id);
    }

    @Override
    public GapBaseEnvironmentDO getEnvironment(Long id) {
        return environmentMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseEnvironmentDO> getEnvironmentPage(GapBaseEnvironmentPageReqVO pageReqVO) {
        return environmentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapBaseEnvironmentDO> getEnvironmentListByBaseId(Long baseId) {
        return environmentMapper.selectList(GapBaseEnvironmentDO::getBaseId, baseId);
    }

    @Override
    public GapBaseEnvironmentDO validateEnvironmentExists(Long id) {
        GapBaseEnvironmentDO env = environmentMapper.selectById(id);
        if (env == null) {
            throw exception(cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS);
        }
        return env;
    }

}
