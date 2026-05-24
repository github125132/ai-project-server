package cn.iocoder.yudao.module.gap.service.process;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.process.GapProcessRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.HARVEST_BATCH_NO_DUPLICATE;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.PROCESS_RECORD_NOT_EXISTS;

/**
 * GAP 加工记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapProcessRecordServiceImpl implements GapProcessRecordService {

    @Resource
    private GapProcessRecordMapper processRecordMapper;

    @Override
    public Long createProcessRecord(GapProcessRecordSaveReqVO createReqVO) {
        // 1. 校验记录单号唯一
        validateRecordNoUnique(null, createReqVO.getRecordNo());

        // 2. 插入
        GapProcessRecordDO processRecord = BeanUtils.toBean(createReqVO, GapProcessRecordDO.class);
        processRecordMapper.insert(processRecord);
        return processRecord.getId();
    }

    @Override
    public void updateProcessRecord(GapProcessRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateProcessRecordExists(updateReqVO.getId());
        // 1.2 校验记录单号唯一
        validateRecordNoUnique(updateReqVO.getId(), updateReqVO.getRecordNo());

        // 2. 更新
        GapProcessRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapProcessRecordDO.class);
        processRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteProcessRecord(Long id) {
        // 1. 校验存在
        validateProcessRecordExists(id);

        // 2. 删除
        processRecordMapper.deleteById(id);
    }

    @Override
    public GapProcessRecordDO getProcessRecord(Long id) {
        return processRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapProcessRecordDO> getProcessRecordPage(GapProcessRecordPageReqVO pageReqVO) {
        return processRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapProcessRecordDO> getProcessRecordList() {
        return processRecordMapper.selectList();
    }

    @Override
    public List<GapProcessRecordDO> getProcessRecordListByVarietyId(Long varietyId) {
        return processRecordMapper.selectListByVarietyId(varietyId);
    }

    @Override
    public GapProcessRecordDO validateProcessRecordExists(Long id) {
        GapProcessRecordDO processRecord = processRecordMapper.selectById(id);
        if (processRecord == null) {
            throw exception(PROCESS_RECORD_NOT_EXISTS);
        }
        return processRecord;
    }

    private void validateRecordNoUnique(Long id, String recordNo) {
        if (recordNo == null || recordNo.isEmpty()) {
            return;
        }
        GapProcessRecordDO processRecord = processRecordMapper.selectByRecordNo(recordNo);
        if (processRecord == null) {
            return;
        }
        if (ObjUtil.notEqual(id, processRecord.getId())) {
            throw exception(HARVEST_BATCH_NO_DUPLICATE);
        }
    }

}
