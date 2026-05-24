package cn.iocoder.yudao.module.gap.dal.mysql.planting;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.planting.vo.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.planting.GapPlotPlantingDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapPlotPlantingMapper extends BaseMapperX<GapPlotPlantingDO> {

    default PageResult<GapPlotPlantingDO> selectPage(GapPlotPlantingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPlotPlantingDO>()
                .eqIfPresent(GapPlotPlantingDO::getId, reqVO.getId())
                .eqIfPresent(GapPlotPlantingDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapPlotPlantingDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapPlotPlantingDO::getVarietyId, reqVO.getVarietyId())
                .likeIfPresent(GapPlotPlantingDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapPlotPlantingDO::getPlantingDate, reqVO.getPlantingDate())
                .eqIfPresent(GapPlotPlantingDO::getHarvestDate, reqVO.getHarvestDate())
                .eqIfPresent(GapPlotPlantingDO::getArea, reqVO.getArea())
                .likeIfPresent(GapPlotPlantingDO::getPlantingDensity, reqVO.getPlantingDensity())
                .likeIfPresent(GapPlotPlantingDO::getPlantingMethod, reqVO.getPlantingMethod())
                .eqIfPresent(GapPlotPlantingDO::getYieldEstimate, reqVO.getYieldEstimate())
                .eqIfPresent(GapPlotPlantingDO::getYieldActual, reqVO.getYieldActual())
                .eqIfPresent(GapPlotPlantingDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapPlotPlantingDO::getId));
    }
    default List<GapPlotPlantingDO> selectListByPlotId(Long plotId) {
        return selectList(GapPlotPlantingDO::getPlotId, plotId);
    }

    default List<GapPlotPlantingDO> selectListByBaseId(Long baseId) {
        return selectList(GapPlotPlantingDO::getBaseId, baseId);
    }

    default List<GapPlotPlantingDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapPlotPlantingDO::getVarietyId, varietyId);
    }
}
