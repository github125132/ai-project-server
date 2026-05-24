package cn.iocoder.yudao.module.gap.dal.mysql.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapPersonHealthDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 人员健康档案 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapPersonHealthMapper extends BaseMapperX<GapPersonHealthDO> {

    default PageResult<GapPersonHealthDO> selectPage(GapPersonHealthPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapPersonHealthDO>()
                .eqIfPresent(GapPersonHealthDO::getUserId, reqVO.getUserId())
                .eqIfPresent(GapPersonHealthDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapPersonHealthDO::getIsQualified, reqVO.getIsQualified())
                .betweenIfPresent(GapPersonHealthDO::getCheckDate, reqVO.getCheckDate())
                .betweenIfPresent(GapPersonHealthDO::getValidityDate, reqVO.getValidityDate())
                .orderByDesc(GapPersonHealthDO::getId));
    }

    default List<GapPersonHealthDO> selectListByUserId(Long userId) {
        return selectList(GapPersonHealthDO::getUserId, userId);
    }

}
