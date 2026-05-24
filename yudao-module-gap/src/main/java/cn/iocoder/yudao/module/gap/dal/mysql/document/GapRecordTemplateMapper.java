package cn.iocoder.yudao.module.gap.dal.mysql.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplatePageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapRecordTemplateDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 记录模板 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapRecordTemplateMapper extends BaseMapperX<GapRecordTemplateDO> {

    default PageResult<GapRecordTemplateDO> selectPage(GapRecordTemplatePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapRecordTemplateDO>()
                .eqIfPresent(GapRecordTemplateDO::getCategoryId, reqVO.getCategoryId())
                .likeIfPresent(GapRecordTemplateDO::getTemplateNo, reqVO.getTemplateNo())
                .likeIfPresent(GapRecordTemplateDO::getName, reqVO.getName())
                .eqIfPresent(GapRecordTemplateDO::getTemplateType, reqVO.getTemplateType())
                .eqIfPresent(GapRecordTemplateDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapRecordTemplateDO::getId));
    }

    default List<GapRecordTemplateDO> selectListByCategoryId(Long categoryId) {
        return selectList(new LambdaQueryWrapperX<GapRecordTemplateDO>()
                .eq(GapRecordTemplateDO::getCategoryId, categoryId)
                .orderByDesc(GapRecordTemplateDO::getId));
    }

    default GapRecordTemplateDO selectByTemplateNo(String templateNo) {
        return selectOne(GapRecordTemplateDO::getTemplateNo, templateNo);
    }

}
