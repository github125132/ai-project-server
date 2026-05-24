package cn.iocoder.yudao.module.gap.dal.mysql.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 培训记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTrainingRecordMapper extends BaseMapperX<GapTrainingRecordDO> {

    default PageResult<GapTrainingRecordDO> selectPage(GapTrainingRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTrainingRecordDO>()
                .likeIfPresent(GapTrainingRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapTrainingRecordDO::getPlanId, reqVO.getPlanId())
                .eqIfPresent(GapTrainingRecordDO::getCourseId, reqVO.getCourseId())
                .eqIfPresent(GapTrainingRecordDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapTrainingRecordDO::getTrainingDate, reqVO.getTrainingDate())
                .orderByDesc(GapTrainingRecordDO::getId));
    }

    default List<GapTrainingRecordDO> selectListByPlanId(Long planId) {
        return selectList(GapTrainingRecordDO::getPlanId, planId);
    }

}
