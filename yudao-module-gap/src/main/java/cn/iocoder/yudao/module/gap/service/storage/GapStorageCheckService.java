package cn.iocoder.yudao.module.gap.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageCheckSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageCheckDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 养护检查记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapStorageCheckService {

    /**
     * 创建养护检查记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createStorageCheck(@Valid GapStorageCheckSaveReqVO createReqVO);

    /**
     * 更新养护检查记录
     *
     * @param updateReqVO 更新信息
     */
    void updateStorageCheck(@Valid GapStorageCheckSaveReqVO updateReqVO);

    /**
     * 删除养护检查记录
     *
     * @param id 编号
     */
    void deleteStorageCheck(Long id);

    /**
     * 获得养护检查记录
     *
     * @param id 编号
     * @return 养护检查记录
     */
    GapStorageCheckDO getStorageCheck(Long id);

    /**
     * 获得养护检查记录分页
     *
     * @param pageReqVO 分页查询
     * @return 养护检查记录分页
     */
    PageResult<GapStorageCheckDO> getStorageCheckPage(GapStorageCheckPageReqVO pageReqVO);

    /**
     * 获得养护检查记录列表
     *
     * @return 养护检查记录列表
     */
    List<GapStorageCheckDO> getStorageCheckList();

    /**
     * 获得养护检查记录列表
     *
     * @param ids 编号集合
     * @return 养护检查记录列表
     */
    List<GapStorageCheckDO> getStorageCheckList(Collection<Long> ids);

    /**
     * 根据仓库编号获得养护检查记录列表
     *
     * @param warehouseId 仓库编号
     * @return 养护检查记录列表
     */
    List<GapStorageCheckDO> getStorageCheckListByWarehouseId(Long warehouseId);

    /**
     * 校验养护检查记录存在
     *
     * @param id 编号
     * @return 养护检查记录
     */
    GapStorageCheckDO validateStorageCheckExists(Long id);

}
