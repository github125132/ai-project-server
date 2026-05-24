package cn.iocoder.yudao.module.gap.service.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapRecallRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapRecallRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.change.GapRecallRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.RECALL_RECORD_NOT_EXISTS;

@Service
@Validated
public class GapRecallRecordServiceImpl implements GapRecallRecordService {

    @Resource
    private GapRecallRecordMapper RecallRecordMapper;

    @Override
    public Long createGapRecallRecord(GapRecallRecordSaveReqVO createReqVO) {
        GapRecallRecordDO entity = BeanUtils.toBean(createReqVO, GapRecallRecordDO.class);
        RecallRecordMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapRecallRecord(GapRecallRecordSaveReqVO updateReqVO) {
        validateGapRecallRecordExists(updateReqVO.getId());
        GapRecallRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapRecallRecordDO.class);
        RecallRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapRecallRecord(Long id) {
        validateGapRecallRecordExists(id);
        RecallRecordMapper.deleteById(id);
    }

    @Override
    public GapRecallRecordDO getGapRecallRecord(Long id) {
        return RecallRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapRecallRecordDO> getGapRecallRecordPage(GapRecallRecordPageReqVO pageReqVO) {
        return RecallRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public GapRecallRecordDO validateGapRecallRecordExists(Long id) {
        GapRecallRecordDO entity = RecallRecordMapper.selectById(id);
        if (entity == null) {
            throw exception(RECALL_RECORD_NOT_EXISTS);
        }
        return entity;
    }
}
