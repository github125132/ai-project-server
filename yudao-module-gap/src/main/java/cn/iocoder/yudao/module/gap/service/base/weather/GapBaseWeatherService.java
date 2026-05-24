package cn.iocoder.yudao.module.gap.service.base.weather;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.weather.GapBaseWeatherDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseWeatherService {

    Long createWeather(@Valid GapBaseWeatherSaveReqVO createReqVO);

    void updateWeather(@Valid GapBaseWeatherSaveReqVO updateReqVO);

    void deleteWeather(Long id);

    GapBaseWeatherDO getWeather(Long id);

    PageResult<GapBaseWeatherDO> getWeatherPage(GapBaseWeatherPageReqVO pageReqVO);

    List<GapBaseWeatherDO> getWeatherListByBaseId(Long baseId);

    GapBaseWeatherDO validateWeatherExists(Long id);

}
