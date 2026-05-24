package cn.iocoder.yudao.module.gap.dal.mysql.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandlePageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapUnqualifiedHandleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 不合格品处理 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapUnqualifiedHandleMapper extends BaseMapperX<GapUnqualifiedHandleDO> {

    default PageResult<GapUnqualifiedHandleDO> selectPage(GapUnqualifiedHandlePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapUnqualifiedHandleDO>()
                .likeIfPresent(GapUnqualifiedHandleDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapUnqualifiedHandleDO::getSourceType, reqVO.getSourceType())
                .likeIfPresent(GapUnqualifiedHandleDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapUnqualifiedHandleDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapUnqualifiedHandleDO::getHandleMethod, reqVO.getHandleMethod())
                .eqIfPresent(GapUnqualifiedHandleDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(GapUnqualifiedHandleDO::getHandleDate, reqVO.getHandleDate())
                .orderByDesc(GapUnqualifiedHandleDO::getId));
    }

    default List<GapUnqualifiedHandleDO> selectListByBatchNo(String batchNo) {
        return selectList(GapUnqualifiedHandleDO::getBatchNo, batchNo);
    }

}
