package cn.iocoder.yudao.module.gap.dal.mysql.harvest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 采收记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapHarvestRecordMapper extends BaseMapperX<GapHarvestRecordDO> {

    default PageResult<GapHarvestRecordDO> selectPage(GapHarvestRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapHarvestRecordDO>()
                .likeIfPresent(GapHarvestRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapHarvestRecordDO::getHarvestPlanId, reqVO.getHarvestPlanId())
                .eqIfPresent(GapHarvestRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapHarvestRecordDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapHarvestRecordDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapHarvestRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapHarvestRecordDO::getStatus, reqVO.getStatus())
                .geIfPresent(GapHarvestRecordDO::getHarvestDate, reqVO.getHarvestDateStart())
                .leIfPresent(GapHarvestRecordDO::getHarvestDate, reqVO.getHarvestDateEnd())
                .orderByDesc(GapHarvestRecordDO::getId));
    }

    default GapHarvestRecordDO selectByRecordNo(String recordNo) {
        return selectOne(GapHarvestRecordDO::getRecordNo, recordNo);
    }

    default GapHarvestRecordDO selectByBatchNo(String batchNo) {
        return selectOne(GapHarvestRecordDO::getBatchNo, batchNo);
    }

    default List<GapHarvestRecordDO> selectListByBaseId(Long baseId) {
        return selectList(GapHarvestRecordDO::getBaseId, baseId);
    }

    default List<GapHarvestRecordDO> selectListByPlotId(Long plotId) {
        return selectList(GapHarvestRecordDO::getPlotId, plotId);
    }

}
