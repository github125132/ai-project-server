package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingDetailDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 农事记录明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapFarmingDetailMapper extends BaseMapperX<GapFarmingDetailDO> {

    default PageResult<GapFarmingDetailDO> selectPage(GapFarmingDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapFarmingDetailDO>()
                .eqIfPresent(GapFarmingDetailDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(GapFarmingDetailDO::getDetailType, reqVO.getDetailType())
                .likeIfPresent(GapFarmingDetailDO::getItemName, reqVO.getItemName())
                .orderByAsc(GapFarmingDetailDO::getSort)
                .orderByDesc(GapFarmingDetailDO::getId));
    }

    default List<GapFarmingDetailDO> selectListByRecordId(Long recordId) {
        return selectList(GapFarmingDetailDO::getRecordId, recordId);
    }

}
