package cn.iocoder.yudao.module.gap.service.water;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.water.GapBaseWaterDO;
import cn.iocoder.yudao.module.gap.dal.mysql.water.GapBaseWaterMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseWaterServiceImpl implements GapBaseWaterService {

    @Resource
    private GapBaseWaterMapper BaseWaterMapper;

    @Override
    public Long createGapBaseWater(GapBaseWaterSaveReqVO createReqVO) {
        GapBaseWaterDO entity = BeanUtils.toBean(createReqVO, GapBaseWaterDO.class);
        BaseWaterMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapBaseWater(GapBaseWaterSaveReqVO updateReqVO) {
        validateGapBaseWaterExists(updateReqVO.getId());
        GapBaseWaterDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseWaterDO.class);
        BaseWaterMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapBaseWater(Long id) {
        validateGapBaseWaterExists(id);
        BaseWaterMapper.deleteById(id);
    }

    @Override
    public GapBaseWaterDO getGapBaseWater(Long id) {
        return BaseWaterMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseWaterDO> getGapBaseWaterPage(GapBaseWaterPageReqVO pageReqVO) {
        return BaseWaterMapper.selectPage(pageReqVO);
    }

    @Override
    public GapBaseWaterDO validateGapBaseWaterExists(Long id) {
        GapBaseWaterDO entity = BaseWaterMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
