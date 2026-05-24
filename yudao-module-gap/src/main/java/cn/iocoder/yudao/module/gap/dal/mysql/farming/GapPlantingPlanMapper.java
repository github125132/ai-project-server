package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPlantingPlanDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 种植计划 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapPlantingPlanMapper extends BaseMapperX<GapPlantingPlanDO> {

    default PageResult<GapPlantingPlanDO> selectPage(GapPlantingPlanPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPlantingPlanDO>()
                .eqIfPresent(GapPlantingPlanDO::getPlanNo, reqVO.getPlanNo())
                .eqIfPresent(GapPlantingPlanDO::getYear, reqVO.getYear())
                .eqIfPresent(GapPlantingPlanDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapPlantingPlanDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapPlantingPlanDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapPlantingPlanDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapPlantingPlanDO::getId));
    }

    default List<GapPlantingPlanDO> selectListByBaseId(Long baseId) {
        return selectList(GapPlantingPlanDO::getBaseId, baseId);
    }

    default List<GapPlantingPlanDO> selectListByPlotId(Long plotId) {
        return selectList(GapPlantingPlanDO::getPlotId, plotId);
    }

}
