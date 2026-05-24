package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingPlanDO;
import cn.iocoder.yudao.module.gap.dal.mysql.training.GapTrainingPlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRAINING_COURSE_NOT_EXISTS;

/**
 * GAP 培训计划 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapTrainingPlanServiceImpl implements GapTrainingPlanService {

    @Resource
    private GapTrainingPlanMapper trainingPlanMapper;

    @Override
    public Long createTrainingPlan(GapTrainingPlanSaveReqVO createReqVO) {
        // 1. 插入
        GapTrainingPlanDO trainingPlan = BeanUtils.toBean(createReqVO, GapTrainingPlanDO.class);
        trainingPlanMapper.insert(trainingPlan);
        return trainingPlan.getId();
    }

    @Override
    public void updateTrainingPlan(GapTrainingPlanSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateTrainingPlanExists(updateReqVO.getId());

        // 2. 更新
        GapTrainingPlanDO updateObj = BeanUtils.toBean(updateReqVO, GapTrainingPlanDO.class);
        trainingPlanMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrainingPlan(Long id) {
        // 1. 校验存在
        validateTrainingPlanExists(id);

        // 2. 删除
        trainingPlanMapper.deleteById(id);
    }

    @Override
    public GapTrainingPlanDO getTrainingPlan(Long id) {
        return trainingPlanMapper.selectById(id);
    }

    @Override
    public PageResult<GapTrainingPlanDO> getTrainingPlanPage(GapTrainingPlanPageReqVO pageReqVO) {
        return trainingPlanMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapTrainingPlanDO> getTrainingPlanList() {
        return trainingPlanMapper.selectList();
    }

    @Override
    public List<GapTrainingPlanDO> getTrainingPlanListByCourseId(Long courseId) {
        return trainingPlanMapper.selectListByCourseId(courseId);
    }

    @Override
    public GapTrainingPlanDO validateTrainingPlanExists(Long id) {
        GapTrainingPlanDO trainingPlan = trainingPlanMapper.selectById(id);
        if (trainingPlan == null) {
            throw exception(TRAINING_COURSE_NOT_EXISTS);
        }
        return trainingPlan;
    }

}
