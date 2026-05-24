package cn.iocoder.yudao.module.gap.dal.mysql.trace;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceBatchDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 溯源批次 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTraceBatchMapper extends BaseMapperX<GapTraceBatchDO> {

    default PageResult<GapTraceBatchDO> selectPage(GapTraceBatchPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTraceBatchDO>()
                .eqIfPresent(GapTraceBatchDO::getTraceCode, reqVO.getTraceCode())
                .eqIfPresent(GapTraceBatchDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapTraceBatchDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapTraceBatchDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapTraceBatchDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapTraceBatchDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapTraceBatchDO::getQualityStatus, reqVO.getQualityStatus())
                .betweenIfPresent(GapTraceBatchDO::getPlantingDate, reqVO.getPlantingDate())
                .betweenIfPresent(GapTraceBatchDO::getHarvestDate, reqVO.getHarvestDate())
                .betweenIfPresent(GapTraceBatchDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GapTraceBatchDO::getId));
    }

    default GapTraceBatchDO selectByTraceCode(String traceCode) {
        return selectOne(GapTraceBatchDO::getTraceCode, traceCode);
    }

    default List<GapTraceBatchDO> selectListByBaseId(Long baseId) {
        return selectList(GapTraceBatchDO::getBaseId, baseId);
    }

    default List<GapTraceBatchDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapTraceBatchDO::getVarietyId, varietyId);
    }

}
