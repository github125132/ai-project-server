package cn.iocoder.yudao.module.gap.service.storage;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageAreaDO;
import cn.iocoder.yudao.module.gap.dal.mysql.storage.GapStorageAreaMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 仓库分区 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapStorageAreaServiceImpl implements GapStorageAreaService {

    @Resource
    private GapStorageAreaMapper storageAreaMapper;

    @Override
    public Long createStorageArea(GapStorageAreaSaveReqVO createReqVO) {
        // 1. 校验编码唯一
        validateStorageAreaCodeUnique(null, createReqVO.getCode());

        // 2. 插入
        GapStorageAreaDO storageArea = BeanUtils.toBean(createReqVO, GapStorageAreaDO.class);
        storageAreaMapper.insert(storageArea);
        return storageArea.getId();
    }

    @Override
    public void updateStorageArea(GapStorageAreaSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateStorageAreaExists(updateReqVO.getId());
        // 1.2 校验编码唯一
        validateStorageAreaCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        // 2. 更新
        GapStorageAreaDO updateObj = BeanUtils.toBean(updateReqVO, GapStorageAreaDO.class);
        storageAreaMapper.updateById(updateObj);
    }

    @Override
    public void deleteStorageArea(Long id) {
        // 1. 校验存在
        validateStorageAreaExists(id);

        // 2. 删除
        storageAreaMapper.deleteById(id);
    }

    @Override
    public GapStorageAreaDO getStorageArea(Long id) {
        return storageAreaMapper.selectById(id);
    }

    @Override
    public PageResult<GapStorageAreaDO> getStorageAreaPage(GapStorageAreaPageReqVO pageReqVO) {
        return storageAreaMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapStorageAreaDO> getStorageAreaList() {
        return storageAreaMapper.selectList();
    }

    @Override
    public List<GapStorageAreaDO> getStorageAreaList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return storageAreaMapper.selectByIds(ids);
    }

    @Override
    public List<GapStorageAreaDO> getStorageAreaListByWarehouseId(Long warehouseId) {
        return storageAreaMapper.selectListByWarehouseId(warehouseId);
    }

    @Override
    public GapStorageAreaDO validateStorageAreaExists(Long id) {
        GapStorageAreaDO storageArea = storageAreaMapper.selectById(id);
        if (storageArea == null) {
            throw exception(STORAGE_AREA_NOT_EXISTS);
        }
        return storageArea;
    }

    private void validateStorageAreaCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapStorageAreaDO storageArea = storageAreaMapper.selectByCode(code);
        if (storageArea == null) {
            return;
        }
        if (ObjUtil.notEqual(id, storageArea.getId())) {
            throw exception(STORAGE_AREA_CODE_DUPLICATE);
        }
    }

}
