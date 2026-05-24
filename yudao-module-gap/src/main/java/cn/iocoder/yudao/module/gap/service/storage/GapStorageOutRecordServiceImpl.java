package cn.iocoder.yudao.module.gap.service.storage;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageOutRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.storage.GapStorageOutRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.STORAGE_OUT_NOT_EXISTS;

/**
 * GAP 药材出库记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapStorageOutRecordServiceImpl implements GapStorageOutRecordService {

    @Resource
    private GapStorageOutRecordMapper storageOutRecordMapper;

    @Override
    public Long createStorageOutRecord(GapStorageOutRecordSaveReqVO createReqVO) {
        // 1. 插入
        GapStorageOutRecordDO storageOutRecord = BeanUtils.toBean(createReqVO, GapStorageOutRecordDO.class);
        storageOutRecordMapper.insert(storageOutRecord);
        return storageOutRecord.getId();
    }

    @Override
    public void updateStorageOutRecord(GapStorageOutRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateStorageOutRecordExists(updateReqVO.getId());

        // 2. 更新
        GapStorageOutRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapStorageOutRecordDO.class);
        storageOutRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteStorageOutRecord(Long id) {
        // 1. 校验存在
        validateStorageOutRecordExists(id);

        // 2. 删除
        storageOutRecordMapper.deleteById(id);
    }

    @Override
    public GapStorageOutRecordDO getStorageOutRecord(Long id) {
        return storageOutRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapStorageOutRecordDO> getStorageOutRecordPage(GapStorageOutRecordPageReqVO pageReqVO) {
        return storageOutRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapStorageOutRecordDO> getStorageOutRecordList() {
        return storageOutRecordMapper.selectList();
    }

    @Override
    public List<GapStorageOutRecordDO> getStorageOutRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return storageOutRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapStorageOutRecordDO> getStorageOutRecordListByWarehouseId(Long warehouseId) {
        return storageOutRecordMapper.selectListByWarehouseId(warehouseId);
    }

    @Override
    public GapStorageOutRecordDO validateStorageOutRecordExists(Long id) {
        GapStorageOutRecordDO storageOutRecord = storageOutRecordMapper.selectById(id);
        if (storageOutRecord == null) {
            throw exception(STORAGE_OUT_NOT_EXISTS);
        }
        return storageOutRecord;
    }

}
