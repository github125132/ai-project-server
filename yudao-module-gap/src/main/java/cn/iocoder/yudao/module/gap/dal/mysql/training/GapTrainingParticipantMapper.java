package cn.iocoder.yudao.module.gap.dal.mysql.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingParticipantDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 培训参训人员 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTrainingParticipantMapper extends BaseMapperX<GapTrainingParticipantDO> {

    default PageResult<GapTrainingParticipantDO> selectPage(GapTrainingParticipantPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTrainingParticipantDO>()
                .eqIfPresent(GapTrainingParticipantDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(GapTrainingParticipantDO::getUserId, reqVO.getUserId())
                .eqIfPresent(GapTrainingParticipantDO::getDeptId, reqVO.getDeptId())
                .eqIfPresent(GapTrainingParticipantDO::getExamResult, reqVO.getExamResult())
                .eqIfPresent(GapTrainingParticipantDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapTrainingParticipantDO::getId));
    }

    default List<GapTrainingParticipantDO> selectListByRecordId(Long recordId) {
        return selectList(GapTrainingParticipantDO::getRecordId, recordId);
    }

}
