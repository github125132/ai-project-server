package cn.iocoder.yudao.module.gap.dal.mysql.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapComplaintPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapComplaintDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 投诉记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapComplaintMapper extends BaseMapperX<GapComplaintDO> {

    default PageResult<GapComplaintDO> selectPage(GapComplaintPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapComplaintDO>()
                .eqIfPresent(GapComplaintDO::getComplaintType, reqVO.getComplaintType())
                .likeIfPresent(GapComplaintDO::getComplaintNo, reqVO.getComplaintNo())
                .likeIfPresent(GapComplaintDO::getComplainant, reqVO.getComplainant())
                .eqIfPresent(GapComplaintDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapComplaintDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapComplaintDO::getVarietyId, reqVO.getVarietyId())
                .betweenIfPresent(GapComplaintDO::getComplaintDate, reqVO.getComplaintDate())
                .betweenIfPresent(GapComplaintDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GapComplaintDO::getId));
    }

    default GapComplaintDO selectByComplaintNo(String complaintNo) {
        return selectOne(GapComplaintDO::getComplaintNo, complaintNo);
    }

    default List<GapComplaintDO> selectListByBatchNo(String batchNo) {
        return selectList(GapComplaintDO::getBatchNo, batchNo);
    }

}
