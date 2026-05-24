package cn.iocoder.yudao.module.gap.dal.mysql.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * GAP 文件档案 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapDocumentMapper extends BaseMapperX<GapDocumentDO> {

    default PageResult<GapDocumentDO> selectPage(GapDocumentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapDocumentDO>()
                .eqIfPresent(GapDocumentDO::getCategoryId, reqVO.getCategoryId())
                .likeIfPresent(GapDocumentDO::getDocNo, reqVO.getDocNo())
                .likeIfPresent(GapDocumentDO::getName, reqVO.getName())
                .eqIfPresent(GapDocumentDO::getStatus, reqVO.getStatus())
                .eqIfPresent(GapDocumentDO::getDrafterId, reqVO.getDrafterId())
                .eqIfPresent(GapDocumentDO::getApproverId, reqVO.getApproverId())
                .orderByDesc(GapDocumentDO::getId));
    }

    default List<GapDocumentDO> selectListByCategoryId(Long categoryId) {
        return selectList(new LambdaQueryWrapperX<GapDocumentDO>()
                .eq(GapDocumentDO::getCategoryId, categoryId)
                .orderByDesc(GapDocumentDO::getId));
    }

    default GapDocumentDO selectByDocNo(String docNo) {
        return selectOne(GapDocumentDO::getDocNo, docNo);
    }

}
