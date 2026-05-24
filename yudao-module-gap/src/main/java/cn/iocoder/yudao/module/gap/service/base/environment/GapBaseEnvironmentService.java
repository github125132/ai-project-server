package cn.iocoder.yudao.module.gap.service.base.environment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.environment.GapBaseEnvironmentDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseEnvironmentService {

    Long createEnvironment(@Valid GapBaseEnvironmentSaveReqVO createReqVO);

    void updateEnvironment(@Valid GapBaseEnvironmentSaveReqVO updateReqVO);

    void deleteEnvironment(Long id);

    GapBaseEnvironmentDO getEnvironment(Long id);

    PageResult<GapBaseEnvironmentDO> getEnvironmentPage(GapBaseEnvironmentPageReqVO pageReqVO);

    List<GapBaseEnvironmentDO> getEnvironmentListByBaseId(Long baseId);

    GapBaseEnvironmentDO validateEnvironmentExists(Long id);

}
