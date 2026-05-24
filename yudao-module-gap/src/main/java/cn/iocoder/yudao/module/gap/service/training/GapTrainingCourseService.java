package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCoursePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingCourseSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingCourseDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 培训课程 Service 接口
 *
 * @author 芋道源码
 */
public interface GapTrainingCourseService {

    /**
     * 创建培训课程
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTrainingCourse(@Valid GapTrainingCourseSaveReqVO createReqVO);

    /**
     * 更新培训课程
     *
     * @param updateReqVO 更新信息
     */
    void updateTrainingCourse(@Valid GapTrainingCourseSaveReqVO updateReqVO);

    /**
     * 删除培训课程
     *
     * @param id 编号
     */
    void deleteTrainingCourse(Long id);

    /**
     * 获得培训课程
     *
     * @param id 编号
     * @return 培训课程
     */
    GapTrainingCourseDO getTrainingCourse(Long id);

    /**
     * 获得培训课程分页
     *
     * @param pageReqVO 分页查询
     * @return 培训课程分页
     */
    PageResult<GapTrainingCourseDO> getTrainingCoursePage(GapTrainingCoursePageReqVO pageReqVO);

    /**
     * 获得培训课程列表
     *
     * @return 培训课程列表
     */
    List<GapTrainingCourseDO> getTrainingCourseList();

    /**
     * 校验培训课程存在
     *
     * @param id 编号
     * @return 培训课程
     */
    GapTrainingCourseDO validateTrainingCourseExists(Long id);

}
