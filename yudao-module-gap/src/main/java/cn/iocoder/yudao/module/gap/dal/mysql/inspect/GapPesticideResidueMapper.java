package cn.iocoder.yudao.module.gap.dal.mysql.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResiduePageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapPesticideResidueDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 农残检测明细 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapPesticideResidueMapper extends BaseMapperX<GapPesticideResidueDO> {

    default PageResult<GapPesticideResidueDO> selectPage(GapPesticideResiduePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPesticideResidueDO>()
                .eqIfPresent(GapPesticideResidueDO::getTaskId, reqVO.getTaskId())
                .eqIfPresent(GapPesticideResidueDO::getReportId, reqVO.getReportId())
                .eqIfPresent(GapPesticideResidueDO::getBatchNo, reqVO.getBatchNo())
                .likeIfPresent(GapPesticideResidueDO::getPesticideName, reqVO.getPesticideName())
                .eqIfPresent(GapPesticideResidueDO::getPesticideCategory, reqVO.getPesticideCategory())
                .eqIfPresent(GapPesticideResidueDO::getConclusion, reqVO.getConclusion())
                .eqIfPresent(GapPesticideResidueDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapPesticideResidueDO::getId));
    }

    default List<GapPesticideResidueDO> selectListByTaskId(Long taskId) {
        return selectList(GapPesticideResidueDO::getTaskId, taskId);
    }

    default List<GapPesticideResidueDO> selectListByReportId(Long reportId) {
        return selectList(GapPesticideResidueDO::getReportId, reportId);
    }

}
