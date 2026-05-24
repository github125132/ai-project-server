package cn.iocoder.yudao.module.gap.dal.mysql.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 投入品产品 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInputProductMapper extends BaseMapperX<GapInputProductDO> {

    default PageResult<GapInputProductDO> selectPage(GapInputProductPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInputProductDO>()
                .likeIfPresent(GapInputProductDO::getCode, reqVO.getCode())
                .likeIfPresent(GapInputProductDO::getName, reqVO.getName())
                .eqIfPresent(GapInputProductDO::getCategoryId, reqVO.getCategoryId())
                .eqIfPresent(GapInputProductDO::getCategoryType, reqVO.getCategoryType())
                .eqIfPresent(GapInputProductDO::getManufacturer, reqVO.getManufacturer())
                .eqIfPresent(GapInputProductDO::getBanned, reqVO.getBanned())
                .eqIfPresent(GapInputProductDO::getRestricted, reqVO.getRestricted())
                .eqIfPresent(GapInputProductDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInputProductDO::getId));
    }

    default List<GapInputProductDO> selectListByCategoryId(Long categoryId) {
        return selectList(GapInputProductDO::getCategoryId, categoryId);
    }

    default GapInputProductDO selectByCode(String code) {
        return selectOne(GapInputProductDO::getCode, code);
    }

    default List<GapInputProductDO> selectListByStatus(Integer status) {
        return selectList(GapInputProductDO::getStatus, status);
    }

}
