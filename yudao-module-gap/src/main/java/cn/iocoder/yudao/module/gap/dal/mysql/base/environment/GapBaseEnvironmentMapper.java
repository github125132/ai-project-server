package cn.iocoder.yudao.module.gap.dal.mysql.base.environment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.environment.GapBaseEnvironmentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapBaseEnvironmentMapper extends BaseMapperX<GapBaseEnvironmentDO> {

    default PageResult<GapBaseEnvironmentDO> selectPage(GapBaseEnvironmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseEnvironmentDO>()
                .eqIfPresent(GapBaseEnvironmentDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseEnvironmentDO::getAssessResult, reqVO.getAssessResult())
                .betweenIfPresent(GapBaseEnvironmentDO::getAssessDate, reqVO.getAssessDateStart(), reqVO.getAssessDateEnd())
                .orderByDesc(GapBaseEnvironmentDO::getId));
    }

    default GapBaseEnvironmentDO selectByBaseId(Long baseId) {
        return selectOne(GapBaseEnvironmentDO::getBaseId, baseId);
    }

}
