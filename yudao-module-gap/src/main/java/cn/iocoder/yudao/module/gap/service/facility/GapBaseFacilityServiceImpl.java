package cn.iocoder.yudao.module.gap.service.facility;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilitySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.facility.GapBaseFacilityDO;
import cn.iocoder.yudao.module.gap.dal.mysql.facility.GapBaseFacilityMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseFacilityServiceImpl implements GapBaseFacilityService {

    @Resource
    private GapBaseFacilityMapper BaseFacilityMapper;

    @Override
    public Long createGapBaseFacility(GapBaseFacilitySaveReqVO createReqVO) {
        GapBaseFacilityDO entity = BeanUtils.toBean(createReqVO, GapBaseFacilityDO.class);
        BaseFacilityMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapBaseFacility(GapBaseFacilitySaveReqVO updateReqVO) {
        validateGapBaseFacilityExists(updateReqVO.getId());
        GapBaseFacilityDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseFacilityDO.class);
        BaseFacilityMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapBaseFacility(Long id) {
        validateGapBaseFacilityExists(id);
        BaseFacilityMapper.deleteById(id);
    }

    @Override
    public GapBaseFacilityDO getGapBaseFacility(Long id) {
        return BaseFacilityMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseFacilityDO> getGapBaseFacilityPage(GapBaseFacilityPageReqVO pageReqVO) {
        return BaseFacilityMapper.selectPage(pageReqVO);
    }

    @Override
    public GapBaseFacilityDO validateGapBaseFacilityExists(Long id) {
        GapBaseFacilityDO entity = BaseFacilityMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
