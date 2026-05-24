package cn.iocoder.yudao.module.gap.dal.mysql.plot;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.plot.vo.GapPlotPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.plot.GapPlotDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapPlotMapper extends BaseMapperX<GapPlotDO> {

    default PageResult<GapPlotDO> selectPage(GapPlotPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPlotDO>()
                .eqIfPresent(GapPlotDO::getId, reqVO.getId())
                .likeIfPresent(GapPlotDO::getCode, reqVO.getCode())
                .likeIfPresent(GapPlotDO::getName, reqVO.getName())
                .eqIfPresent(GapPlotDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapPlotDO::getArea, reqVO.getArea())
                .likeIfPresent(GapPlotDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(GapPlotDO::getSoilPh, reqVO.getSoilPh())
                .eqIfPresent(GapPlotDO::getElevation, reqVO.getElevation())
                .eqIfPresent(GapPlotDO::getSlope, reqVO.getSlope())
                .likeIfPresent(GapPlotDO::getExposure, reqVO.getExposure())
                .likeIfPresent(GapPlotDO::getPreviousCrop, reqVO.getPreviousCrop())
                .eqIfPresent(GapPlotDO::getCurrentVarietyId, reqVO.getCurrentVarietyId())
                .eqIfPresent(GapPlotDO::getCurrentBatchId, reqVO.getCurrentBatchId())
                .eqIfPresent(GapPlotDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapPlotDO::getGisBoundary, reqVO.getGisBoundary())
                .orderByDesc(GapPlotDO::getId));
    }
    default List<GapPlotDO> selectListByBaseId(Long baseId) {
        return selectList(GapPlotDO::getBaseId, baseId);
    }

    default List<GapPlotDO> selectListByCurrentVarietyId(Long currentVarietyId) {
        return selectList(GapPlotDO::getCurrentVarietyId, currentVarietyId);
    }

    default List<GapPlotDO> selectListByCurrentBatchId(Long currentBatchId) {
        return selectList(GapPlotDO::getCurrentBatchId, currentBatchId);
    }
}
