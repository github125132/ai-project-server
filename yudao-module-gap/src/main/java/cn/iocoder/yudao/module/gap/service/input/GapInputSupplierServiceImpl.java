package cn.iocoder.yudao.module.gap.service.input;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputSupplierDO;
import cn.iocoder.yudao.module.gap.dal.mysql.input.GapInputSupplierMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 投入品供应商 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapInputSupplierServiceImpl implements GapInputSupplierService {

    @Resource
    private GapInputSupplierMapper inputSupplierMapper;

    @Override
    public Long createInputSupplier(GapInputSupplierSaveReqVO createReqVO) {
        // 1. 校验编码唯一
        validateInputSupplierCodeUnique(null, createReqVO.getCode());

        // 2. 插入
        GapInputSupplierDO supplier = BeanUtils.toBean(createReqVO, GapInputSupplierDO.class);
        inputSupplierMapper.insert(supplier);
        return supplier.getId();
    }

    @Override
    public void updateInputSupplier(GapInputSupplierSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateInputSupplierExists(updateReqVO.getId());
        // 1.2 校验编码唯一
        validateInputSupplierCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        // 2. 更新
        GapInputSupplierDO updateObj = BeanUtils.toBean(updateReqVO, GapInputSupplierDO.class);
        inputSupplierMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputSupplier(Long id) {
        // 1. 校验存在
        validateInputSupplierExists(id);

        // 2. 删除
        inputSupplierMapper.deleteById(id);
    }

    @Override
    public GapInputSupplierDO getInputSupplier(Long id) {
        return inputSupplierMapper.selectById(id);
    }

    @Override
    public PageResult<GapInputSupplierDO> getInputSupplierPage(GapInputSupplierPageReqVO pageReqVO) {
        return inputSupplierMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInputSupplierDO> getInputSupplierList() {
        return inputSupplierMapper.selectList();
    }

    @Override
    public List<GapInputSupplierDO> getInputSupplierList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inputSupplierMapper.selectByIds(ids);
    }

    @Override
    public GapInputSupplierDO validateInputSupplierExists(Long id) {
        GapInputSupplierDO supplier = inputSupplierMapper.selectById(id);
        if (supplier == null) {
            throw exception(INPUT_SUPPLIER_NOT_EXISTS);
        }
        return supplier;
    }

    private void validateInputSupplierCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapInputSupplierDO supplier = inputSupplierMapper.selectByCode(code);
        if (supplier == null) {
            return;
        }
        if (ObjUtil.notEqual(id, supplier.getId())) {
            throw exception(INPUT_SUPPLIER_CODE_DUPLICATE);
        }
    }

}
