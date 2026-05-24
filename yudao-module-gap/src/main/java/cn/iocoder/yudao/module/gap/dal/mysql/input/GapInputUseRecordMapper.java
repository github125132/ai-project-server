package cn.iocoder.yudao.module.gap.dal.mysql.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputUseRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 投入品使用记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInputUseRecordMapper extends BaseMapperX<GapInputUseRecordDO> {

    default PageResult<GapInputUseRecordDO> selectPage(GapInputUseRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInputUseRecordDO>()
                .likeIfPresent(GapInputUseRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapInputUseRecordDO::getProductId, reqVO.getProductId())
                .eqIfPresent(GapInputUseRecordDO::getUseType, reqVO.getUseType())
                .eqIfPresent(GapInputUseRecordDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapInputUseRecordDO::getPlotId, reqVO.getPlotId())
                .eqIfPresent(GapInputUseRecordDO::getPlotBatchNo, reqVO.getPlotBatchNo())
                .eqIfPresent(GapInputUseRecordDO::getOperatorId, reqVO.getOperatorId())
                .eqIfPresent(GapInputUseRecordDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInputUseRecordDO::getId));
    }

    default List<GapInputUseRecordDO> selectListByBaseId(Long baseId) {
        return selectList(GapInputUseRecordDO::getBaseId, baseId);
    }

    default List<GapInputUseRecordDO> selectListByPlotId(Long plotId) {
        return selectList(GapInputUseRecordDO::getPlotId, plotId);
    }

    default GapInputUseRecordDO selectByRecordNo(String recordNo) {
        return selectOne(GapInputUseRecordDO::getRecordNo, recordNo);
    }

}
