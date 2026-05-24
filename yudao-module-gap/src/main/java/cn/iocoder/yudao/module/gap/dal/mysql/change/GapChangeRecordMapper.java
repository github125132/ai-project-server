package cn.iocoder.yudao.module.gap.dal.mysql.change;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.change.vo.GapChangeRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.change.GapChangeRecordDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * GAP 变更记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapChangeRecordMapper extends BaseMapperX<GapChangeRecordDO> {

    default PageResult<GapChangeRecordDO> selectPage(GapChangeRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapChangeRecordDO>()
                .eqIfPresent(GapChangeRecordDO::getChangeType, reqVO.getChangeType())
                .likeIfPresent(GapChangeRecordDO::getChangeNo, reqVO.getChangeNo())
                .likeIfPresent(GapChangeRecordDO::getChangeTitle, reqVO.getChangeTitle())
                .eqIfPresent(GapChangeRecordDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapChangeRecordDO::getProposerId, reqVO.getProposerId())
                .betweenIfPresent(GapChangeRecordDO::getProposeDate, reqVO.getProposeDate())
                .betweenIfPresent(GapChangeRecordDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(GapChangeRecordDO::getId));
    }

    default GapChangeRecordDO selectByChangeNo(String changeNo) {
        return selectOne(GapChangeRecordDO::getChangeNo, changeNo);
    }

}
