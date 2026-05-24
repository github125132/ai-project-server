package cn.iocoder.yudao.module.gap.dal.mysql.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentCategoryDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 文件分类 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapDocumentCategoryMapper extends BaseMapperX<GapDocumentCategoryDO> {

    default PageResult<GapDocumentCategoryDO> selectPage(GapDocumentCategoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapDocumentCategoryDO>()
                .eqIfPresent(GapDocumentCategoryDO::getParentId, reqVO.getParentId())
                .likeIfPresent(GapDocumentCategoryDO::getName, reqVO.getName())
                .eqIfPresent(GapDocumentCategoryDO::getCode, reqVO.getCode())
                .eqIfPresent(GapDocumentCategoryDO::getCategoryType, reqVO.getCategoryType())
                .eqIfPresent(GapDocumentCategoryDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapDocumentCategoryDO::getId));
    }

    default List<GapDocumentCategoryDO> selectListByParentId(Long parentId) {
        return selectList(new LambdaQueryWrapperX<GapDocumentCategoryDO>()
                .eq(GapDocumentCategoryDO::getParentId, parentId)
                .orderByAsc(GapDocumentCategoryDO::getSort));
    }

    default GapDocumentCategoryDO selectByCode(String code) {
        return selectOne(GapDocumentCategoryDO::getCode, code);
    }

    default Long selectCountByParentId(Long parentId) {
        return selectCount(GapDocumentCategoryDO::getParentId, parentId);
    }

}
