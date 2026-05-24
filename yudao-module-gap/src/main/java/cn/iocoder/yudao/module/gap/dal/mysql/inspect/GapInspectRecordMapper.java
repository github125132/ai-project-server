package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 检验记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInspectRecordMapper extends BaseMapperX<GapInspectRecordDO> {

    default PageResult<GapInspectRecordDO> selectPage(GapInspectRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInspectRecordDO>()
                .likeIfPresent(GapInspectRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapInspectRecordDO::getTaskId, reqVO.getTaskId())
                .eqIfPresent(GapInspectRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapInspectRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapInspectRecordDO::getInspectType, reqVO.getInspectType())
                .eqIfPresent(GapInspectRecordDO::getConclusion, reqVO.getConclusion())
                .eqIfPresent(GapInspectRecordDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInspectRecordDO::getId));
    }

    default List<GapInspectRecordDO> selectListByTaskId(Long taskId) {
        return selectList(GapInspectRecordDO::getTaskId, taskId);
    }

}
