package cn.iocoder.yudao.module.gap.service.soil;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.soil.GapBaseSoilDO;
import cn.iocoder.yudao.module.gap.dal.mysql.soil.GapBaseSoilMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseSoilServiceImpl implements GapBaseSoilService {

    @Resource
    private GapBaseSoilMapper BaseSoilMapper;

    @Override
    public Long createGapBaseSoil(GapBaseSoilSaveReqVO createReqVO) {
        GapBaseSoilDO entity = BeanUtils.toBean(createReqVO, GapBaseSoilDO.class);
        BaseSoilMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapBaseSoil(GapBaseSoilSaveReqVO updateReqVO) {
        validateGapBaseSoilExists(updateReqVO.getId());
        GapBaseSoilDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseSoilDO.class);
        BaseSoilMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapBaseSoil(Long id) {
        validateGapBaseSoilExists(id);
        BaseSoilMapper.deleteById(id);
    }

    @Override
    public GapBaseSoilDO getGapBaseSoil(Long id) {
        return BaseSoilMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseSoilDO> getGapBaseSoilPage(GapBaseSoilPageReqVO pageReqVO) {
        return BaseSoilMapper.selectPage(pageReqVO);
    }

    @Override
    public GapBaseSoilDO validateGapBaseSoilExists(Long id) {
        GapBaseSoilDO entity = BaseSoilMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
