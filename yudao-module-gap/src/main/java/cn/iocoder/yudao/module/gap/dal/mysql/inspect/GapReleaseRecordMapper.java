package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapReleaseRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 放行审核记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapReleaseRecordMapper extends BaseMapperX<GapReleaseRecordDO> {

    default PageResult<GapReleaseRecordDO> selectPage(GapReleaseRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapReleaseRecordDO>()
                .likeIfPresent(GapReleaseRecordDO::getReleaseNo, reqVO.getReleaseNo())
                .eqIfPresent(GapReleaseRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapReleaseRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapReleaseRecordDO::getSourceType, reqVO.getSourceType())
                .eqIfPresent(GapReleaseRecordDO::getInspectReportId, reqVO.getInspectReportId())
                .eqIfPresent(GapReleaseRecordDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapReleaseRecordDO::getId));
    }

    default GapReleaseRecordDO selectByReleaseNo(String releaseNo) {
        return selectOne(GapReleaseRecordDO::getReleaseNo, releaseNo);
    }

    default List<GapReleaseRecordDO> selectListByBatchNo(String batchNo) {
        return selectList(GapReleaseRecordDO::getBatchNo, batchNo);
    }

}
