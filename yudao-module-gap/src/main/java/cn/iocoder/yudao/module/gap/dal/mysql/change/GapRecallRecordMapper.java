package cn.iocoder.yudao.module.gap.dal.mysql.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapRecallRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 召回记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapRecallRecordMapper extends BaseMapperX<GapRecallRecordDO> {

    default PageResult<GapRecallRecordDO> selectPage(GapRecallRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapRecallRecordDO>()
                .likeIfPresent(GapRecallRecordDO::getRecallNo, reqVO.getRecallNo())
                .eqIfPresent(GapRecallRecordDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapRecallRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapRecallRecordDO::getVarietyId, reqVO.getVarietyId())
                .betweenIfPresent(GapRecallRecordDO::getRecallDate, reqVO.getRecallDate())
                .betweenIfPresent(GapRecallRecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GapRecallRecordDO::getId));
    }

    default GapRecallRecordDO selectByRecallNo(String recallNo) {
        return selectOne(GapRecallRecordDO::getRecallNo, recallNo);
    }

    default List<GapRecallRecordDO> selectListByBatchNo(String batchNo) {
        return selectList(GapRecallRecordDO::getBatchNo, batchNo);
    }

}
