package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputSupplierDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 投入品供应商 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInputSupplierService {

    /**
     * 创建供应商档案
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInputSupplier(@Valid GapInputSupplierSaveReqVO createReqVO);

    /**
     * 更新供应商档案
     *
     * @param updateReqVO 更新信息
     */
    void updateInputSupplier(@Valid GapInputSupplierSaveReqVO updateReqVO);

    /**
     * 删除供应商档案
     *
     * @param id 编号
     */
    void deleteInputSupplier(Long id);

    /**
     * 获得供应商档案
     *
     * @param id 编号
     * @return 供应商档案
     */
    GapInputSupplierDO getInputSupplier(Long id);

    /**
     * 获得供应商档案分页
     *
     * @param pageReqVO 分页查询
     * @return 供应商档案分页
     */
    PageResult<GapInputSupplierDO> getInputSupplierPage(GapInputSupplierPageReqVO pageReqVO);

    /**
     * 获得供应商档案列表
     *
     * @return 供应商档案列表
     */
    List<GapInputSupplierDO> getInputSupplierList();

    /**
     * 获得供应商档案列表
     *
     * @param ids 供应商编号集合
     * @return 供应商档案列表
     */
    List<GapInputSupplierDO> getInputSupplierList(Collection<Long> ids);

    /**
     * 校验供应商档案存在
     *
     * @param id 编号
     * @return 供应商档案
     */
    GapInputSupplierDO validateInputSupplierExists(Long id);

}
