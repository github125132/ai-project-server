package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationDetailDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapFertilizationDetailMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.FARMING_RECORD_NOT_EXISTS;

/**
 * GAP 施肥明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapFertilizationDetailServiceImpl implements GapFertilizationDetailService {

    @Resource
    private GapFertilizationDetailMapper fertilizationDetailMapper;

    @Override
    public Long createFertilizationDetail(GapFertilizationDetailSaveReqVO createReqVO) {
        // 插入
        GapFertilizationDetailDO fertilizationDetail = BeanUtils.toBean(createReqVO, GapFertilizationDetailDO.class);
        fertilizationDetailMapper.insert(fertilizationDetail);
        return fertilizationDetail.getId();
    }

    @Override
    public void updateFertilizationDetail(GapFertilizationDetailSaveReqVO updateReqVO) {
        // 校验存在
        validateFertilizationDetailExists(updateReqVO.getId());

        // 更新
        GapFertilizationDetailDO updateObj = BeanUtils.toBean(updateReqVO, GapFertilizationDetailDO.class);
        fertilizationDetailMapper.updateById(updateObj);
    }

    @Override
    public void deleteFertilizationDetail(Long id) {
        // 校验存在
        validateFertilizationDetailExists(id);

        // 删除
        fertilizationDetailMapper.deleteById(id);
    }

    @Override
    public GapFertilizationDetailDO getFertilizationDetail(Long id) {
        return fertilizationDetailMapper.selectById(id);
    }

    @Override
    public PageResult<GapFertilizationDetailDO> getFertilizationDetailPage(GapFertilizationDetailPageReqVO pageReqVO) {
        return fertilizationDetailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapFertilizationDetailDO> getFertilizationDetailList() {
        return fertilizationDetailMapper.selectList();
    }

    @Override
    public List<GapFertilizationDetailDO> getDetailListByRecordId(Long recordId) {
        return fertilizationDetailMapper.selectListByRecordId(recordId);
    }

    @Override
    public GapFertilizationDetailDO validateFertilizationDetailExists(Long id) {
        GapFertilizationDetailDO fertilizationDetail = fertilizationDetailMapper.selectById(id);
        if (fertilizationDetail == null) {
            throw exception(FARMING_RECORD_NOT_EXISTS);
        }
        return fertilizationDetail;
    }

}
