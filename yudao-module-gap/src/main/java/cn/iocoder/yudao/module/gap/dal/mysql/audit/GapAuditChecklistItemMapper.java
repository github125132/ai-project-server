package cn.iocoder.yudao.module.gap.dal.mysql.audit;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistItemDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 审核检查表项目 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapAuditChecklistItemMapper extends BaseMapperX<GapAuditChecklistItemDO> {

    default PageResult<GapAuditChecklistItemDO> selectPage(GapAuditChecklistItemPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapAuditChecklistItemDO>()
                .eqIfPresent(GapAuditChecklistItemDO::getChecklistId, reqVO.getChecklistId())
                .likeIfPresent(GapAuditChecklistItemDO::getItemNo, reqVO.getItemNo())
                .likeIfPresent(GapAuditChecklistItemDO::getChapter, reqVO.getChapter())
                .likeIfPresent(GapAuditChecklistItemDO::getClause, reqVO.getClause())
                .eqIfPresent(GapAuditChecklistItemDO::getStatus, reqVO.getStatus())
                .orderByAsc(GapAuditChecklistItemDO::getSort)
                .orderByDesc(GapAuditChecklistItemDO::getId));
    }

    default List<GapAuditChecklistItemDO> selectListByChecklistId(Long checklistId) {
        return selectList(GapAuditChecklistItemDO::getChecklistId, checklistId);
    }

}
