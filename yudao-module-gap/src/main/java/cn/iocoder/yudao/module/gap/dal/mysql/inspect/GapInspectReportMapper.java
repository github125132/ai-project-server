package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectReportDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 检验报告 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInspectReportMapper extends BaseMapperX<GapInspectReportDO> {

    default PageResult<GapInspectReportDO> selectPage(GapInspectReportPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInspectReportDO>()
                .likeIfPresent(GapInspectReportDO::getReportNo, reqVO.getReportNo())
                .eqIfPresent(GapInspectReportDO::getTaskId, reqVO.getTaskId())
                .eqIfPresent(GapInspectReportDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapInspectReportDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapInspectReportDO::getReportType, reqVO.getReportType())
                .eqIfPresent(GapInspectReportDO::getOverallConclusion, reqVO.getOverallConclusion())
                .eqIfPresent(GapInspectReportDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInspectReportDO::getId));
    }

    default GapInspectReportDO selectByReportNo(String reportNo) {
        return selectOne(GapInspectReportDO::getReportNo, reportNo);
    }

    default List<GapInspectReportDO> selectListByTaskId(Long taskId) {
        return selectList(GapInspectReportDO::getTaskId, taskId);
    }

}
