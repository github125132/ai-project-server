package cn.iocoder.yudao.module.gap.dal.mysql.base.plot;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.plot.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.plot.GapPlotDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapPlotMapper extends BaseMapperX<GapPlotDO> {

    default PageResult<GapPlotDO> selectPage(GapPlotPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPlotDO>()
                .likeIfPresent(GapPlotDO::getCode, reqVO.getCode())
                .likeIfPresent(GapPlotDO::getName, reqVO.getName())
                .eqIfPresent(GapPlotDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapPlotDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapPlotDO::getCurrentVarietyId, reqVO.getCurrentVarietyId())
                .orderByDesc(GapPlotDO::getId));
    }

    default GapPlotDO selectByCode(String code) {
        return selectOne(GapPlotDO::getCode, code);
    }

    default Long selectCountByBaseId(Long baseId) {
        return selectCount(GapPlotDO::getBaseId, baseId);
    }

}
