package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapInspectRecordMapper;
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
public class GapInspectRecordServiceImpl implements GapInspectRecordService {

    @Resource
    private GapInspectRecordMapper inspectRecordMapper;

    @Override
    public Long createInspectRecord(GapInspectRecordSaveReqVO createReqVO) {
        validateInspectRecordNoUnique(null, createReqVO.getRecordNo());
        GapInspectRecordDO inspectRecord = BeanUtils.toBean(createReqVO, GapInspectRecordDO.class);
        inspectRecordMapper.insert(inspectRecord);
        return inspectRecord.getId();
    }

    @Override
    public void updateInspectRecord(GapInspectRecordSaveReqVO updateReqVO) {
        validateInspectRecordExists(updateReqVO.getId());
        validateInspectRecordNoUnique(updateReqVO.getId(), updateReqVO.getRecordNo());
        GapInspectRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapInspectRecordDO.class);
        inspectRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteInspectRecord(Long id) {
        validateInspectRecordExists(id);
        inspectRecordMapper.deleteById(id);
    }

    @Override
    public GapInspectRecordDO getInspectRecord(Long id) {
        return inspectRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapInspectRecordDO> getInspectRecordPage(GapInspectRecordPageReqVO pageReqVO) {
        return inspectRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInspectRecordDO> getInspectRecordList() {
        return inspectRecordMapper.selectList();
    }

    @Override
    public List<GapInspectRecordDO> getInspectRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inspectRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapInspectRecordDO> getInspectRecordListByTaskId(Long taskId) {
        return inspectRecordMapper.selectListByTaskId(taskId);
    }

    @Override
    public GapInspectRecordDO validateInspectRecordExists(Long id) {
        GapInspectRecordDO inspectRecord = inspectRecordMapper.selectById(id);
        if (inspectRecord == null) {
            throw exception(INSPECT_RECORD_NOT_EXISTS);
        }
        return inspectRecord;
    }

    private void validateInspectRecordNoUnique(Long id, String recordNo) {
        if (recordNo == null || recordNo.isEmpty()) {
            return;
        }
        GapInspectRecordDO inspectRecord = inspectRecordMapper.selectByRecordNo(recordNo);
        if (inspectRecord == null) {
            return;
        }
        if (ObjUtil.notEqual(id, inspectRecord.getId())) {
            throw exception(INSPECT_RECORD_NO_DUPLICATE);
        }
    }

}
