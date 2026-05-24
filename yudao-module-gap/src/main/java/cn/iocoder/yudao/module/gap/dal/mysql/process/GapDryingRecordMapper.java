package cn.iocoder.yudao.module.gap.dal.mysql.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapDryingRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 干燥记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapDryingRecordMapper extends BaseMapperX<GapDryingRecordDO> {

    default PageResult<GapDryingRecordDO> selectPage(GapDryingRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapDryingRecordDO>()
                .eqIfPresent(GapDryingRecordDO::getProcessRecordId, reqVO.getProcessRecordId())
                .eqIfPresent(GapDryingRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapDryingRecordDO::getDryingMethod, reqVO.getDryingMethod())
                .eqIfPresent(GapDryingRecordDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapDryingRecordDO::getId));
    }

    default List<GapDryingRecordDO> selectListByProcessRecordId(Long processRecordId) {
        return selectList(GapDryingRecordDO::getProcessRecordId, processRecordId);
    }

}
