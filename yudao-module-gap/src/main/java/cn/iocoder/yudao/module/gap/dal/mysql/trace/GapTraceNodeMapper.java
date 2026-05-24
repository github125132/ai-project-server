package cn.iocoder.yudao.module.gap.dal.mysql.trace;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodePageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceNodeDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 溯源节点 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapTraceNodeMapper extends BaseMapperX<GapTraceNodeDO> {

    default PageResult<GapTraceNodeDO> selectPage(GapTraceNodePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapTraceNodeDO>()
                .eqIfPresent(GapTraceNodeDO::getTraceBatchId, reqVO.getTraceBatchId())
                .eqIfPresent(GapTraceNodeDO::getTraceCode, reqVO.getTraceCode())
                .eqIfPresent(GapTraceNodeDO::getNodeType, reqVO.getNodeType())
                .likeIfPresent(GapTraceNodeDO::getNodeName, reqVO.getNodeName())
                .betweenIfPresent(GapTraceNodeDO::getNodeTime, reqVO.getNodeTime())
                .betweenIfPresent(GapTraceNodeDO::getCreateTime, reqVO.getCreateTime())
                .orderByAsc(GapTraceNodeDO::getSort)
                .orderByDesc(GapTraceNodeDO::getId));
    }

    default List<GapTraceNodeDO> selectListByTraceBatchId(Long traceBatchId) {
        return selectList(new LambdaQueryWrapperX<GapTraceNodeDO>()
                .eq(GapTraceNodeDO::getTraceBatchId, traceBatchId)
                .orderByAsc(GapTraceNodeDO::getSort));
    }

}
