package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapDryingRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.process.GapDryingRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.PROCESS_RECORD_NOT_EXISTS;

/**
 * GAP 干燥记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapDryingRecordServiceImpl implements GapDryingRecordService {

    @Resource
    private GapDryingRecordMapper dryingRecordMapper;

    @Override
    public Long createDryingRecord(GapDryingRecordSaveReqVO createReqVO) {
        // 插入
        GapDryingRecordDO dryingRecord = BeanUtils.toBean(createReqVO, GapDryingRecordDO.class);
        dryingRecordMapper.insert(dryingRecord);
        return dryingRecord.getId();
    }

    @Override
    public void updateDryingRecord(GapDryingRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateDryingRecordExists(updateReqVO.getId());

        // 2. 更新
        GapDryingRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapDryingRecordDO.class);
        dryingRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteDryingRecord(Long id) {
        // 1. 校验存在
        validateDryingRecordExists(id);

        // 2. 删除
        dryingRecordMapper.deleteById(id);
    }

    @Override
    public GapDryingRecordDO getDryingRecord(Long id) {
        return dryingRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapDryingRecordDO> getDryingRecordPage(GapDryingRecordPageReqVO pageReqVO) {
        return dryingRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapDryingRecordDO> getDryingRecordList() {
        return dryingRecordMapper.selectList();
    }

    @Override
    public List<GapDryingRecordDO> getDryingRecordListByProcessRecordId(Long processRecordId) {
        return dryingRecordMapper.selectListByProcessRecordId(processRecordId);
    }

    @Override
    public GapDryingRecordDO validateDryingRecordExists(Long id) {
        GapDryingRecordDO dryingRecord = dryingRecordMapper.selectById(id);
        if (dryingRecord == null) {
            throw exception(PROCESS_RECORD_NOT_EXISTS);
        }
        return dryingRecord;
    }

}
