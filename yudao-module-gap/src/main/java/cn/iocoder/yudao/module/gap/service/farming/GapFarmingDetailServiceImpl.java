package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingDetailDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapFarmingDetailMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.FARMING_RECORD_NOT_EXISTS;

/**
 * GAP 农事记录明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapFarmingDetailServiceImpl implements GapFarmingDetailService {

    @Resource
    private GapFarmingDetailMapper farmingDetailMapper;

    @Override
    public Long createFarmingDetail(GapFarmingDetailSaveReqVO createReqVO) {
        // 插入
        GapFarmingDetailDO farmingDetail = BeanUtils.toBean(createReqVO, GapFarmingDetailDO.class);
        farmingDetailMapper.insert(farmingDetail);
        return farmingDetail.getId();
    }

    @Override
    public void updateFarmingDetail(GapFarmingDetailSaveReqVO updateReqVO) {
        // 校验存在
        validateFarmingDetailExists(updateReqVO.getId());

        // 更新
        GapFarmingDetailDO updateObj = BeanUtils.toBean(updateReqVO, GapFarmingDetailDO.class);
        farmingDetailMapper.updateById(updateObj);
    }

    @Override
    public void deleteFarmingDetail(Long id) {
        // 校验存在
        validateFarmingDetailExists(id);

        // 删除
        farmingDetailMapper.deleteById(id);
    }

    @Override
    public GapFarmingDetailDO getFarmingDetail(Long id) {
        return farmingDetailMapper.selectById(id);
    }

    @Override
    public PageResult<GapFarmingDetailDO> getFarmingDetailPage(GapFarmingDetailPageReqVO pageReqVO) {
        return farmingDetailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapFarmingDetailDO> getFarmingDetailList() {
        return farmingDetailMapper.selectList();
    }

    @Override
    public List<GapFarmingDetailDO> getDetailListByRecordId(Long recordId) {
        return farmingDetailMapper.selectListByRecordId(recordId);
    }

    @Override
    public GapFarmingDetailDO validateFarmingDetailExists(Long id) {
        GapFarmingDetailDO farmingDetail = farmingDetailMapper.selectById(id);
        if (farmingDetail == null) {
            throw exception(FARMING_RECORD_NOT_EXISTS);
        }
        return farmingDetail;
    }

}
