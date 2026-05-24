package cn.iocoder.yudao.module.gap.dal.mysql.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 投入品分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInputCategoryMapper extends BaseMapperX<GapInputCategoryDO> {

    default PageResult<GapInputCategoryDO> selectPage(GapInputCategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInputCategoryDO>()
                .likeIfPresent(GapInputCategoryDO::getName, reqVO.getName())
                .eqIfPresent(GapInputCategoryDO::getCode, reqVO.getCode())
                .eqIfPresent(GapInputCategoryDO::getCategoryType, reqVO.getCategoryType())
                .eqIfPresent(GapInputCategoryDO::getParentId, reqVO.getParentId())
                .eqIfPresent(GapInputCategoryDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInputCategoryDO::getId));
    }

    default List<GapInputCategoryDO> selectListByParentId(Long parentId) {
        return selectList(GapInputCategoryDO::getParentId, parentId);
    }

    default Long selectCountByParentId(Long parentId) {
        return selectCount(GapInputCategoryDO::getParentId, parentId);
    }

    default GapInputCategoryDO selectByName(String name) {
        return selectOne(GapInputCategoryDO::getName, name);
    }

    default GapInputCategoryDO selectByCode(String code) {
        return selectOne(GapInputCategoryDO::getCode, code);
    }

}
