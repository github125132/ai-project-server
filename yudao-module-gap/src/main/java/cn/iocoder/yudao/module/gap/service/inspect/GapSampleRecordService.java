package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapSampleRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapSampleRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 留样记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapSampleRecordService {

    /**
     * 创建留样记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSampleRecord(@Valid GapSampleRecordSaveReqVO createReqVO);

    /**
     * 更新留样记录
     *
     * @param updateReqVO 更新信息
     */
    void updateSampleRecord(@Valid GapSampleRecordSaveReqVO updateReqVO);

    /**
     * 删除留样记录
     *
     * @param id 编号
     */
    void deleteSampleRecord(Long id);

    /**
     * 获得留样记录
     *
     * @param id 编号
     * @return 留样记录
     */
    GapSampleRecordDO getSampleRecord(Long id);

    /**
     * 获得留样记录分页
     *
     * @param pageReqVO 分页查询
     * @return 留样记录分页
     */
    PageResult<GapSampleRecordDO> getSampleRecordPage(GapSampleRecordPageReqVO pageReqVO);

    /**
     * 获得留样记录列表
     *
     * @return 留样记录列表
     */
    List<GapSampleRecordDO> getSampleRecordList();

    /**
     * 获得留样记录列表
     *
     * @param ids 编号集合
     * @return 留样记录列表
     */
    List<GapSampleRecordDO> getSampleRecordList(Collection<Long> ids);

    /**
     * 根据批次号获得留样记录列表
     *
     * @param batchNo 批次号
     * @return 留样记录列表
     */
    List<GapSampleRecordDO> getSampleRecordListByBatchNo(String batchNo);

    /**
     * 校验留样记录存在
     *
     * @param id 编号
     * @return 留样记录
     */
    GapSampleRecordDO validateSampleRecordExists(Long id);

}
