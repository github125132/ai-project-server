package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingPlanDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 培训计划 Service 接口
 *
 * @author 芋道源码
 */
public interface GapTrainingPlanService {

    /**
     * 创建培训计划
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTrainingPlan(@Valid GapTrainingPlanSaveReqVO createReqVO);

    /**
     * 更新培训计划
     *
     * @param updateReqVO 更新信息
     */
    void updateTrainingPlan(@Valid GapTrainingPlanSaveReqVO updateReqVO);

    /**
     * 删除培训计划
     *
     * @param id 编号
     */
    void deleteTrainingPlan(Long id);

    /**
     * 获得培训计划
     *
     * @param id 编号
     * @return 培训计划
     */
    GapTrainingPlanDO getTrainingPlan(Long id);

    /**
     * 获得培训计划分页
     *
     * @param pageReqVO 分页查询
     * @return 培训计划分页
     */
    PageResult<GapTrainingPlanDO> getTrainingPlanPage(GapTrainingPlanPageReqVO pageReqVO);

    /**
     * 获得培训计划列表
     *
     * @return 培训计划列表
     */
    List<GapTrainingPlanDO> getTrainingPlanList();

    /**
     * 根据课程编号获得培训计划列表
     *
     * @param courseId 课程编号
     * @return 培训计划列表
     */
    List<GapTrainingPlanDO> getTrainingPlanListByCourseId(Long courseId);

    /**
     * 校验培训计划存在
     *
     * @param id 编号
     * @return 培训计划
     */
    GapTrainingPlanDO validateTrainingPlanExists(Long id);

}
