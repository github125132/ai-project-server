package cn.iocoder.yudao.module.gap.dal.mysql.weather;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.weather.vo.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.weather.GapBaseWeatherDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapBaseWeatherMapper extends BaseMapperX<GapBaseWeatherDO> {

    default PageResult<GapBaseWeatherDO> selectPage(GapBaseWeatherPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseWeatherDO>()
                .eqIfPresent(GapBaseWeatherDO::getId, reqVO.getId())
                .eqIfPresent(GapBaseWeatherDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseWeatherDO::getRecordDate, reqVO.getRecordDate())
                .eqIfPresent(GapBaseWeatherDO::getMaxTemp, reqVO.getMaxTemp())
                .eqIfPresent(GapBaseWeatherDO::getMinTemp, reqVO.getMinTemp())
                .eqIfPresent(GapBaseWeatherDO::getAvgTemp, reqVO.getAvgTemp())
                .eqIfPresent(GapBaseWeatherDO::getPrecipitation, reqVO.getPrecipitation())
                .eqIfPresent(GapBaseWeatherDO::getHumidity, reqVO.getHumidity())
                .eqIfPresent(GapBaseWeatherDO::getSunshineHours, reqVO.getSunshineHours())
                .eqIfPresent(GapBaseWeatherDO::getWindSpeed, reqVO.getWindSpeed())
                .likeIfPresent(GapBaseWeatherDO::getWindDirection, reqVO.getWindDirection())
                .likeIfPresent(GapBaseWeatherDO::getWeatherDesc, reqVO.getWeatherDesc())
                .eqIfPresent(GapBaseWeatherDO::getFrostFreeDays, reqVO.getFrostFreeDays())
                .eqIfPresent(GapBaseWeatherDO::getDataSource, reqVO.getDataSource())
                .orderByDesc(GapBaseWeatherDO::getId));
    }
    default List<GapBaseWeatherDO> selectListByBaseId(Long baseId) {
        return selectList(GapBaseWeatherDO::getBaseId, baseId);
    }
}
