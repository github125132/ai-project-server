package cn.iocoder.yudao.module.gap.service.storage;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandlePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandleSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapUnqualifiedHandleDO;
import cn.iocoder.yudao.module.gap.dal.mysql.storage.GapUnqualifiedHandleMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 不合格品处理 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapUnqualifiedHandleServiceImpl implements GapUnqualifiedHandleService {

    @Resource
    private GapUnqualifiedHandleMapper unqualifiedHandleMapper;

    @Override
    public Long createUnqualifiedHandle(GapUnqualifiedHandleSaveReqVO createReqVO) {
        // 1. 插入
        GapUnqualifiedHandleDO unqualifiedHandle = BeanUtils.toBean(createReqVO, GapUnqualifiedHandleDO.class);
        unqualifiedHandleMapper.insert(unqualifiedHandle);
        return unqualifiedHandle.getId();
    }

    @Override
    public void updateUnqualifiedHandle(GapUnqualifiedHandleSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateUnqualifiedHandleExists(updateReqVO.getId());

        // 2. 更新
        GapUnqualifiedHandleDO updateObj = BeanUtils.toBean(updateReqVO, GapUnqualifiedHandleDO.class);
        unqualifiedHandleMapper.updateById(updateObj);
    }

    @Override
    public void deleteUnqualifiedHandle(Long id) {
        // 1. 校验存在
        validateUnqualifiedHandleExists(id);

        // 2. 删除
        unqualifiedHandleMapper.deleteById(id);
    }

    @Override
    public GapUnqualifiedHandleDO getUnqualifiedHandle(Long id) {
        return unqualifiedHandleMapper.selectById(id);
    }

    @Override
    public PageResult<GapUnqualifiedHandleDO> getUnqualifiedHandlePage(GapUnqualifiedHandlePageReqVO pageReqVO) {
        return unqualifiedHandleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapUnqualifiedHandleDO> getUnqualifiedHandleList() {
        return unqualifiedHandleMapper.selectList();
    }

    @Override
    public List<GapUnqualifiedHandleDO> getUnqualifiedHandleList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return unqualifiedHandleMapper.selectByIds(ids);
    }

    @Override
    public List<GapUnqualifiedHandleDO> getUnqualifiedHandleListByBatchNo(String batchNo) {
        return unqualifiedHandleMapper.selectListByBatchNo(batchNo);
    }

    @Override
    public GapUnqualifiedHandleDO validateUnqualifiedHandleExists(Long id) {
        GapUnqualifiedHandleDO unqualifiedHandle = unqualifiedHandleMapper.selectById(id);
        if (unqualifiedHandle == null) {
            throw exception(STORAGE_AREA_NOT_EXISTS);
        }
        return unqualifiedHandle;
    }

}
