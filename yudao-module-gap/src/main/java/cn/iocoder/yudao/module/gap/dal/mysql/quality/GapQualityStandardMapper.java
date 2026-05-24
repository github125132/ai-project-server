package cn.iocoder.yudao.module.gap.dal.mysql.quality;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.quality.GapQualityStandardDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * GAP 质量标准 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapQualityStandardMapper extends BaseMapperX<GapQualityStandardDO> {

    default PageResult<GapQualityStandardDO> selectPage(GapQualityStandardPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapQualityStandardDO>()
                .likeIfPresent(GapQualityStandardDO::getCode, reqVO.getCode())
                .likeIfPresent(GapQualityStandardDO::getName, reqVO.getName())
                .eqIfPresent(GapQualityStandardDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapQualityStandardDO::getStandardLevel, reqVO.getStandardLevel())
                .eqIfPresent(GapQualityStandardDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapQualityStandardDO::getId));
    }

    default GapQualityStandardDO selectByCode(String code) {
        return selectOne(GapQualityStandardDO::getCode, code);
    }

    default Long selectCountByStatus(Integer status) {
        return selectCount(GapQualityStandardDO::getStatus, status);
    }

}
