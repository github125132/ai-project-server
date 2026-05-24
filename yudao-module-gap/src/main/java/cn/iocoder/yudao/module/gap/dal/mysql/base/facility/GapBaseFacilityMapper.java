package cn.iocoder.yudao.module.gap.dal.mysql.base.facility;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.facility.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.facility.GapBaseFacilityDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapBaseFacilityMapper extends BaseMapperX<GapBaseFacilityDO> {

    default PageResult<GapBaseFacilityDO> selectPage(GapBaseFacilityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseFacilityDO>()
                .eqIfPresent(GapBaseFacilityDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseFacilityDO::getFacilityType, reqVO.getFacilityType())
                .eqIfPresent(GapBaseFacilityDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapBaseFacilityDO::getName, reqVO.getName())
                .likeIfPresent(GapBaseFacilityDO::getCode, reqVO.getCode())
                .orderByDesc(GapBaseFacilityDO::getId));
    }

}
