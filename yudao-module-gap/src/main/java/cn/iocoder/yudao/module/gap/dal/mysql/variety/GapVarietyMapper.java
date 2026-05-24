package cn.iocoder.yudao.module.gap.dal.mysql.variety;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietyPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.variety.GapVarietyDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GapVarietyMapper extends BaseMapperX<GapVarietyDO> {

    default PageResult<GapVarietyDO> selectPage(GapVarietyPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapVarietyDO>()
                .likeIfPresent(GapVarietyDO::getCode, reqVO.getCode())
                .likeIfPresent(GapVarietyDO::getName, reqVO.getName())
                .eqIfPresent(GapVarietyDO::getStatus, reqVO.getStatus())
                .likeIfPresent(GapVarietyDO::getFamily, reqVO.getFamily())
                .likeIfPresent(GapVarietyDO::getMedicinalPart, reqVO.getMedicinalPart())
                .orderByDesc(GapVarietyDO::getId));
    }

    default GapVarietyDO selectByCode(String code) {
        return selectOne(GapVarietyDO::getCode, code);
    }

}
