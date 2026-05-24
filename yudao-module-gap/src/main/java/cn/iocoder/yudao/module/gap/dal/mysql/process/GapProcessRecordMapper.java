package cn.iocoder.yudao.module.gap.dal.mysql.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 加工记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapProcessRecordMapper extends BaseMapperX<GapProcessRecordDO> {

    default PageResult<GapProcessRecordDO> selectPage(GapProcessRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapProcessRecordDO>()
                .likeIfPresent(GapProcessRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapProcessRecordDO::getHarvestRecordId, reqVO.getHarvestRecordId())
                .eqIfPresent(GapProcessRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapProcessRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapProcessRecordDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapProcessRecordDO::getStatus, reqVO.getStatus())
                .geIfPresent(GapProcessRecordDO::getProcessDate, reqVO.getProcessDateStart())
                .leIfPresent(GapProcessRecordDO::getProcessDate, reqVO.getProcessDateEnd())
                .orderByDesc(GapProcessRecordDO::getId));
    }

    default GapProcessRecordDO selectByRecordNo(String recordNo) {
        return selectOne(GapProcessRecordDO::getRecordNo, recordNo);
    }

    default List<GapProcessRecordDO> selectListByVarietyId(Long varietyId) {
        return selectList(GapProcessRecordDO::getVarietyId, varietyId);
    }

}
