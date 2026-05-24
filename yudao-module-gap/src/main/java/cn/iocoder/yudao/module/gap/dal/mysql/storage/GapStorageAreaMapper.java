package cn.iocoder.yudao.module.gap.dal.mysql.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageAreaDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 仓库分区 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapStorageAreaMapper extends BaseMapperX<GapStorageAreaDO> {

    default PageResult<GapStorageAreaDO> selectPage(GapStorageAreaPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapStorageAreaDO>()
                .eqIfPresent(GapStorageAreaDO::getWarehouseId, reqVO.getWarehouseId())
                .likeIfPresent(GapStorageAreaDO::getCode, reqVO.getCode())
                .likeIfPresent(GapStorageAreaDO::getName, reqVO.getName())
                .eqIfPresent(GapStorageAreaDO::getAreaType, reqVO.getAreaType())
                .eqIfPresent(GapStorageAreaDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapStorageAreaDO::getId));
    }

    default GapStorageAreaDO selectByCode(String code) {
        return selectOne(GapStorageAreaDO::getCode, code);
    }

    default List<GapStorageAreaDO> selectListByWarehouseId(Long warehouseId) {
        return selectList(GapStorageAreaDO::getWarehouseId, warehouseId);
    }

}
