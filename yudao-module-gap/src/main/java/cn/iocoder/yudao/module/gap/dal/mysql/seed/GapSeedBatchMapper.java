package cn.iocoder.yudao.module.gap.dal.mysql.seed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.seed.GapSeedBatchDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapSeedBatchMapper extends BaseMapperX<GapSeedBatchDO> {

    default PageResult<GapSeedBatchDO> selectPage(GapSeedBatchPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapSeedBatchDO>()
                .likeIfPresent(GapSeedBatchDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapSeedBatchDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapSeedBatchDO::getSeedType, reqVO.getSeedType())
                .eqIfPresent(GapSeedBatchDO::getSourceType, reqVO.getSourceType())
                .eqIfPresent(GapSeedBatchDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapSeedBatchDO::getId));
    }

    default GapSeedBatchDO selectByBatchNo(String batchNo) {
        return selectOne(GapSeedBatchDO::getBatchNo, batchNo);
    }

    default List<GapSeedBatchDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapSeedBatchDO::getVarietyId, varietyId);
    }

}
