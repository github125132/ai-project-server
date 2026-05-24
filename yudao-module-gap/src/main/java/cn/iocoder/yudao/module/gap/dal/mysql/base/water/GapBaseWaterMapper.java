package cn.iocoder.yudao.module.gap.dal.mysql.base.water;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.water.GapBaseWaterDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapBaseWaterMapper extends BaseMapperX<GapBaseWaterDO> {

    default PageResult<GapBaseWaterDO> selectPage(GapBaseWaterPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseWaterDO>()
                .eqIfPresent(GapBaseWaterDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseWaterDO::getWaterType, reqVO.getWaterType())
                .eqIfPresent(GapBaseWaterDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapBaseWaterDO::getSampleNo, reqVO.getSampleNo())
                .betweenIfPresent(GapBaseWaterDO::getSampleDate, reqVO.getSampleDateStart(), reqVO.getSampleDateEnd())
                .orderByDesc(GapBaseWaterDO::getId));
    }

}
