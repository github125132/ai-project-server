package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingParticipantDO;
import cn.iocoder.yudao.module.gap.dal.mysql.training.GapTrainingParticipantMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRAINING_COURSE_NOT_EXISTS;

/**
 * GAP 培训参训人员 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapTrainingParticipantServiceImpl implements GapTrainingParticipantService {

    @Resource
    private GapTrainingParticipantMapper trainingParticipantMapper;

    @Override
    public Long createTrainingParticipant(GapTrainingParticipantSaveReqVO createReqVO) {
        // 1. 插入
        GapTrainingParticipantDO trainingParticipant = BeanUtils.toBean(createReqVO, GapTrainingParticipantDO.class);
        trainingParticipantMapper.insert(trainingParticipant);
        return trainingParticipant.getId();
    }

    @Override
    public void updateTrainingParticipant(GapTrainingParticipantSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateTrainingParticipantExists(updateReqVO.getId());

        // 2. 更新
        GapTrainingParticipantDO updateObj = BeanUtils.toBean(updateReqVO, GapTrainingParticipantDO.class);
        trainingParticipantMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrainingParticipant(Long id) {
        // 1. 校验存在
        validateTrainingParticipantExists(id);

        // 2. 删除
        trainingParticipantMapper.deleteById(id);
    }

    @Override
    public GapTrainingParticipantDO getTrainingParticipant(Long id) {
        return trainingParticipantMapper.selectById(id);
    }

    @Override
    public PageResult<GapTrainingParticipantDO> getTrainingParticipantPage(GapTrainingParticipantPageReqVO pageReqVO) {
        return trainingParticipantMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapTrainingParticipantDO> getTrainingParticipantList() {
        return trainingParticipantMapper.selectList();
    }

    @Override
    public List<GapTrainingParticipantDO> getTrainingParticipantListByRecordId(Long recordId) {
        return trainingParticipantMapper.selectListByRecordId(recordId);
    }

    @Override
    public GapTrainingParticipantDO validateTrainingParticipantExists(Long id) {
        GapTrainingParticipantDO trainingParticipant = trainingParticipantMapper.selectById(id);
        if (trainingParticipant == null) {
            throw exception(TRAINING_COURSE_NOT_EXISTS);
        }
        return trainingParticipant;
    }

}
