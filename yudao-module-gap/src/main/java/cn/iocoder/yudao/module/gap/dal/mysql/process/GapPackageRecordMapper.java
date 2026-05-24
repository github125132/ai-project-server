package cn.iocoder.yudao.module.gap.dal.mysql.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapPackageRecordDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 包装记录 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapPackageRecordMapper extends BaseMapperX<GapPackageRecordDO> {

    default PageResult<GapPackageRecordDO> selectPage(GapPackageRecordPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPackageRecordDO>()
                .eqIfPresent(GapPackageRecordDO::getProcessRecordId, reqVO.getProcessRecordId())
                .likeIfPresent(GapPackageRecordDO::getRecordNo, reqVO.getRecordNo())
                .eqIfPresent(GapPackageRecordDO::getBatchNo, reqVO.getBatchNo())
                .eqIfPresent(GapPackageRecordDO::getVarietyId, reqVO.getVarietyId())
                .eqIfPresent(GapPackageRecordDO::getStatus, reqVO.getStatus())
                .geIfPresent(GapPackageRecordDO::getPackageDate, reqVO.getPackageDateStart())
                .leIfPresent(GapPackageRecordDO::getPackageDate, reqVO.getPackageDateEnd())
                .orderByDesc(GapPackageRecordDO::getId));
    }

    default List<GapPackageRecordDO> selectListByProcessRecordId(Long processRecordId) {
        return selectList(GapPackageRecordDO::getProcessRecordId, processRecordId);
    }

}
