package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 施肥记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapFertilizationRecordMapper extends BaseMapperX<GapFertilizationRecordDO> {

    default PageResult<GapFertilizationRecordDO> selectPage(GapFertilizationRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapFertilizationRecordDO>()
                .eqIfPresent(GapFertilizationRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapFertilizationRecordDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapFertilizationRecordDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapFertilizationRecordDO::getPlotBatchNo, reqVO.getPlotBatchNo())
                .eqIfPresent(GapFertilizationRecordDO::getFertilizeType, reqVO.getFertilizeType())
                .eqIfPresent(GapFertilizationRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapFertilizationRecordDO::getFertilizeDate, reqVO.getFertilizeDateStart(), reqVO.getFertilizeDateEnd())
                .orderByDesc(GapFertilizationRecordDO::getId));
    }

    default List<GapFertilizationRecordDO> selectListByBaseId(Long baseId) {
        return selectList(GapFertilizationRecordDO::getBaseId, baseId);
    }

    default List<GapFertilizationRecordDO> selectListByPlotId(Long plotId) {
        return selectList(GapFertilizationRecordDO::getPlotId, plotId);
    }

}
