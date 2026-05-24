package cn.iocoder.yudao.module.gap.dal.mysql.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingPlanDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 培训计划 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTrainingPlanMapper extends BaseMapperX<GapTrainingPlanDO> {

    default PageResult<GapTrainingPlanDO> selectPage(GapTrainingPlanPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTrainingPlanDO>()
                .likeIfPresent(GapTrainingPlanDO::getPlanNo, reqVO.getPlanNo())
                .likeIfPresent(GapTrainingPlanDO::getPlanName, reqVO.getPlanName())
                .eqIfPresent(GapTrainingPlanDO::getYear, reqVO.getYear())
                .eqIfPresent(GapTrainingPlanDO::getCourseId, reqVO.getCourseId())
                .eqIfPresent(GapTrainingPlanDO::getTrainingType, reqVO.getTrainingType())
                .eqIfPresent(GapTrainingPlanDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapTrainingPlanDO::getId));
    }

    default List<GapTrainingPlanDO> selectListByCourseId(Long courseId) {
        return selectList(GapTrainingPlanDO::getCourseId, courseId);
    }

}
