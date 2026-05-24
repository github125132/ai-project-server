package cn.iocoder.yudao.module.gap.dal.mysql.origin;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifyPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.origin.GapOriginIdentifyDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapOriginIdentifyMapper extends BaseMapperX<GapOriginIdentifyDO> {

    default PageResult<GapOriginIdentifyDO> selectPage(GapOriginIdentifyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapOriginIdentifyDO>()
                .likeIfPresent(GapOriginIdentifyDO::getIdentifyNo, reqVO.getIdentifyNo())
                .eqIfPresent(GapOriginIdentifyDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapOriginIdentifyDO::getSeedBatchId, reqVO.getSeedBatchId())
                .eqIfPresent(GapOriginIdentifyDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapOriginIdentifyDO::getId));
    }

    default List<GapOriginIdentifyDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapOriginIdentifyDO::getVarietyId, varietyId);
    }

    default List<GapOriginIdentifyDO> selectListBySeedBatchId(Long seedBatchId) {
        return selectList(GapOriginIdentifyDO::getSeedBatchId, seedBatchId);
    }

}
