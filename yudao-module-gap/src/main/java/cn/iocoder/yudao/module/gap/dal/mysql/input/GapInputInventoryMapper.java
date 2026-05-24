package cn.iocoder.yudao.module.gap.dal.mysql.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventoryPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputInventoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 投入品库存 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInputInventoryMapper extends BaseMapperX<GapInputInventoryDO> {

    default PageResult<GapInputInventoryDO> selectPage(GapInputInventoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInputInventoryDO>()
                .eqIfPresent(GapInputInventoryDO::getProductId, reqVO.getProductId())
                .likeIfPresent(GapInputInventoryDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapInputInventoryDO::getSupplierId, reqVO.getSupplierId())
                .eqIfPresent(GapInputInventoryDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInputInventoryDO::getId));
    }

    default List<GapInputInventoryDO> selectListByProductId(Long productId) {
        return selectList(GapInputInventoryDO::getProductId, productId);
    }

    default GapInputInventoryDO selectByBatchNo(String batchNo) {
        return selectOne(GapInputInventoryDO::getBatchNo, batchNo);
    }

}
