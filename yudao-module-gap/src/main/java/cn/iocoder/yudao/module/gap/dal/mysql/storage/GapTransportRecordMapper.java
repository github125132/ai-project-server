package cn.iocoder.yudao.module.gap.dal.mysql.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapTransportRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 运输记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTransportRecordMapper extends BaseMapperX<GapTransportRecordDO> {

    default PageResult<GapTransportRecordDO> selectPage(GapTransportRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTransportRecordDO>()
                .likeIfPresent(GapTransportRecordDO::getTransportNo, reqVO.getTransportNo())
                .likeIfPresent(GapTransportRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapTransportRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapTransportRecordDO::getOutRecordId, reqVO.getOutRecordId())
                .eqIfPresent(GapTransportRecordDO::getVehicleNo, reqVO.getVehicleNo())
                .eqIfPresent(GapTransportRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapTransportRecordDO::getTransportStartTime, reqVO.getTransportStartTime())
                .orderByDesc(GapTransportRecordDO::getId));
    }

    default GapTransportRecordDO selectByTransportNo(String transportNo) {
        return selectOne(GapTransportRecordDO::getTransportNo, transportNo);
    }

    default List<GapTransportRecordDO> selectListByBatchNo(String batchNo) {
        return selectList(GapTransportRecordDO::getBatchNo, batchNo);
    }

}
