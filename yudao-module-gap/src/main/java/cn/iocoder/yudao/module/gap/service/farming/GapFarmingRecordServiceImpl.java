package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapFarmingRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.FARMING_RECORD_NOT_EXISTS;

/**
 * GAP 农事记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapFarmingRecordServiceImpl implements GapFarmingRecordService {

    @Resource
    private GapFarmingRecordMapper farmingRecordMapper;

    @Override
    public Long createFarmingRecord(GapFarmingRecordSaveReqVO createReqVO) {
        // 插入
        GapFarmingRecordDO farmingRecord = BeanUtils.toBean(createReqVO, GapFarmingRecordDO.class);
        farmingRecordMapper.insert(farmingRecord);
        return farmingRecord.getId();
    }

    @Override
    public void updateFarmingRecord(GapFarmingRecordSaveReqVO updateReqVO) {
        // 校验存在
        validateFarmingRecordExists(updateReqVO.getId());

        // 更新
        GapFarmingRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapFarmingRecordDO.class);
        farmingRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteFarmingRecord(Long id) {
        // 校验存在
        validateFarmingRecordExists(id);

        // 删除
        farmingRecordMapper.deleteById(id);
    }

    @Override
    public GapFarmingRecordDO getFarmingRecord(Long id) {
        return farmingRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapFarmingRecordDO> getFarmingRecordPage(GapFarmingRecordPageReqVO pageReqVO) {
        return farmingRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapFarmingRecordDO> getFarmingRecordList() {
        return farmingRecordMapper.selectList();
    }

    @Override
    public List<GapFarmingRecordDO> getFarmingRecordListByBaseId(Long baseId) {
        return farmingRecordMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapFarmingRecordDO> getFarmingRecordListByPlotId(Long plotId) {
        return farmingRecordMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapFarmingRecordDO validateFarmingRecordExists(Long id) {
        GapFarmingRecordDO farmingRecord = farmingRecordMapper.selectById(id);
        if (farmingRecord == null) {
            throw exception(FARMING_RECORD_NOT_EXISTS);
        }
        return farmingRecord;
    }

}
