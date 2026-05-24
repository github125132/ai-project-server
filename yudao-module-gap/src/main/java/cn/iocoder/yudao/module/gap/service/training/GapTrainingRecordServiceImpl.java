package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.training.GapTrainingRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRAINING_COURSE_NOT_EXISTS;

/**
 * GAP 培训记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapTrainingRecordServiceImpl implements GapTrainingRecordService {

    @Resource
    private GapTrainingRecordMapper trainingRecordMapper;

    @Override
    public Long createTrainingRecord(GapTrainingRecordSaveReqVO createReqVO) {
        // 1. 插入
        GapTrainingRecordDO trainingRecord = BeanUtils.toBean(createReqVO, GapTrainingRecordDO.class);
        trainingRecordMapper.insert(trainingRecord);
        return trainingRecord.getId();
    }

    @Override
    public void updateTrainingRecord(GapTrainingRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateTrainingRecordExists(updateReqVO.getId());

        // 2. 更新
        GapTrainingRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapTrainingRecordDO.class);
        trainingRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrainingRecord(Long id) {
        // 1. 校验存在
        validateTrainingRecordExists(id);

        // 2. 删除
        trainingRecordMapper.deleteById(id);
    }

    @Override
    public GapTrainingRecordDO getTrainingRecord(Long id) {
        return trainingRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapTrainingRecordDO> getTrainingRecordPage(GapTrainingRecordPageReqVO pageReqVO) {
        return trainingRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapTrainingRecordDO> getTrainingRecordList() {
        return trainingRecordMapper.selectList();
    }

    @Override
    public List<GapTrainingRecordDO> getTrainingRecordListByPlanId(Long planId) {
        return trainingRecordMapper.selectListByPlanId(planId);
    }

    @Override
    public GapTrainingRecordDO validateTrainingRecordExists(Long id) {
        GapTrainingRecordDO trainingRecord = trainingRecordMapper.selectById(id);
        if (trainingRecord == null) {
            throw exception(TRAINING_COURSE_NOT_EXISTS);
        }
        return trainingRecord;
    }

}
