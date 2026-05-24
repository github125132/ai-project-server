package cn.iocoder.yudao.module.gap.dal.mysql.base.planting;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.planting.GapPlotPlantingPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.planting.GapPlotPlantingDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapPlotPlantingMapper extends BaseMapperX<GapPlotPlantingDO> {

    default PageResult<GapPlotPlantingDO> selectPage(GapPlotPlantingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPlotPlantingDO>()
                .eqIfPresent(GapPlotPlantingDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapPlotPlantingDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapPlotPlantingDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapPlotPlantingDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapPlotPlantingDO::getBatchNo, reqVO.getBatchNo())
                .betweenIfPresent(GapPlotPlantingDO::getPlantingDate, reqVO.getPlantingDateStart(), reqVO.getPlantingDateEnd())
                .orderByDesc(GapPlotPlantingDO::getId));
    }

}
