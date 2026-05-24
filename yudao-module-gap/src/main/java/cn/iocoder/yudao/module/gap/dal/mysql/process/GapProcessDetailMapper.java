package cn.iocoder.yudao.module.gap.dal.mysql.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessDetailDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 加工工序明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapProcessDetailMapper extends BaseMapperX<GapProcessDetailDO> {

    default PageResult<GapProcessDetailDO> selectPage(GapProcessDetailPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapProcessDetailDO>()
                .eqIfPresent(GapProcessDetailDO::getProcessRecordId, reqVO.getProcessRecordId())
                .eqIfPresent(GapProcessDetailDO::getProcessStep, reqVO.getProcessStep())
                .likeIfPresent(GapProcessDetailDO::getProcessName, reqVO.getProcessName())
                .eqIfPresent(GapProcessDetailDO::getCheckResult, reqVO.getCheckResult())
                .orderByAsc(GapProcessDetailDO::getProcessStep));
    }

    default List<GapProcessDetailDO> selectListByProcessRecordId(Long processRecordId) {
        return selectList(GapProcessDetailDO::getProcessRecordId, processRecordId);
    }

}
