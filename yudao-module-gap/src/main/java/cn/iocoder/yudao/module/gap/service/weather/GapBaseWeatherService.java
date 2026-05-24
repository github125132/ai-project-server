package cn.iocoder.yudao.module.gap.service.weather;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.weather.GapBaseWeatherDO;
import jakarta.validation.Valid;

import java.util.List;

public interface GapBaseWeatherService {

    Long createGapBaseWeather(@Valid GapBaseWeatherSaveReqVO createReqVO);

    void updateGapBaseWeather(@Valid GapBaseWeatherSaveReqVO updateReqVO);

    void deleteGapBaseWeather(Long id);

    GapBaseWeatherDO getGapBaseWeather(Long id);

    PageResult<GapBaseWeatherDO> getGapBaseWeatherPage(GapBaseWeatherPageReqVO pageReqVO);

    GapBaseWeatherDO validateGapBaseWeatherExists(Long id);
}
