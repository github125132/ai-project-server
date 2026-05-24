package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 农事记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapFarmingRecordMapper extends BaseMapperX<GapFarmingRecordDO> {

    default PageResult<GapFarmingRecordDO> selectPage(GapFarmingRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapFarmingRecordDO>()
                .eqIfPresent(GapFarmingRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapFarmingRecordDO::getRecordType, reqVO.getRecordType())
                .eqIfPresent(GapFarmingRecordDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapFarmingRecordDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapFarmingRecordDO::getPlotBatchNo, reqVO.getPlotBatchNo())
                .eqIfPresent(GapFarmingRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapFarmingRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapFarmingRecordDO::getOperateDate, reqVO.getOperateDateStart(), reqVO.getOperateDateEnd())
                .orderByDesc(GapFarmingRecordDO::getId));
    }

    default List<GapFarmingRecordDO> selectListByBaseId(Long baseId) {
        return selectList(GapFarmingRecordDO::getBaseId, baseId);
    }

    default List<GapFarmingRecordDO> selectListByPlotId(Long plotId) {
        return selectList(GapFarmingRecordDO::getPlotId, plotId);
    }

}
