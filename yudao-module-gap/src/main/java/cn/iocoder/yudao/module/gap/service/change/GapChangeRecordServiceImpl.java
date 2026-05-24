package cn.iocoder.yudao.module.gap.service.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapChangeRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.change.GapChangeRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.CHANGE_RECORD_NOT_EXISTS;

@Service
@Validated
public class GapChangeRecordServiceImpl implements GapChangeRecordService {

    @Resource
    private GapChangeRecordMapper ChangeRecordMapper;

    @Override
    public Long createGapChangeRecord(GapChangeRecordSaveReqVO createReqVO) {
        GapChangeRecordDO entity = BeanUtils.toBean(createReqVO, GapChangeRecordDO.class);
        ChangeRecordMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapChangeRecord(GapChangeRecordSaveReqVO updateReqVO) {
        validateGapChangeRecordExists(updateReqVO.getId());
        GapChangeRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapChangeRecordDO.class);
        ChangeRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapChangeRecord(Long id) {
        validateGapChangeRecordExists(id);
        ChangeRecordMapper.deleteById(id);
    }

    @Override
    public GapChangeRecordDO getGapChangeRecord(Long id) {
        return ChangeRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapChangeRecordDO> getGapChangeRecordPage(GapChangeRecordPageReqVO pageReqVO) {
        return ChangeRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public GapChangeRecordDO validateGapChangeRecordExists(Long id) {
        GapChangeRecordDO entity = ChangeRecordMapper.selectById(id);
        if (entity == null) {
            throw exception(CHANGE_RECORD_NOT_EXISTS);
        }
        return entity;
    }
}
