package cn.iocoder.yudao.module.gap.dal.mysql.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCoursePageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingCourseDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 培训课程 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTrainingCourseMapper extends BaseMapperX<GapTrainingCourseDO> {

    default PageResult<GapTrainingCourseDO> selectPage(GapTrainingCoursePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTrainingCourseDO>()
                .likeIfPresent(GapTrainingCourseDO::getCode, reqVO.getCode())
                .likeIfPresent(GapTrainingCourseDO::getName, reqVO.getName())
                .eqIfPresent(GapTrainingCourseDO::getCategory, reqVO.getCategory())
                .eqIfPresent(GapTrainingCourseDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapTrainingCourseDO::getId));
    }

    default GapTrainingCourseDO selectByCode(String code) {
        return selectOne(GapTrainingCourseDO::getCode, code);
    }

    default List<GapTrainingCourseDO> selectListByStatus(Integer status) {
        return selectList(GapTrainingCourseDO::getStatus, status);
    }

}
