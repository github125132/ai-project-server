package cn.iocoder.yudao.module.gap.service.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataReviewDO;
import cn.iocoder.yudao.module.gap.dal.mysql.log.GapDataReviewMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapDataReviewServiceImpl implements GapDataReviewService {

    @Resource
    private GapDataReviewMapper DataReviewMapper;

    @Override
    public Long createGapDataReview(GapDataReviewSaveReqVO createReqVO) {
        GapDataReviewDO entity = BeanUtils.toBean(createReqVO, GapDataReviewDO.class);
        DataReviewMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapDataReview(GapDataReviewSaveReqVO updateReqVO) {
        validateGapDataReviewExists(updateReqVO.getId());
        GapDataReviewDO updateObj = BeanUtils.toBean(updateReqVO, GapDataReviewDO.class);
        DataReviewMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapDataReview(Long id) {
        validateGapDataReviewExists(id);
        DataReviewMapper.deleteById(id);
    }

    @Override
    public GapDataReviewDO getGapDataReview(Long id) {
        return DataReviewMapper.selectById(id);
    }

    @Override
    public PageResult<GapDataReviewDO> getGapDataReviewPage(GapDataReviewPageReqVO pageReqVO) {
        return DataReviewMapper.selectPage(pageReqVO);
    }

    @Override
    public GapDataReviewDO validateGapDataReviewExists(Long id) {
        GapDataReviewDO entity = DataReviewMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
