package cn.iocoder.yudao.module.gap.dal.mysql.harvest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestPlanDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 采收计划 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapHarvestPlanMapper extends BaseMapperX<GapHarvestPlanDO> {

    default PageResult<GapHarvestPlanDO> selectPage(GapHarvestPlanPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapHarvestPlanDO>()
                .likeIfPresent(GapHarvestPlanDO::getPlanNo, reqVO.getPlanNo())
                .eqIfPresent(GapHarvestPlanDO::getPlantingPlanId, reqVO.getPlantingPlanId())
                .eqIfPresent(GapHarvestPlanDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapHarvestPlanDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapHarvestPlanDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapHarvestPlanDO::getPlotBatchNo, reqVO.getPlotBatchNo())
                .eqIfPresent(GapHarvestPlanDO::getStatus, reqVO.getStatus())
                .geIfPresent(GapHarvestPlanDO::getPlannedHarvestDate, reqVO.getPlannedHarvestDateStart())
                .leIfPresent(GapHarvestPlanDO::getPlannedHarvestDate, reqVO.getPlannedHarvestDateEnd())
                .orderByDesc(GapHarvestPlanDO::getId));
    }

    default GapHarvestPlanDO selectByPlanNo(String planNo) {
        return selectOne(GapHarvestPlanDO::getPlanNo, planNo);
    }

    default List<GapHarvestPlanDO> selectListByBaseId(Long baseId) {
        return selectList(GapHarvestPlanDO::getBaseId, baseId);
    }

    default List<GapHarvestPlanDO> selectListByPlotId(Long plotId) {
        return selectList(GapHarvestPlanDO::getPlotId, plotId);
    }

}
