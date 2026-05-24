package cn.iocoder.yudao.module.gap.dal.mysql.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPestControlDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 病虫害防治方案 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapPestControlMapper extends BaseMapperX<GapPestControlDO> {

    default PageResult<GapPestControlDO> selectPage(GapPestControlPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPestControlDO>()
                .eqIfPresent(GapPestControlDO::getPlanNo, reqVO.getPlanNo())
                .eqIfPresent(GapPestControlDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapPestControlDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapPestControlDO::getPestType, reqVO.getPestType())
                .likeIfPresent(GapPestControlDO::getPestName, reqVO.getPestName())
                .eqIfPresent(GapPestControlDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapPestControlDO::getId));
    }

    default List<GapPestControlDO> selectListByBaseId(Long baseId) {
        return selectList(GapPestControlDO::getBaseId, baseId);
    }

    default List<GapPestControlDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapPestControlDO::getVarietyId, varietyId);
    }

}
