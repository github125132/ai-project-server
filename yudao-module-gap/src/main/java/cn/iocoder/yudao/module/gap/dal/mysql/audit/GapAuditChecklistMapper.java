package cn.iocoder.yudao.module.gap.dal.mysql.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 审核检查表 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapAuditChecklistMapper extends BaseMapperX<GapAuditChecklistDO> {

    default PageResult<GapAuditChecklistDO> selectPage(GapAuditChecklistPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapAuditChecklistDO>()
                .likeIfPresent(GapAuditChecklistDO::getChecklistNo, reqVO.getChecklistNo())
                .eqIfPresent(GapAuditChecklistDO::getPlanId, reqVO.getPlanId())
                .likeIfPresent(GapAuditChecklistDO::getName, reqVO.getName())
                .eqIfPresent(GapAuditChecklistDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapAuditChecklistDO::getId));
    }

    default GapAuditChecklistDO selectByChecklistNo(String checklistNo) {
        return selectOne(GapAuditChecklistDO::getChecklistNo, checklistNo);
    }

    default List<GapAuditChecklistDO> selectListByPlanId(Long planId) {
        return selectList(GapAuditChecklistDO::getPlanId, planId);
    }

}
