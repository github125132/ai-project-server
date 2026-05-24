package cn.iocoder.yudao.module.gap.dal.mysql.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageOutRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 药材出库记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapStorageOutRecordMapper extends BaseMapperX<GapStorageOutRecordDO> {

    default PageResult<GapStorageOutRecordDO> selectPage(GapStorageOutRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapStorageOutRecordDO>()
                .likeIfPresent(GapStorageOutRecordDO::getRecordNo, reqVO.getRecordNo())
                .likeIfPresent(GapStorageOutRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapStorageOutRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapStorageOutRecordDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(GapStorageOutRecordDO::getAreaId, reqVO.getAreaId())
                .eqIfPresent(GapStorageOutRecordDO::getOutType, reqVO.getOutType())
                .eqIfPresent(GapStorageOutRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapStorageOutRecordDO::getOutDate, reqVO.getOutDate())
                .orderByDesc(GapStorageOutRecordDO::getId));
    }

    default GapStorageOutRecordDO selectByRecordNo(String recordNo) {
        return selectOne(GapStorageOutRecordDO::getRecordNo, recordNo);
    }

    default List<GapStorageOutRecordDO> selectListByWarehouseId(Long warehouseId) {
        return selectList(GapStorageOutRecordDO::getWarehouseId, warehouseId);
    }

}
