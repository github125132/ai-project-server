package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapIrrigationRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 灌溉记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapIrrigationRecordMapper extends BaseMapperX<GapIrrigationRecordDO> {

    default PageResult<GapIrrigationRecordDO> selectPage(GapIrrigationRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapIrrigationRecordDO>()
                .eqIfPresent(GapIrrigationRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapIrrigationRecordDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapIrrigationRecordDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapIrrigationRecordDO::getPlotBatchNo, reqVO.getPlotBatchNo())
                .eqIfPresent(GapIrrigationRecordDO::getIrrigateMethod, reqVO.getIrrigateMethod())
                .eqIfPresent(GapIrrigationRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapIrrigationRecordDO::getIrrigateDate, reqVO.getIrrigateDateStart(), reqVO.getIrrigateDateEnd())
                .orderByDesc(GapIrrigationRecordDO::getId));
    }

    default List<GapIrrigationRecordDO> selectListByBaseId(Long baseId) {
        return selectList(GapIrrigationRecordDO::getBaseId, baseId);
    }

    default List<GapIrrigationRecordDO> selectListByPlotId(Long plotId) {
        return selectList(GapIrrigationRecordDO::getPlotId, plotId);
    }

}
