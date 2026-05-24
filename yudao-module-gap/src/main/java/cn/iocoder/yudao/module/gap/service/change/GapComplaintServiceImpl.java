package cn.iocoder.yudao.module.gap.service.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapComplaintDO;
import cn.iocoder.yudao.module.gap.dal.mysql.change.GapComplaintMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.COMPLAINT_NOT_EXISTS;

@Service
@Validated
public class GapComplaintServiceImpl implements GapComplaintService {

    @Resource
    private GapComplaintMapper ComplaintMapper;

    @Override
    public Long createGapComplaint(GapComplaintSaveReqVO createReqVO) {
        GapComplaintDO entity = BeanUtils.toBean(createReqVO, GapComplaintDO.class);
        ComplaintMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapComplaint(GapComplaintSaveReqVO updateReqVO) {
        validateGapComplaintExists(updateReqVO.getId());
        GapComplaintDO updateObj = BeanUtils.toBean(updateReqVO, GapComplaintDO.class);
        ComplaintMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapComplaint(Long id) {
        validateGapComplaintExists(id);
        ComplaintMapper.deleteById(id);
    }

    @Override
    public GapComplaintDO getGapComplaint(Long id) {
        return ComplaintMapper.selectById(id);
    }

    @Override
    public PageResult<GapComplaintDO> getGapComplaintPage(GapComplaintPageReqVO pageReqVO) {
        return ComplaintMapper.selectPage(pageReqVO);
    }

    @Override
    public GapComplaintDO validateGapComplaintExists(Long id) {
        GapComplaintDO entity = ComplaintMapper.selectById(id);
        if (entity == null) {
            throw exception(COMPLAINT_NOT_EXISTS);
        }
        return entity;
    }
}
