package cn.iocoder.yudao.module.gap.dal.mysql.log;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataReviewPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataReviewDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 关键数据复核记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapDataReviewMapper extends BaseMapperX<GapDataReviewDO> {

    default PageResult<GapDataReviewDO> selectPage(GapDataReviewPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapDataReviewDO>()
                .eqIfPresent(GapDataReviewDO::getTableName, reqVO.getTableName())
                .eqIfPresent(GapDataReviewDO::getRecordId, reqVO.getRecordId())
                .eqIfPresent(GapDataReviewDO::getReviewType, reqVO.getReviewType())
                .eqIfPresent(GapDataReviewDO::getReviewResult, reqVO.getReviewResult())
                .eqIfPresent(GapDataReviewDO::getReviewerId, reqVO.getReviewerId())
                .eqIfPresent(GapDataReviewDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapDataReviewDO::getReviewTime, reqVO.getReviewTime())
                .betweenIfPresent(GapDataReviewDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GapDataReviewDO::getId));
    }

    default List<GapDataReviewDO> selectListByTableName(String tableName) {
        return selectList(new LambdaQueryWrapperX<GapDataReviewDO>()
                .eq(GapDataReviewDO::getTableName, tableName)
                .orderByDesc(GapDataReviewDO::getReviewTime));
    }

    default List<GapDataReviewDO> selectListByRecordId(Long recordId) {
        return selectList(new LambdaQueryWrapperX<GapDataReviewDO>()
                .eq(GapDataReviewDO::getRecordId, recordId)
                .orderByDesc(GapDataReviewDO::getReviewTime));
    }

}
