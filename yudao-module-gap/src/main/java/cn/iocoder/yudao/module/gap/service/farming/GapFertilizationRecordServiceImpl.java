package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapFertilizationRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.FARMING_RECORD_NOT_EXISTS;

/**
 * GAP 施肥记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapFertilizationRecordServiceImpl implements GapFertilizationRecordService {

    @Resource
    private GapFertilizationRecordMapper fertilizationRecordMapper;

    @Override
    public Long createFertilizationRecord(GapFertilizationRecordSaveReqVO createReqVO) {
        // 插入
        GapFertilizationRecordDO fertilizationRecord = BeanUtils.toBean(createReqVO, GapFertilizationRecordDO.class);
        fertilizationRecordMapper.insert(fertilizationRecord);
        return fertilizationRecord.getId();
    }

    @Override
    public void updateFertilizationRecord(GapFertilizationRecordSaveReqVO updateReqVO) {
        // 校验存在
        validateFertilizationRecordExists(updateReqVO.getId());

        // 更新
        GapFertilizationRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapFertilizationRecordDO.class);
        fertilizationRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteFertilizationRecord(Long id) {
        // 校验存在
        validateFertilizationRecordExists(id);

        // 删除
        fertilizationRecordMapper.deleteById(id);
    }

    @Override
    public GapFertilizationRecordDO getFertilizationRecord(Long id) {
        return fertilizationRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapFertilizationRecordDO> getFertilizationRecordPage(GapFertilizationRecordPageReqVO pageReqVO) {
        return fertilizationRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapFertilizationRecordDO> getFertilizationRecordList() {
        return fertilizationRecordMapper.selectList();
    }

    @Override
    public List<GapFertilizationRecordDO> getFertilizationRecordListByBaseId(Long baseId) {
        return fertilizationRecordMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapFertilizationRecordDO> getFertilizationRecordListByPlotId(Long plotId) {
        return fertilizationRecordMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapFertilizationRecordDO validateFertilizationRecordExists(Long id) {
        GapFertilizationRecordDO fertilizationRecord = fertilizationRecordMapper.selectById(id);
        if (fertilizationRecord == null) {
            throw exception(FARMING_RECORD_NOT_EXISTS);
        }
        return fertilizationRecord;
    }

}
