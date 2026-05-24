package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapIrrigationRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapIrrigationRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.FARMING_RECORD_NOT_EXISTS;

/**
 * GAP 灌溉记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapIrrigationRecordServiceImpl implements GapIrrigationRecordService {

    @Resource
    private GapIrrigationRecordMapper irrigationRecordMapper;

    @Override
    public Long createIrrigationRecord(GapIrrigationRecordSaveReqVO createReqVO) {
        // 插入
        GapIrrigationRecordDO irrigationRecord = BeanUtils.toBean(createReqVO, GapIrrigationRecordDO.class);
        irrigationRecordMapper.insert(irrigationRecord);
        return irrigationRecord.getId();
    }

    @Override
    public void updateIrrigationRecord(GapIrrigationRecordSaveReqVO updateReqVO) {
        // 校验存在
        validateIrrigationRecordExists(updateReqVO.getId());

        // 更新
        GapIrrigationRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapIrrigationRecordDO.class);
        irrigationRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteIrrigationRecord(Long id) {
        // 校验存在
        validateIrrigationRecordExists(id);

        // 删除
        irrigationRecordMapper.deleteById(id);
    }

    @Override
    public GapIrrigationRecordDO getIrrigationRecord(Long id) {
        return irrigationRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapIrrigationRecordDO> getIrrigationRecordPage(GapIrrigationRecordPageReqVO pageReqVO) {
        return irrigationRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapIrrigationRecordDO> getIrrigationRecordList() {
        return irrigationRecordMapper.selectList();
    }

    @Override
    public List<GapIrrigationRecordDO> getIrrigationRecordListByBaseId(Long baseId) {
        return irrigationRecordMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapIrrigationRecordDO> getIrrigationRecordListByPlotId(Long plotId) {
        return irrigationRecordMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapIrrigationRecordDO validateIrrigationRecordExists(Long id) {
        GapIrrigationRecordDO irrigationRecord = irrigationRecordMapper.selectById(id);
        if (irrigationRecord == null) {
            throw exception(FARMING_RECORD_NOT_EXISTS);
        }
        return irrigationRecord;
    }

}
