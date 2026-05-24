package cn.iocoder.yudao.module.gap.service.base.facility;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilitySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.facility.GapBaseFacilityDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.facility.GapBaseFacilityMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseFacilityServiceImpl implements GapBaseFacilityService {

    @Resource
    private GapBaseFacilityMapper facilityMapper;

    @Override
    public Long createFacility(GapBaseFacilitySaveReqVO createReqVO) {
        GapBaseFacilityDO facility = BeanUtils.toBean(createReqVO, GapBaseFacilityDO.class);
        facilityMapper.insert(facility);
        return facility.getId();
    }

    @Override
    public void updateFacility(GapBaseFacilitySaveReqVO updateReqVO) {
        validateFacilityExists(updateReqVO.getId());
        GapBaseFacilityDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseFacilityDO.class);
        facilityMapper.updateById(updateObj);
    }

    @Override
    public void deleteFacility(Long id) {
        validateFacilityExists(id);
        facilityMapper.deleteById(id);
    }

    @Override
    public GapBaseFacilityDO getFacility(Long id) {
        return facilityMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseFacilityDO> getFacilityPage(GapBaseFacilityPageReqVO pageReqVO) {
        return facilityMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapBaseFacilityDO> getFacilityListByBaseId(Long baseId) {
        return facilityMapper.selectList(GapBaseFacilityDO::getBaseId, baseId);
    }

    @Override
    public GapBaseFacilityDO validateFacilityExists(Long id) {
        GapBaseFacilityDO facility = facilityMapper.selectById(id);
        if (facility == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return facility;
    }

}
