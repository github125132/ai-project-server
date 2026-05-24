package cn.iocoder.yudao.module.gap.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageAreaSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageAreaDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 仓库分区 Service 接口
 *
 * @author 芋道源码
 */
public interface GapStorageAreaService {

    /**
     * 创建仓库分区
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createStorageArea(@Valid GapStorageAreaSaveReqVO createReqVO);

    /**
     * 更新仓库分区
     *
     * @param updateReqVO 更新信息
     */
    void updateStorageArea(@Valid GapStorageAreaSaveReqVO updateReqVO);

    /**
     * 删除仓库分区
     *
     * @param id 编号
     */
    void deleteStorageArea(Long id);

    /**
     * 获得仓库分区
     *
     * @param id 编号
     * @return 仓库分区
     */
    GapStorageAreaDO getStorageArea(Long id);

    /**
     * 获得仓库分页
     *
     * @param pageReqVO 分页查询
     * @return 仓库分页
     */
    PageResult<GapStorageAreaDO> getStorageAreaPage(GapStorageAreaPageReqVO pageReqVO);

    /**
     * 获得仓库分区列表
     *
     * @return 仓库分区列表
     */
    List<GapStorageAreaDO> getStorageAreaList();

    /**
     * 获得仓库分区列表
     *
     * @param ids 编号集合
     * @return 仓库分区列表
     */
    List<GapStorageAreaDO> getStorageAreaList(Collection<Long> ids);

    /**
     * 根据仓库编号获得仓库分区列表
     *
     * @param warehouseId 仓库编号
     * @return 仓库分区列表
     */
    List<GapStorageAreaDO> getStorageAreaListByWarehouseId(Long warehouseId);

    /**
     * 校验仓库分区存在
     *
     * @param id 编号
     * @return 仓库分区
     */
    GapStorageAreaDO validateStorageAreaExists(Long id);

}
