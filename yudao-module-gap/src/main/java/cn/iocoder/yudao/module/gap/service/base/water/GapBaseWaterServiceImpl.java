package cn.iocoder.yudao.module.gap.service.base.water;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.water.GapBaseWaterDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.water.GapBaseWaterMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseWaterServiceImpl implements GapBaseWaterService {

    @Resource
    private GapBaseWaterMapper waterMapper;

    @Override
    public Long createWater(GapBaseWaterSaveReqVO createReqVO) {
        GapBaseWaterDO water = BeanUtils.toBean(createReqVO, GapBaseWaterDO.class);
        waterMapper.insert(water);
        return water.getId();
    }

    @Override
    public void updateWater(GapBaseWaterSaveReqVO updateReqVO) {
        validateWaterExists(updateReqVO.getId());
        GapBaseWaterDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseWaterDO.class);
        waterMapper.updateById(updateObj);
    }

    @Override
    public void deleteWater(Long id) {
        validateWaterExists(id);
        waterMapper.deleteById(id);
    }

    @Override
    public GapBaseWaterDO getWater(Long id) {
        return waterMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseWaterDO> getWaterPage(GapBaseWaterPageReqVO pageReqVO) {
        return waterMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapBaseWaterDO> getWaterListByBaseId(Long baseId) {
        return waterMapper.selectList(GapBaseWaterDO::getBaseId, baseId);
    }

    @Override
    public GapBaseWaterDO validateWaterExists(Long id) {
        GapBaseWaterDO water = waterMapper.selectById(id);
        if (water == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return water;
    }

}
