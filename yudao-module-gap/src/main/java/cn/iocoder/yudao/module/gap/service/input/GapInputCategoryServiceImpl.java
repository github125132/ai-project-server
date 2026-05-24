package cn.iocoder.yudao.module.gap.service.input;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputCategorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputCategoryDO;
import cn.iocoder.yudao.module.gap.dal.mysql.input.GapInputCategoryMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 投入品分类 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapInputCategoryServiceImpl implements GapInputCategoryService {

    @Resource
    private GapInputCategoryMapper inputCategoryMapper;

    @Override
    public Long createInputCategory(GapInputCategorySaveReqVO createReqVO) {
        // 1. 校验父分类存在
        validateParentExists(createReqVO.getParentId());
        // 1.2 校验名称唯一
        validateInputCategoryNameUnique(null, createReqVO.getName());
        // 1.3 校验编码唯一
        validateInputCategoryCodeUnique(null, createReqVO.getCode());

        // 2. 插入
        GapInputCategoryDO category = BeanUtils.toBean(createReqVO, GapInputCategoryDO.class);
        inputCategoryMapper.insert(category);
        return category.getId();
    }

    @Override
    public void updateInputCategory(GapInputCategorySaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateInputCategoryExists(updateReqVO.getId());
        // 1.2 校验父分类存在
        validateParentExists(updateReqVO.getParentId());
        // 1.3 校验名称唯一
        validateInputCategoryNameUnique(updateReqVO.getId(), updateReqVO.getName());
        // 1.4 校验编码唯一
        validateInputCategoryCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        // 2. 更新
        GapInputCategoryDO updateObj = BeanUtils.toBean(updateReqVO, GapInputCategoryDO.class);
        inputCategoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputCategory(Long id) {
        // 1. 校验存在
        validateInputCategoryExists(id);
        // 1.2 校验是否存在子分类
        Long count = inputCategoryMapper.selectCountByParentId(id);
        if (count > 0) {
            throw exception(INPUT_CATEGORY_EXITS_CHILDREN);
        }

        // 2. 删除
        inputCategoryMapper.deleteById(id);
    }

    @Override
    public GapInputCategoryDO getInputCategory(Long id) {
        return inputCategoryMapper.selectById(id);
    }

    @Override
    public PageResult<GapInputCategoryDO> getInputCategoryPage(GapInputCategoryPageReqVO pageReqVO) {
        return inputCategoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInputCategoryDO> getInputCategoryList() {
        return inputCategoryMapper.selectList();
    }

    @Override
    public List<GapInputCategoryDO> getInputCategoryListByParentId(Long parentId) {
        return inputCategoryMapper.selectListByParentId(parentId);
    }

    @Override
    public GapInputCategoryDO validateInputCategoryExists(Long id) {
        GapInputCategoryDO category = inputCategoryMapper.selectById(id);
        if (category == null) {
            throw exception(INPUT_CATEGORY_NOT_EXISTS);
        }
        return category;
    }

    private void validateParentExists(Long parentId) {
        if (parentId == null || parentId == 0) {
            return;
        }
        GapInputCategoryDO parent = inputCategoryMapper.selectById(parentId);
        if (parent == null) {
            throw exception(INPUT_CATEGORY_PARENT_NOT_EXITS);
        }
    }

    private void validateInputCategoryNameUnique(Long id, String name) {
        if (name == null || name.isEmpty()) {
            return;
        }
        GapInputCategoryDO category = inputCategoryMapper.selectByName(name);
        if (category == null) {
            return;
        }
        if (ObjUtil.notEqual(id, category.getId())) {
            throw exception(INPUT_CATEGORY_NOT_EXISTS);
        }
    }

    private void validateInputCategoryCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapInputCategoryDO category = inputCategoryMapper.selectByCode(code);
        if (category == null) {
            return;
        }
        if (ObjUtil.notEqual(id, category.getId())) {
            throw exception(INPUT_CATEGORY_NOT_EXISTS);
        }
    }

}
