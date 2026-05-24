package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationDetailDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 施肥明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapFertilizationDetailMapper extends BaseMapperX<GapFertilizationDetailDO> {

    default PageResult<GapFertilizationDetailDO> selectPage(GapFertilizationDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapFertilizationDetailDO>()
                .eqIfPresent(GapFertilizationDetailDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(GapFertilizationDetailDO::getProductId, reqVO.getProductId())
                .likeIfPresent(GapFertilizationDetailDO::getProductName, reqVO.getProductName())
                .orderByAsc(GapFertilizationDetailDO::getSort)
                .orderByDesc(GapFertilizationDetailDO::getId));
    }

    default List<GapFertilizationDetailDO> selectListByRecordId(Long recordId) {
        return selectList(GapFertilizationDetailDO::getRecordId, recordId);
    }

}
