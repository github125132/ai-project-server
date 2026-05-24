package cn.iocoder.yudao.module.gap.service.document;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentCategorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentCategoryDO;
import cn.iocoder.yudao.module.gap.dal.mysql.document.GapDocumentCategoryMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 文件分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapDocumentCategoryServiceImpl implements GapDocumentCategoryService {

    @Resource
    private GapDocumentCategoryMapper documentCategoryMapper;

    @Override
    public Long createDocumentCategory(GapDocumentCategorySaveReqVO createReqVO) {
        // 1. 校验编码唯一
        validateDocumentCategoryCodeUnique(null, createReqVO.getCode());

        // 2. 插入
        GapDocumentCategoryDO category = BeanUtils.toBean(createReqVO, GapDocumentCategoryDO.class);
        documentCategoryMapper.insert(category);
        return category.getId();
    }

    @Override
    public void updateDocumentCategory(GapDocumentCategorySaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateDocumentCategoryExists(updateReqVO.getId());
        // 1.2 校验编码唯一
        validateDocumentCategoryCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        // 2. 更新
        GapDocumentCategoryDO updateObj = BeanUtils.toBean(updateReqVO, GapDocumentCategoryDO.class);
        documentCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteDocumentCategory(Long id) {
        // 1. 校验存在
        validateDocumentCategoryExists(id);
        // 1.2 校验是否存在子分类
        Long childCount = documentCategoryMapper.selectCountByParentId(id);
        if (childCount > 0) {
            throw exception(INPUT_CATEGORY_EXITS_CHILDREN);
        }

        // 2. 删除
        documentCategoryMapper.deleteById(id);
    }

    @Override
    public GapDocumentCategoryDO getDocumentCategory(Long id) {
        return documentCategoryMapper.selectById(id);
    }

    @Override
    public PageResult<GapDocumentCategoryDO> getDocumentCategoryPage(GapDocumentCategoryPageReqVO pageReqVO) {
        return documentCategoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapDocumentCategoryDO> getDocumentCategoryList() {
        return documentCategoryMapper.selectList();
    }

    @Override
    public List<GapDocumentCategoryDO> getDocumentCategoryListByParentId(Long parentId) {
        return documentCategoryMapper.selectListByParentId(parentId);
    }

    @Override
    public GapDocumentCategoryDO validateDocumentCategoryExists(Long id) {
        GapDocumentCategoryDO category = documentCategoryMapper.selectById(id);
        if (category == null) {
            throw exception(DOCUMENT_NOT_EXISTS);
        }
        return category;
    }

    private void validateDocumentCategoryCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapDocumentCategoryDO category = documentCategoryMapper.selectByCode(code);
        if (category == null) {
            return;
        }
        if (ObjUtil.notEqual(id, category.getId())) {
            throw exception(BASE_CODE_DUPLICATE);
        }
    }

}
