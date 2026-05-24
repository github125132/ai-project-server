package cn.iocoder.yudao.module.gap.dal.mysql.facility;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.facility.vo.GapBaseFacilityPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.facility.GapBaseFacilityDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapBaseFacilityMapper extends BaseMapperX<GapBaseFacilityDO> {

    default PageResult<GapBaseFacilityDO> selectPage(GapBaseFacilityPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseFacilityDO>()
                .eqIfPresent(GapBaseFacilityDO::getId, reqVO.getId())
                .eqIfPresent(GapBaseFacilityDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseFacilityDO::getFacilityType, reqVO.getFacilityType())
                .likeIfPresent(GapBaseFacilityDO::getName, reqVO.getName())
                .likeIfPresent(GapBaseFacilityDO::getCode, reqVO.getCode())
                .likeIfPresent(GapBaseFacilityDO::getSpecification, reqVO.getSpecification())
                .eqIfPresent(GapBaseFacilityDO::getQuantity, reqVO.getQuantity())
                .likeIfPresent(GapBaseFacilityDO::getUnit, reqVO.getUnit())
                .eqIfPresent(GapBaseFacilityDO::getBuildDate, reqVO.getBuildDate())
                .eqIfPresent(GapBaseFacilityDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapBaseFacilityDO::getLocationDesc, reqVO.getLocationDesc())
                .likeIfPresent(GapBaseFacilityDO::getPhotoUrl, reqVO.getPhotoUrl())
                .orderByDesc(GapBaseFacilityDO::getId));
    }
    default List<GapBaseFacilityDO> selectListByBaseId(Long baseId) {
        return selectList(GapBaseFacilityDO::getBaseId, baseId);
    }
}
