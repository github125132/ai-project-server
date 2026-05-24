package cn.iocoder.yudao.module.gap.service.base.weather;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.weather.GapBaseWeatherDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.weather.GapBaseWeatherMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapBaseWeatherServiceImpl implements GapBaseWeatherService {

    @Resource
    private GapBaseWeatherMapper weatherMapper;

    @Override
    public Long createWeather(GapBaseWeatherSaveReqVO createReqVO) {
        GapBaseWeatherDO weather = BeanUtils.toBean(createReqVO, GapBaseWeatherDO.class);
        weatherMapper.insert(weather);
        return weather.getId();
    }

    @Override
    public void updateWeather(GapBaseWeatherSaveReqVO updateReqVO) {
        validateWeatherExists(updateReqVO.getId());
        GapBaseWeatherDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseWeatherDO.class);
        weatherMapper.updateById(updateObj);
    }

    @Override
    public void deleteWeather(Long id) {
        validateWeatherExists(id);
        weatherMapper.deleteById(id);
    }

    @Override
    public GapBaseWeatherDO getWeather(Long id) {
        return weatherMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseWeatherDO> getWeatherPage(GapBaseWeatherPageReqVO pageReqVO) {
        return weatherMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapBaseWeatherDO> getWeatherListByBaseId(Long baseId) {
        return weatherMapper.selectList(GapBaseWeatherDO::getBaseId, baseId);
    }

    @Override
    public GapBaseWeatherDO validateWeatherExists(Long id) {
        GapBaseWeatherDO weather = weatherMapper.selectById(id);
        if (weather == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return weather;
    }

}
