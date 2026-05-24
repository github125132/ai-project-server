package cn.iocoder.yudao.module.gap.dal.mysql.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditPlanDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * GAP 审核计划 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapAuditPlanMapper extends BaseMapperX<GapAuditPlanDO> {

    default PageResult<GapAuditPlanDO> selectPage(GapAuditPlanPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapAuditPlanDO>()
                .likeIfPresent(GapAuditPlanDO::getPlanNo, reqVO.getPlanNo())
                .eqIfPresent(GapAuditPlanDO::getYear, reqVO.getYear())
                .likeIfPresent(GapAuditPlanDO::getPlanName, reqVO.getPlanName())
                .eqIfPresent(GapAuditPlanDO::getAuditType, reqVO.getAuditType())
                .eqIfPresent(GapAuditPlanDO::getAuditorLeaderId, reqVO.getAuditorLeaderId())
                .eqIfPresent(GapAuditPlanDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapAuditPlanDO::getId));
    }

    default GapAuditPlanDO selectByPlanNo(String planNo) {
        return selectOne(GapAuditPlanDO::getPlanNo, planNo);
    }

}
