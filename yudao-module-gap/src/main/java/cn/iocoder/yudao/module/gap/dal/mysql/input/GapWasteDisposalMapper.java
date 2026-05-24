package cn.iocoder.yudao.module.gap.dal.mysql.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapWasteDisposalDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapWasteDisposalMapper extends BaseMapperX<GapWasteDisposalDO> {

    default PageResult<GapWasteDisposalDO> selectPage(GapWasteDisposalPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapWasteDisposalDO>()
                .eqIfPresent(GapWasteDisposalDO::getId, reqVO.getId())
                .likeIfPresent(GapWasteDisposalDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapWasteDisposalDO::getWasteType, reqVO.getWasteType())
                .eqIfPresent(GapWasteDisposalDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapWasteDisposalDO::getSourceRecordId, reqVO.getSourceRecordId())
                .eqIfPresent(GapWasteDisposalDO::getQuantity, reqVO.getQuantity())
                .likeIfPresent(GapWasteDisposalDO::getUnit, reqVO.getUnit())
                .eqIfPresent(GapWasteDisposalDO::getDisposalDate, reqVO.getDisposalDate())
                .likeIfPresent(GapWasteDisposalDO::getDisposalMethod, reqVO.getDisposalMethod())
                .likeIfPresent(GapWasteDisposalDO::getDisposalLocation, reqVO.getDisposalLocation())
                .eqIfPresent(GapWasteDisposalDO::getHandlerId, reqVO.getHandlerId())
                .eqIfPresent(GapWasteDisposalDO::getWitnessId, reqVO.getWitnessId())
                .likeIfPresent(GapWasteDisposalDO::getPhotoUrl, reqVO.getPhotoUrl())
                .eqIfPresent(GapWasteDisposalDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapWasteDisposalDO::getId));
    }
    default List<GapWasteDisposalDO> selectListByBaseId(Long baseId) {
        return selectList(GapWasteDisposalDO::getBaseId, baseId);
    }

    default List<GapWasteDisposalDO> selectListBySourceRecordId(Long sourceRecordId) {
        return selectList(GapWasteDisposalDO::getSourceRecordId, sourceRecordId);
    }

    default List<GapWasteDisposalDO> selectListByHandlerId(Long handlerId) {
        return selectList(GapWasteDisposalDO::getHandlerId, handlerId);
    }

    default List<GapWasteDisposalDO> selectListByWitnessId(Long witnessId) {
        return selectList(GapWasteDisposalDO::getWitnessId, witnessId);
    }
}
