package cn.iocoder.yudao.module.gap.dal.mysql.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataChangeLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 数据变更日志(审计追踪) Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapDataChangeLogMapper extends BaseMapperX<GapDataChangeLogDO> {

    default PageResult<GapDataChangeLogDO> selectPage(GapDataChangeLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapDataChangeLogDO>()
                .eqIfPresent(GapDataChangeLogDO::getTableName, reqVO.getTableName())
                .eqIfPresent(GapDataChangeLogDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(GapDataChangeLogDO::getChangeType, reqVO.getChangeType())
                .eqIfPresent(GapDataChangeLogDO::getFieldName, reqVO.getFieldName())
                .eqIfPresent(GapDataChangeLogDO::getOperatorId, reqVO.getOperatorId())
                .betweenIfPresent(GapDataChangeLogDO::getOperateTime, reqVO.getOperateTime())
                .orderByDesc(GapDataChangeLogDO::getId));
    }

    default List<GapDataChangeLogDO> selectListByTableName(String tableName) {
        return selectList(new LambdaQueryWrapperX<GapDataChangeLogDO>()
                .eq(GapDataChangeLogDO::getTableName, tableName)
                .orderByDesc(GapDataChangeLogDO::getOperateTime));
    }

    default List<GapDataChangeLogDO> selectListByRecordId(Long recordId) {
        return selectList(new LambdaQueryWrapperX<GapDataChangeLogDO>()
                .eq(GapDataChangeLogDO::getRecordId, recordId)
                .orderByDesc(GapDataChangeLogDO::getOperateTime));
    }

}
