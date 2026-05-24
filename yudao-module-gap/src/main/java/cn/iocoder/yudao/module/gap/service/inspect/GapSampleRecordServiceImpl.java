package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapSampleRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapSampleRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

@Service
@Validated
public class GapSampleRecordServiceImpl implements GapSampleRecordService {

    @Resource
    private GapSampleRecordMapper sampleRecordMapper;

    @Override
    public Long createSampleRecord(GapSampleRecordSaveReqVO createReqVO) {
        validateSampleRecordNoUnique(null, createReqVO.getSampleNo());
        GapSampleRecordDO sampleRecord = BeanUtils.toBean(createReqVO, GapSampleRecordDO.class);
        sampleRecordMapper.insert(sampleRecord);
        return sampleRecord.getId();
    }

    @Override
    public void updateSampleRecord(GapSampleRecordSaveReqVO updateReqVO) {
        validateSampleRecordExists(updateReqVO.getId());
        validateSampleRecordNoUnique(updateReqVO.getId(), updateReqVO.getSampleNo());
        GapSampleRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapSampleRecordDO.class);
        sampleRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteSampleRecord(Long id) {
        validateSampleRecordExists(id);
        sampleRecordMapper.deleteById(id);
    }

    @Override
    public GapSampleRecordDO getSampleRecord(Long id) {
        return sampleRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapSampleRecordDO> getSampleRecordPage(GapSampleRecordPageReqVO pageReqVO) {
        return sampleRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapSampleRecordDO> getSampleRecordList() {
        return sampleRecordMapper.selectList();
    }

    @Override
    public List<GapSampleRecordDO> getSampleRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return sampleRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapSampleRecordDO> getSampleRecordListByBatchNo(String batchNo) {
        return sampleRecordMapper.selectListByBatchNo(batchNo);
    }

    @Override
    public GapSampleRecordDO validateSampleRecordExists(Long id) {
        GapSampleRecordDO sampleRecord = sampleRecordMapper.selectById(id);
        if (sampleRecord == null) {
            throw exception(SAMPLE_RECORD_NOT_EXISTS);
        }
        return sampleRecord;
    }

    private void validateSampleRecordNoUnique(Long id, String sampleNo) {
        if (sampleNo == null || sampleNo.isEmpty()) {
            return;
        }
        GapSampleRecordDO sampleRecord = sampleRecordMapper.selectBySampleNo(sampleNo);
        if (sampleRecord == null) {
            return;
        }
        if (ObjUtil.notEqual(id, sampleRecord.getId())) {
            throw exception(SAMPLE_RECORD_NO_DUPLICATE);
        }
    }

}
