package cn.iocoder.yudao.module.gap.dal.mysql.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapOperationLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 业务操作日志 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapOperationLogMapper extends BaseMapperX<GapOperationLogDO> {

    default PageResult<GapOperationLogDO> selectPage(GapOperationLogPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapOperationLogDO>()
                .eqIfPresent(GapOperationLogDO::getLogType, reqVO.getLogType())
                .eqIfPresent(GapOperationLogDO::getModuleType, reqVO.getModuleType())
                .eqIfPresent(GapOperationLogDO::getTableName, reqVO.getTableName())
                .eqIfPresent(GapOperationLogDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(GapOperationLogDO::getOperatorId, reqVO.getOperatorId())
                .eqIfPresent(GapOperationLogDO::getResult, reqVO.getResult())
                .betweenIfPresent(GapOperationLogDO::getOperateTime, reqVO.getOperateTime())
                .orderByDesc(GapOperationLogDO::getId));
    }

    default List<GapOperationLogDO> selectListByOperatorId(Long operatorId) {
        return selectList(new LambdaQueryWrapperX<GapOperationLogDO>()
                .eq(GapOperationLogDO::getOperatorId, operatorId)
                .orderByDesc(GapOperationLogDO::getOperateTime));
    }

}
