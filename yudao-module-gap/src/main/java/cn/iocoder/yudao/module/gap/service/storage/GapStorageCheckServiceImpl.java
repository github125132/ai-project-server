package cn.iocoder.yudao.module.gap.service.storage;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageCheckDO;
import cn.iocoder.yudao.module.gap.dal.mysql.storage.GapStorageCheckMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 养护检查记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapStorageCheckServiceImpl implements GapStorageCheckService {

    @Resource
    private GapStorageCheckMapper storageCheckMapper;

    @Override
    public Long createStorageCheck(GapStorageCheckSaveReqVO createReqVO) {
        // 1. 插入
        GapStorageCheckDO storageCheck = BeanUtils.toBean(createReqVO, GapStorageCheckDO.class);
        storageCheckMapper.insert(storageCheck);
        return storageCheck.getId();
    }

    @Override
    public void updateStorageCheck(GapStorageCheckSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateStorageCheckExists(updateReqVO.getId());

        // 2. 更新
        GapStorageCheckDO updateObj = BeanUtils.toBean(updateReqVO, GapStorageCheckDO.class);
        storageCheckMapper.updateById(updateObj);
    }

    @Override
    public void deleteStorageCheck(Long id) {
        // 1. 校验存在
        validateStorageCheckExists(id);

        // 2. 删除
        storageCheckMapper.deleteById(id);
    }

    @Override
    public GapStorageCheckDO getStorageCheck(Long id) {
        return storageCheckMapper.selectById(id);
    }

    @Override
    public PageResult<GapStorageCheckDO> getStorageCheckPage(GapStorageCheckPageReqVO pageReqVO) {
        return storageCheckMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapStorageCheckDO> getStorageCheckList() {
        return storageCheckMapper.selectList();
    }

    @Override
    public List<GapStorageCheckDO> getStorageCheckList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return storageCheckMapper.selectByIds(ids);
    }

    @Override
    public List<GapStorageCheckDO> getStorageCheckListByWarehouseId(Long warehouseId) {
        return storageCheckMapper.selectListByWarehouseId(warehouseId);
    }

    @Override
    public GapStorageCheckDO validateStorageCheckExists(Long id) {
        GapStorageCheckDO storageCheck = storageCheckMapper.selectById(id);
        if (storageCheck == null) {
            throw exception(STORAGE_AREA_NOT_EXISTS);
        }
        return storageCheck;
    }

}
