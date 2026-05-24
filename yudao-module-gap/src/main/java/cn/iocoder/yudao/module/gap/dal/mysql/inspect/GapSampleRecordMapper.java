package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapSampleRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 留样记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapSampleRecordMapper extends BaseMapperX<GapSampleRecordDO> {

    default PageResult<GapSampleRecordDO> selectPage(GapSampleRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapSampleRecordDO>()
                .likeIfPresent(GapSampleRecordDO::getSampleNo, reqVO.getSampleNo())
                .eqIfPresent(GapSampleRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapSampleRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapSampleRecordDO::getInspectTaskId, reqVO.getInspectTaskId())
                .eqIfPresent(GapSampleRecordDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapSampleRecordDO::getId));
    }

    default GapSampleRecordDO selectBySampleNo(String sampleNo) {
        return selectOne(GapSampleRecordDO::getSampleNo, sampleNo);
    }

    default List<GapSampleRecordDO> selectListByBatchNo(String batchNo) {
        return selectList(GapSampleRecordDO::getBatchNo, batchNo);
    }

}
