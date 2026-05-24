package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapHeavyMetalDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 重金属检测明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapHeavyMetalMapper extends BaseMapperX<GapHeavyMetalDO> {

    default PageResult<GapHeavyMetalDO> selectPage(GapHeavyMetalPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapHeavyMetalDO>()
                .eqIfPresent(GapHeavyMetalDO::getTaskId, reqVO.getTaskId())
                .eqIfPresent(GapHeavyMetalDO::getReportId, reqVO.getReportId())
                .eqIfPresent(GapHeavyMetalDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapHeavyMetalDO::getElementName, reqVO.getElementName())
                .eqIfPresent(GapHeavyMetalDO::getConclusion, reqVO.getConclusion())
                .eqIfPresent(GapHeavyMetalDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapHeavyMetalDO::getId));
    }

    default List<GapHeavyMetalDO> selectListByTaskId(Long taskId) {
        return selectList(GapHeavyMetalDO::getTaskId, taskId);
    }

    default List<GapHeavyMetalDO> selectListByReportId(Long reportId) {
        return selectList(GapHeavyMetalDO::getReportId, reportId);
    }

}
