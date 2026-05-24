package cn.iocoder.yudao.module.gap.dal.mysql.base;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.GapBaseInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * GAP 基地信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapBaseInfoMapper extends BaseMapperX<GapBaseInfoDO> {

    default PageResult<GapBaseInfoDO> selectPage(GapBaseInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseInfoDO>()
                .likeIfPresent(GapBaseInfoDO::getCode, reqVO.getCode())
                .likeIfPresent(GapBaseInfoDO::getName, reqVO.getName())
                .eqIfPresent(GapBaseInfoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapBaseInfoDO::getProvince, reqVO.getProvince())
                .eqIfPresent(GapBaseInfoDO::getCity, reqVO.getCity())
                .orderByDesc(GapBaseInfoDO::getId));
    }

    default GapBaseInfoDO selectByCode(String code) {
        return selectOne(GapBaseInfoDO::getCode, code);
    }

    default GapBaseInfoDO selectByName(String name) {
        return selectOne(GapBaseInfoDO::getName, name);
    }

    default Long selectCountByStatus(Integer status) {
        return selectCount(GapBaseInfoDO::getStatus, status);
    }

}
