package cn.iocoder.yudao.module.gap.service.weather;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.weather.GapBaseWeatherDO;
import cn.iocoder.yudao.module.gap.dal.mysql.weather.GapBaseWeatherMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseWeatherServiceImpl implements GapBaseWeatherService {

    @Resource
    private GapBaseWeatherMapper BaseWeatherMapper;

    @Override
    public Long createGapBaseWeather(GapBaseWeatherSaveReqVO createReqVO) {
        GapBaseWeatherDO entity = BeanUtils.toBean(createReqVO, GapBaseWeatherDO.class);
        BaseWeatherMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void updateGapBaseWeather(GapBaseWeatherSaveReqVO updateReqVO) {
        validateGapBaseWeatherExists(updateReqVO.getId());
        GapBaseWeatherDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseWeatherDO.class);
        BaseWeatherMapper.updateById(updateObj);
    }

    @Override
    public void deleteGapBaseWeather(Long id) {
        validateGapBaseWeatherExists(id);
        BaseWeatherMapper.deleteById(id);
    }

    @Override
    public GapBaseWeatherDO getGapBaseWeather(Long id) {
        return BaseWeatherMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseWeatherDO> getGapBaseWeatherPage(GapBaseWeatherPageReqVO pageReqVO) {
        return BaseWeatherMapper.selectPage(pageReqVO);
    }

    @Override
    public GapBaseWeatherDO validateGapBaseWeatherExists(Long id) {
        GapBaseWeatherDO entity = BaseWeatherMapper.selectById(id);
        if (entity == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return entity;
    }
}
