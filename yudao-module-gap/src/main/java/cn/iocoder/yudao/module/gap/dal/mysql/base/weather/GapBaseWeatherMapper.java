package cn.iocoder.yudao.module.gap.dal.mysql.base.weather;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.weather.GapBaseWeatherPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.weather.GapBaseWeatherDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapBaseWeatherMapper extends BaseMapperX<GapBaseWeatherDO> {

    default PageResult<GapBaseWeatherDO> selectPage(GapBaseWeatherPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseWeatherDO>()
                .eqIfPresent(GapBaseWeatherDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseWeatherDO::getDataSource, reqVO.getDataSource())
                .betweenIfPresent(GapBaseWeatherDO::getRecordDate, reqVO.getRecordDateStart(), reqVO.getRecordDateEnd())
                .orderByDesc(GapBaseWeatherDO::getRecordDate));
    }

}
