package cn.iocoder.yudao.module.gap.dal.mysql.environment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.environment.GapBaseEnvironmentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapBaseEnvironmentMapper extends BaseMapperX<GapBaseEnvironmentDO> {

    default PageResult<GapBaseEnvironmentDO> selectPage(GapBaseEnvironmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseEnvironmentDO>()
                .eqIfPresent(GapBaseEnvironmentDO::getId, reqVO.getId())
                .eqIfPresent(GapBaseEnvironmentDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseEnvironmentDO::getAssessDate, reqVO.getAssessDate())
                .likeIfPresent(GapBaseEnvironmentDO::getAssessOrg, reqVO.getAssessOrg())
                .likeIfPresent(GapBaseEnvironmentDO::getAssessPerson, reqVO.getAssessPerson())
                .likeIfPresent(GapBaseEnvironmentDO::getSurroundings, reqVO.getSurroundings())
                .likeIfPresent(GapBaseEnvironmentDO::getPollutionSource, reqVO.getPollutionSource())
                .likeIfPresent(GapBaseEnvironmentDO::getAirQuality, reqVO.getAirQuality())
                .likeIfPresent(GapBaseEnvironmentDO::getNoiseLevel, reqVO.getNoiseLevel())
                .eqIfPresent(GapBaseEnvironmentDO::getAssessResult, reqVO.getAssessResult())
                .likeIfPresent(GapBaseEnvironmentDO::getReportUrl, reqVO.getReportUrl())
                .eqIfPresent(GapBaseEnvironmentDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapBaseEnvironmentDO::getId));
    }
    default List<GapBaseEnvironmentDO> selectListByBaseId(Long baseId) {
        return selectList(GapBaseEnvironmentDO::getBaseId, baseId);
    }
}
