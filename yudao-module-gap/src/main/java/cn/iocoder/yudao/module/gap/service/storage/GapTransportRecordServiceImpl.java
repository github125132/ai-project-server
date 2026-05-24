package cn.iocoder.yudao.module.gap.service.storage;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapTransportRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.storage.GapTransportRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 运输记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapTransportRecordServiceImpl implements GapTransportRecordService {

    @Resource
    private GapTransportRecordMapper transportRecordMapper;

    @Override
    public Long createTransportRecord(GapTransportRecordSaveReqVO createReqVO) {
        // 1. 插入
        GapTransportRecordDO transportRecord = BeanUtils.toBean(createReqVO, GapTransportRecordDO.class);
        transportRecordMapper.insert(transportRecord);
        return transportRecord.getId();
    }

    @Override
    public void updateTransportRecord(GapTransportRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateTransportRecordExists(updateReqVO.getId());

        // 2. 更新
        GapTransportRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapTransportRecordDO.class);
        transportRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteTransportRecord(Long id) {
        // 1. 校验存在
        validateTransportRecordExists(id);

        // 2. 删除
        transportRecordMapper.deleteById(id);
    }

    @Override
    public GapTransportRecordDO getTransportRecord(Long id) {
        return transportRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapTransportRecordDO> getTransportRecordPage(GapTransportRecordPageReqVO pageReqVO) {
        return transportRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapTransportRecordDO> getTransportRecordList() {
        return transportRecordMapper.selectList();
    }

    @Override
    public List<GapTransportRecordDO> getTransportRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return transportRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapTransportRecordDO> getTransportRecordListByBatchNo(String batchNo) {
        return transportRecordMapper.selectListByBatchNo(batchNo);
    }

    @Override
    public GapTransportRecordDO validateTransportRecordExists(Long id) {
        GapTransportRecordDO transportRecord = transportRecordMapper.selectById(id);
        if (transportRecord == null) {
            throw exception(STORAGE_AREA_NOT_EXISTS);
        }
        return transportRecord;
    }

}
