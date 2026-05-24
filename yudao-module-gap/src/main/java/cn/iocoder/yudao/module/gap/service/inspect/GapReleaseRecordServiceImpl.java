package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapReleaseRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapReleaseRecordMapper;
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
public class GapReleaseRecordServiceImpl implements GapReleaseRecordService {

    @Resource
    private GapReleaseRecordMapper releaseRecordMapper;

    @Override
    public Long createReleaseRecord(GapReleaseRecordSaveReqVO createReqVO) {
        validateReleaseNoUnique(null, createReqVO.getReleaseNo());
        GapReleaseRecordDO releaseRecord = BeanUtils.toBean(createReqVO, GapReleaseRecordDO.class);
        releaseRecordMapper.insert(releaseRecord);
        return releaseRecord.getId();
    }

    @Override
    public void updateReleaseRecord(GapReleaseRecordSaveReqVO updateReqVO) {
        validateReleaseRecordExists(updateReqVO.getId());
        validateReleaseNoUnique(updateReqVO.getId(), updateReqVO.getReleaseNo());
        GapReleaseRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapReleaseRecordDO.class);
        releaseRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteReleaseRecord(Long id) {
        validateReleaseRecordExists(id);
        releaseRecordMapper.deleteById(id);
    }

    @Override
    public GapReleaseRecordDO getReleaseRecord(Long id) {
        return releaseRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapReleaseRecordDO> getReleaseRecordPage(GapReleaseRecordPageReqVO pageReqVO) {
        return releaseRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapReleaseRecordDO> getReleaseRecordList() {
        return releaseRecordMapper.selectList();
    }

    @Override
    public List<GapReleaseRecordDO> getReleaseRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return releaseRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapReleaseRecordDO> getReleaseRecordListByBatchNo(String batchNo) {
        return releaseRecordMapper.selectListByBatchNo(batchNo);
    }

    @Override
    public GapReleaseRecordDO validateReleaseRecordExists(Long id) {
        GapReleaseRecordDO releaseRecord = releaseRecordMapper.selectById(id);
        if (releaseRecord == null) {
            throw exception(RELEASE_NOT_EXISTS);
        }
        return releaseRecord;
    }

    private void validateReleaseNoUnique(Long id, String releaseNo) {
        if (releaseNo == null || releaseNo.isEmpty()) {
            return;
        }
        GapReleaseRecordDO releaseRecord = releaseRecordMapper.selectByReleaseNo(releaseNo);
        if (releaseRecord == null) {
            return;
        }
        if (ObjUtil.notEqual(id, releaseRecord.getId())) {
            throw exception(RELEASE_NO_DUPLICATE);
        }
    }

}
