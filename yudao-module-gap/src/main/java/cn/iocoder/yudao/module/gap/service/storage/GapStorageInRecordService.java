package cn.iocoder.yudao.module.gap.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageInRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageInRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 药材入库记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapStorageInRecordService {

    /**
     * 创建入库记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createStorageInRecord(@Valid GapStorageInRecordSaveReqVO createReqVO);

    /**
     * 更新入库记录
     *
     * @param updateReqVO 更新信息
     */
    void updateStorageInRecord(@Valid GapStorageInRecordSaveReqVO updateReqVO);

    /**
     * 删除入库记录
     *
     * @param id 编号
     */
    void deleteStorageInRecord(Long id);

    /**
     * 获得入库记录
     *
     * @param id 编号
     * @return 入库记录
     */
    GapStorageInRecordDO getStorageInRecord(Long id);

    /**
     * 获得入库记录分页
     *
     * @param pageReqVO 分页查询
     * @return 入库记录分页
     */
    PageResult<GapStorageInRecordDO> getStorageInRecordPage(GapStorageInRecordPageReqVO pageReqVO);

    /**
     * 获得入库记录列表
     *
     * @return 入库记录列表
     */
    List<GapStorageInRecordDO> getStorageInRecordList();

    /**
     * 获得入库记录列表
     *
     * @param ids 编号集合
     * @return 入库记录列表
     */
    List<GapStorageInRecordDO> getStorageInRecordList(Collection<Long> ids);

    /**
     * 根据仓库编号获得入库记录列表
     *
     * @param warehouseId 仓库编号
     * @return 入库记录列表
     */
    List<GapStorageInRecordDO> getStorageInRecordListByWarehouseId(Long warehouseId);

    /**
     * 根据品种编号获得入库记录列表
     *
     * @param varietyId 品种编号
     * @return 入库记录列表
     */
    List<GapStorageInRecordDO> getStorageInRecordListByVarietyId(Long varietyId);

    /**
     * 校验入库记录存在
     *
     * @param id 编号
     * @return 入库记录
     */
    GapStorageInRecordDO validateStorageInRecordExists(Long id);

}
