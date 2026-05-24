package cn.iocoder.yudao.module.gap.service.storage;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageInRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.storage.GapStorageInRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.STORAGE_IN_NOT_EXISTS;

/**
 * GAP 药材入库记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapStorageInRecordServiceImpl implements GapStorageInRecordService {

    @Resource
    private GapStorageInRecordMapper storageInRecordMapper;

    @Override
    public Long createStorageInRecord(GapStorageInRecordSaveReqVO createReqVO) {
        // 1. 插入
        GapStorageInRecordDO storageInRecord = BeanUtils.toBean(createReqVO, GapStorageInRecordDO.class);
        storageInRecordMapper.insert(storageInRecord);
        return storageInRecord.getId();
    }

    @Override
    public void updateStorageInRecord(GapStorageInRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateStorageInRecordExists(updateReqVO.getId());

        // 2. 更新
        GapStorageInRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapStorageInRecordDO.class);
        storageInRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteStorageInRecord(Long id) {
        // 1. 校验存在
        validateStorageInRecordExists(id);

        // 2. 删除
        storageInRecordMapper.deleteById(id);
    }

    @Override
    public GapStorageInRecordDO getStorageInRecord(Long id) {
        return storageInRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapStorageInRecordDO> getStorageInRecordPage(GapStorageInRecordPageReqVO pageReqVO) {
        return storageInRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapStorageInRecordDO> getStorageInRecordList() {
        return storageInRecordMapper.selectList();
    }

    @Override
    public List<GapStorageInRecordDO> getStorageInRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return storageInRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapStorageInRecordDO> getStorageInRecordListByWarehouseId(Long warehouseId) {
        return storageInRecordMapper.selectListByWarehouseId(warehouseId);
    }

    @Override
    public List<GapStorageInRecordDO> getStorageInRecordListByVarietyId(Long varietyId) {
        return storageInRecordMapper.selectListByVarietyId(varietyId);
    }

    @Override
    public GapStorageInRecordDO validateStorageInRecordExists(Long id) {
        GapStorageInRecordDO storageInRecord = storageInRecordMapper.selectById(id);
        if (storageInRecord == null) {
            throw exception(STORAGE_IN_NOT_EXISTS);
        }
        return storageInRecord;
    }

}
