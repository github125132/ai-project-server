package cn.iocoder.yudao.module.gap.service.environment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.environment.GapBaseEnvironmentDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseEnvironmentService {

    Long createGapBaseEnvironment(@Valid GapBaseEnvironmentSaveReqVO createReqVO);

    void updateGapBaseEnvironment(@Valid GapBaseEnvironmentSaveReqVO updateReqVO);

    void deleteGapBaseEnvironment(Long id);

    GapBaseEnvironmentDO getGapBaseEnvironment(Long id);

    PageResult<GapBaseEnvironmentDO> getGapBaseEnvironmentPage(GapBaseEnvironmentPageReqVO pageReqVO);

    GapBaseEnvironmentDO validateGapBaseEnvironmentExists(Long id);
}
