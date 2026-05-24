package cn.iocoder.yudao.module.gap.dal.mysql.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapNcItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 不符合项 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapNcItemMapper extends BaseMapperX<GapNcItemDO> {

    default PageResult<GapNcItemDO> selectPage(GapNcItemPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapNcItemDO>()
                .likeIfPresent(GapNcItemDO::getNcNo, reqVO.getNcNo())
                .eqIfPresent(GapNcItemDO::getPlanId, reqVO.getPlanId())
                .eqIfPresent(GapNcItemDO::getChecklistId, reqVO.getChecklistId())
                .eqIfPresent(GapNcItemDO::getNcType, reqVO.getNcType())
                .eqIfPresent(GapNcItemDO::getAuditedDeptId, reqVO.getAuditedDeptId())
                .eqIfPresent(GapNcItemDO::getResponsibleUserId, reqVO.getResponsibleUserId())
                .eqIfPresent(GapNcItemDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapNcItemDO::getId));
    }

    default GapNcItemDO selectByNcNo(String ncNo) {
        return selectOne(GapNcItemDO::getNcNo, ncNo);
    }

    default List<GapNcItemDO> selectListByPlanId(Long planId) {
        return selectList(GapNcItemDO::getPlanId, planId);
    }

}
