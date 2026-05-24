package cn.iocoder.yudao.module.gap.dal.mysql.treatment;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.treatment.GapSeedTreatmentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapSeedTreatmentMapper extends BaseMapperX<GapSeedTreatmentDO> {

    default PageResult<GapSeedTreatmentDO> selectPage(GapSeedTreatmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapSeedTreatmentDO>()
                .eqIfPresent(GapSeedTreatmentDO::getSeedBatchId, reqVO.getSeedBatchId())
                .eqIfPresent(GapSeedTreatmentDO::getTreatmentType, reqVO.getTreatmentType())
                .eqIfPresent(GapSeedTreatmentDO::getStatus, reqVO.getStatus())
                .geIfPresent(GapSeedTreatmentDO::getTreatmentDate, reqVO.getTreatmentDateBegin())
                .leIfPresent(GapSeedTreatmentDO::getTreatmentDate, reqVO.getTreatmentDateEnd())
                .orderByDesc(GapSeedTreatmentDO::getId));
    }

    default List<GapSeedTreatmentDO> selectListBySeedBatchId(Long seedBatchId) {
        return selectList(GapSeedTreatmentDO::getSeedBatchId, seedBatchId);
    }

}
