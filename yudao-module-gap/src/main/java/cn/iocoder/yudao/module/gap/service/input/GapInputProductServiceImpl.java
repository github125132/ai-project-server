package cn.iocoder.yudao.module.gap.service.input;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputProductSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputProductDO;
import cn.iocoder.yudao.module.gap.dal.mysql.input.GapInputProductMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 投入品产品 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapInputProductServiceImpl implements GapInputProductService {

    @Resource
    private GapInputProductMapper inputProductMapper;

    @Override
    public Long createInputProduct(GapInputProductSaveReqVO createReqVO) {
        // 1. 校验编码唯一
        validateInputProductCodeUnique(null, createReqVO.getCode());

        // 2. 插入
        GapInputProductDO product = BeanUtils.toBean(createReqVO, GapInputProductDO.class);
        inputProductMapper.insert(product);
        return product.getId();
    }

    @Override
    public void updateInputProduct(GapInputProductSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateInputProductExists(updateReqVO.getId());
        // 1.2 校验编码唯一
        validateInputProductCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        // 2. 更新
        GapInputProductDO updateObj = BeanUtils.toBean(updateReqVO, GapInputProductDO.class);
        inputProductMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputProduct(Long id) {
        // 1. 校验存在
        validateInputProductExists(id);

        // 2. 删除
        inputProductMapper.deleteById(id);
    }

    @Override
    public GapInputProductDO getInputProduct(Long id) {
        return inputProductMapper.selectById(id);
    }

    @Override
    public PageResult<GapInputProductDO> getInputProductPage(GapInputProductPageReqVO pageReqVO) {
        return inputProductMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInputProductDO> getInputProductList() {
        return inputProductMapper.selectList();
    }

    @Override
    public List<GapInputProductDO> getInputProductList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inputProductMapper.selectByIds(ids);
    }

    @Override
    public List<GapInputProductDO> getInputProductListByCategoryId(Long categoryId) {
        return inputProductMapper.selectListByCategoryId(categoryId);
    }

    @Override
    public GapInputProductDO validateInputProductExists(Long id) {
        GapInputProductDO product = inputProductMapper.selectById(id);
        if (product == null) {
            throw exception(INPUT_PRODUCT_NOT_EXISTS);
        }
        return product;
    }

    private void validateInputProductCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapInputProductDO product = inputProductMapper.selectByCode(code);
        if (product == null) {
            return;
        }
        if (ObjUtil.notEqual(id, product.getId())) {
            throw exception(INPUT_PRODUCT_CODE_DUPLICATE);
        }
    }

}
