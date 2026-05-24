package cn.iocoder.yudao.module.gap.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapTransportRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapTransportRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 运输记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapTransportRecordService {

    /**
     * 创建运输记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTransportRecord(@Valid GapTransportRecordSaveReqVO createReqVO);

    /**
     * 更新运输记录
     *
     * @param updateReqVO 更新信息
     */
    void updateTransportRecord(@Valid GapTransportRecordSaveReqVO updateReqVO);

    /**
     * 删除运输记录
     *
     * @param id 编号
     */
    void deleteTransportRecord(Long id);

    /**
     * 获得运输记录
     *
     * @param id 编号
     * @return 运输记录
     */
    GapTransportRecordDO getTransportRecord(Long id);

    /**
     * 获得运输记录分页
     *
     * @param pageReqVO 分页查询
     * @return 运输记录分页
     */
    PageResult<GapTransportRecordDO> getTransportRecordPage(GapTransportRecordPageReqVO pageReqVO);

    /**
     * 获得运输记录列表
     *
     * @return 运输记录列表
     */
    List<GapTransportRecordDO> getTransportRecordList();

    /**
     * 获得运输记录列表
     *
     * @param ids 编号集合
     * @return 运输记录列表
     */
    List<GapTransportRecordDO> getTransportRecordList(Collection<Long> ids);

    /**
     * 根据批次号获得运输记录列表
     *
     * @param batchNo 批次号
     * @return 运输记录列表
     */
    List<GapTransportRecordDO> getTransportRecordListByBatchNo(String batchNo);

    /**
     * 校验运输记录存在
     *
     * @param id 编号
     * @return 运输记录
     */
    GapTransportRecordDO validateTransportRecordExists(Long id);

}
