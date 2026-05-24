package cn.iocoder.yudao.module.gap.dal.mysql.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapSopDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * GAP SOP库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapSopMapper extends BaseMapperX<GapSopDO> {

    default PageResult<GapSopDO> selectPage(GapSopPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapSopDO>()
                .likeIfPresent(GapSopDO::getSopNo, reqVO.getSopNo())
                .likeIfPresent(GapSopDO::getName, reqVO.getName())
                .eqIfPresent(GapSopDO::getCategory, reqVO.getCategory())
                .eqIfPresent(GapSopDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapSopDO::getApproverId, reqVO.getApproverId())
                .orderByDesc(GapSopDO::getId));
    }

    default GapSopDO selectBySopNo(String sopNo) {
        return selectOne(GapSopDO::getSopNo, sopNo);
    }

}
