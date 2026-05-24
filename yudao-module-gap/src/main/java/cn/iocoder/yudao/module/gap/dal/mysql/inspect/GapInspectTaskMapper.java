package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectTaskDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 检验任务 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInspectTaskMapper extends BaseMapperX<GapInspectTaskDO> {

    default PageResult<GapInspectTaskDO> selectPage(GapInspectTaskPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInspectTaskDO>()
                .likeIfPresent(GapInspectTaskDO::getTaskNo, reqVO.getTaskNo())
                .eqIfPresent(GapInspectTaskDO::getTaskType, reqVO.getTaskType())
                .eqIfPresent(GapInspectTaskDO::getSourceType, reqVO.getSourceType())
                .eqIfPresent(GapInspectTaskDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapInspectTaskDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapInspectTaskDO::getStandardId, reqVO.getStandardId())
                .eqIfPresent(GapInspectTaskDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInspectTaskDO::getId));
    }

    default GapInspectTaskDO selectByTaskNo(String taskNo) {
        return selectOne(GapInspectTaskDO::getTaskNo, taskNo);
    }

    default List<GapInspectTaskDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapInspectTaskDO::getVarietyId, varietyId);
    }

}
