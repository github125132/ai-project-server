package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapReleaseRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapReleaseRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 放行审核记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapReleaseRecordService {

    /**
     * 创建放行审核记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createReleaseRecord(@Valid GapReleaseRecordSaveReqVO createReqVO);

    /**
     * 更新放行审核记录
     *
     * @param updateReqVO 更新信息
     */
    void updateReleaseRecord(@Valid GapReleaseRecordSaveReqVO updateReqVO);

    /**
     * 删除放行审核记录
     *
     * @param id 编号
     */
    void deleteReleaseRecord(Long id);

    /**
     * 获得放行审核记录
     *
     * @param id 编号
     * @return 放行审核记录
     */
    GapReleaseRecordDO getReleaseRecord(Long id);

    /**
     * 获得放行审核记录分页
     *
     * @param pageReqVO 分页查询
     * @return 放行审核记录分页
     */
    PageResult<GapReleaseRecordDO> getReleaseRecordPage(GapReleaseRecordPageReqVO pageReqVO);

    /**
     * 获得放行审核记录列表
     *
     * @return 放行审核记录列表
     */
    List<GapReleaseRecordDO> getReleaseRecordList();

    /**
     * 获得放行审核记录列表
     *
     * @param ids 编号集合
     * @return 放行审核记录列表
     */
    List<GapReleaseRecordDO> getReleaseRecordList(Collection<Long> ids);

    /**
     * 根据批次号获得放行审核记录列表
     *
     * @param batchNo 批次号
     * @return 放行审核记录列表
     */
    List<GapReleaseRecordDO> getReleaseRecordListByBatchNo(String batchNo);

    /**
     * 校验放行审核记录存在
     *
     * @param id 编号
     * @return 放行审核记录
     */
    GapReleaseRecordDO validateReleaseRecordExists(Long id);

}
