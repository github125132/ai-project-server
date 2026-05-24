package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapWasteDisposalDO;
import cn.iocoder.yudao.module.gap.dal.mysql.input.GapWasteDisposalMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapWasteDisposalServiceImpl implements GapWasteDisposalService {

    @Resource
    private GapWasteDisposalMapper wasteDisposalMapper;

    @Override
    public Long createGapWasteDisposal(GapWasteDisposalSaveReqVO createReqVO) {
        GapWasteDisposalDO entity = BeanUtils.toBean(createReqVO, GapWasteDisposalDO.class);
        wasteDisposalMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapWasteDisposal(GapWasteDisposalSaveReqVO updateReqVO) {
        validateGapWasteDisposalExists(updateReqVO.getId());
        GapWasteDisposalDO updateObj = BeanUtils.toBean(updateReqVO, GapWasteDisposalDO.class);
        wasteDisposalMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapWasteDisposal(Long id) {
        validateGapWasteDisposalExists(id);
        wasteDisposalMapper.deleteById(id);
    }

    @Override
    public GapWasteDisposalDO getGapWasteDisposal(Long id) {
        return wasteDisposalMapper.selectById(id);
    }

    @Override
    public PageResult<GapWasteDisposalDO> getGapWasteDisposalPage(GapWasteDisposalPageReqVO pageReqVO) {
        return wasteDisposalMapper.selectPage(pageReqVO);
    }

    @Override
    public GapWasteDisposalDO validateGapWasteDisposalExists(Long id) {
        GapWasteDisposalDO entity = wasteDisposalMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
