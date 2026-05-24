package cn.iocoder.yudao.module.gap.service.harvest;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.harvest.GapHarvestRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.HARVEST_BATCH_NO_DUPLICATE;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.HARVEST_RECORD_NOT_EXISTS;

/**
 * GAP 采收记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapHarvestRecordServiceImpl implements GapHarvestRecordService {

    @Resource
    private GapHarvestRecordMapper harvestRecordMapper;

    @Override
    public Long createHarvestRecord(GapHarvestRecordSaveReqVO createReqVO) {
        // 1. 校验记录单号唯一
        validateRecordNoUnique(null, createReqVO.getRecordNo());
        // 1.2 校验批次号唯一
        validateBatchNoUnique(null, createReqVO.getBatchNo());

        // 2. 插入
        GapHarvestRecordDO harvestRecord = BeanUtils.toBean(createReqVO, GapHarvestRecordDO.class);
        harvestRecordMapper.insert(harvestRecord);
        return harvestRecord.getId();
    }

    @Override
    public void updateHarvestRecord(GapHarvestRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateHarvestRecordExists(updateReqVO.getId());
        // 1.2 校验记录单号唯一
        validateRecordNoUnique(updateReqVO.getId(), updateReqVO.getRecordNo());
        // 1.3 校验批次号唯一
        validateBatchNoUnique(updateReqVO.getId(), updateReqVO.getBatchNo());

        // 2. 更新
        GapHarvestRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapHarvestRecordDO.class);
        harvestRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteHarvestRecord(Long id) {
        // 1. 校验存在
        validateHarvestRecordExists(id);

        // 2. 删除
        harvestRecordMapper.deleteById(id);
    }

    @Override
    public GapHarvestRecordDO getHarvestRecord(Long id) {
        return harvestRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapHarvestRecordDO> getHarvestRecordPage(GapHarvestRecordPageReqVO pageReqVO) {
        return harvestRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapHarvestRecordDO> getHarvestRecordList() {
        return harvestRecordMapper.selectList();
    }

    @Override
    public List<GapHarvestRecordDO> getHarvestRecordListByBaseId(Long baseId) {
        return harvestRecordMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapHarvestRecordDO> getHarvestRecordListByPlotId(Long plotId) {
        return harvestRecordMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapHarvestRecordDO validateHarvestRecordExists(Long id) {
        GapHarvestRecordDO harvestRecord = harvestRecordMapper.selectById(id);
        if (harvestRecord == null) {
            throw exception(HARVEST_RECORD_NOT_EXISTS);
        }
        return harvestRecord;
    }

    private void validateRecordNoUnique(Long id, String recordNo) {
        if (recordNo == null || recordNo.isEmpty()) {
            return;
        }
        GapHarvestRecordDO harvestRecord = harvestRecordMapper.selectByRecordNo(recordNo);
        if (harvestRecord == null) {
            return;
        }
        if (ObjUtil.notEqual(id, harvestRecord.getId())) {
            throw exception(HARVEST_BATCH_NO_DUPLICATE);
        }
    }

    private void validateBatchNoUnique(Long id, String batchNo) {
        if (batchNo == null || batchNo.isEmpty()) {
            return;
        }
        GapHarvestRecordDO harvestRecord = harvestRecordMapper.selectByBatchNo(batchNo);
        if (harvestRecord == null) {
            return;
        }
        if (ObjUtil.notEqual(id, harvestRecord.getId())) {
            throw exception(HARVEST_BATCH_NO_DUPLICATE);
        }
    }

}
