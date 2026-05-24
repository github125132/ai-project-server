package cn.iocoder.yudao.module.gap.service.training;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCoursePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCourseSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingCourseDO;
import cn.iocoder.yudao.module.gap.dal.mysql.training.GapTrainingCourseMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRAINING_COURSE_NOT_EXISTS;

/**
 * GAP 培训课程 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapTrainingCourseServiceImpl implements GapTrainingCourseService {

    @Resource
    private GapTrainingCourseMapper trainingCourseMapper;

    @Override
    public Long createTrainingCourse(GapTrainingCourseSaveReqVO createReqVO) {
        // 1. 校验编码唯一
        validateTrainingCourseCodeUnique(null, createReqVO.getCode());

        // 2. 插入
        GapTrainingCourseDO trainingCourse = BeanUtils.toBean(createReqVO, GapTrainingCourseDO.class);
        trainingCourseMapper.insert(trainingCourse);
        return trainingCourse.getId();
    }

    @Override
    public void updateTrainingCourse(GapTrainingCourseSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateTrainingCourseExists(updateReqVO.getId());
        // 1.2 校验编码唯一
        validateTrainingCourseCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        // 2. 更新
        GapTrainingCourseDO updateObj = BeanUtils.toBean(updateReqVO, GapTrainingCourseDO.class);
        trainingCourseMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrainingCourse(Long id) {
        // 1. 校验存在
        validateTrainingCourseExists(id);

        // 2. 删除
        trainingCourseMapper.deleteById(id);
    }

    @Override
    public GapTrainingCourseDO getTrainingCourse(Long id) {
        return trainingCourseMapper.selectById(id);
    }

    @Override
    public PageResult<GapTrainingCourseDO> getTrainingCoursePage(GapTrainingCoursePageReqVO pageReqVO) {
        return trainingCourseMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapTrainingCourseDO> getTrainingCourseList() {
        return trainingCourseMapper.selectList();
    }

    @Override
    public GapTrainingCourseDO validateTrainingCourseExists(Long id) {
        GapTrainingCourseDO trainingCourse = trainingCourseMapper.selectById(id);
        if (trainingCourse == null) {
            throw exception(TRAINING_COURSE_NOT_EXISTS);
        }
        return trainingCourse;
    }

    private void validateTrainingCourseCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapTrainingCourseDO trainingCourse = trainingCourseMapper.selectByCode(code);
        if (trainingCourse == null) {
            return;
        }
        if (ObjUtil.notEqual(id, trainingCourse.getId())) {
            throw exception(TRAINING_COURSE_NOT_EXISTS);
        }
    }

}
