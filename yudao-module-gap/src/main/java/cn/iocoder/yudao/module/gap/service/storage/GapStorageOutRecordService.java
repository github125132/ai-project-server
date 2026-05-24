package cn.iocoder.yudao.module.gap.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapStorageOutRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapStorageOutRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 药材出库记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapStorageOutRecordService {

    /**
     * 创建出库记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createStorageOutRecord(@Valid GapStorageOutRecordSaveReqVO createReqVO);

    /**
     * 更新出库记录
     *
     * @param updateReqVO 更新信息
     */
    void updateStorageOutRecord(@Valid GapStorageOutRecordSaveReqVO updateReqVO);

    /**
     * 删除出库记录
     *
     * @param id 编号
     */
    void deleteStorageOutRecord(Long id);

    /**
     * 获得出库记录
     *
     * @param id 编号
     * @return 出库记录
     */
    GapStorageOutRecordDO getStorageOutRecord(Long id);

    /**
     * 获得出库记录分页
     *
     * @param pageReqVO 分页查询
     * @return 出库记录分页
     */
    PageResult<GapStorageOutRecordDO> getStorageOutRecordPage(GapStorageOutRecordPageReqVO pageReqVO);

    /**
     * 获得出库记录列表
     *
     * @return 出库记录列表
     */
    List<GapStorageOutRecordDO> getStorageOutRecordList();

    /**
     * 获得出库记录列表
     *
     * @param ids 编号集合
     * @return 出库记录列表
     */
    List<GapStorageOutRecordDO> getStorageOutRecordList(Collection<Long> ids);

    /**
     * 根据仓库编号获得出库记录列表
     *
     * @param warehouseId 仓库编号
     * @return 出库记录列表
     */
    List<GapStorageOutRecordDO> getStorageOutRecordListByWarehouseId(Long warehouseId);

    /**
     * 校验出库记录存在
     *
     * @param id 编号
     * @return 出库记录
     */
    GapStorageOutRecordDO validateStorageOutRecordExists(Long id);

}
