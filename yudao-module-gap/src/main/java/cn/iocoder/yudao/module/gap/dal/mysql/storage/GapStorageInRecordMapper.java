package cn.iocoder.yudao.module.gap.dal.mysql.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageInRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 药材入库记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapStorageInRecordMapper extends BaseMapperX<GapStorageInRecordDO> {

    default PageResult<GapStorageInRecordDO> selectPage(GapStorageInRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapStorageInRecordDO>()
                .likeIfPresent(GapStorageInRecordDO::getRecordNo, reqVO.getRecordNo())
                .likeIfPresent(GapStorageInRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapStorageInRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapStorageInRecordDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(GapStorageInRecordDO::getAreaId, reqVO.getAreaId())
                .eqIfPresent(GapStorageInRecordDO::getQualityStatus, reqVO.getQualityStatus())
                .eqIfPresent(GapStorageInRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapStorageInRecordDO::getInDate, reqVO.getInDate())
                .orderByDesc(GapStorageInRecordDO::getId));
    }

    default GapStorageInRecordDO selectByRecordNo(String recordNo) {
        return selectOne(GapStorageInRecordDO::getRecordNo, recordNo);
    }

    default List<GapStorageInRecordDO> selectListByWarehouseId(Long warehouseId) {
        return selectList(GapStorageInRecordDO::getWarehouseId, warehouseId);
    }

    default List<GapStorageInRecordDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapStorageInRecordDO::getVarietyId, varietyId);
    }

}
