package cn.iocoder.yudao.module.gap.dal.mysql.base.soil;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.soil.GapBaseSoilDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapBaseSoilMapper extends BaseMapperX<GapBaseSoilDO> {

    default PageResult<GapBaseSoilDO> selectPage(GapBaseSoilPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseSoilDO>()
                .eqIfPresent(GapBaseSoilDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseSoilDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapBaseSoilDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapBaseSoilDO::getSampleNo, reqVO.getSampleNo())
                .betweenIfPresent(GapBaseSoilDO::getSampleDate, reqVO.getSampleDateStart(), reqVO.getSampleDateEnd())
                .orderByDesc(GapBaseSoilDO::getId));
    }

    default GapBaseSoilDO selectBySampleNo(String sampleNo) {
        return selectOne(GapBaseSoilDO::getSampleNo, sampleNo);
    }

}
