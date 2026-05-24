package cn.iocoder.yudao.module.gap.dal.mysql.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageCheckDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 养护检查记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapStorageCheckMapper extends BaseMapperX<GapStorageCheckDO> {

    default PageResult<GapStorageCheckDO> selectPage(GapStorageCheckPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapStorageCheckDO>()
                .likeIfPresent(GapStorageCheckDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapStorageCheckDO::getWarehouseId, reqVO.getWarehouseId())
                .eqIfPresent(GapStorageCheckDO::getAreaId, reqVO.getAreaId())
                .eqIfPresent(GapStorageCheckDO::getCheckType, reqVO.getCheckType())
                .eqIfPresent(GapStorageCheckDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapStorageCheckDO::getCheckDate, reqVO.getCheckDate())
                .orderByDesc(GapStorageCheckDO::getId));
    }

    default List<GapStorageCheckDO> selectListByWarehouseId(Long warehouseId) {
        return selectList(GapStorageCheckDO::getWarehouseId, warehouseId);
    }

}
