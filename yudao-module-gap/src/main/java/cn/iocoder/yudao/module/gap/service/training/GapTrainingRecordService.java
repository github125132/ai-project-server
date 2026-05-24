package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 培训记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapTrainingRecordService {

    /**
     * 创建培训记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTrainingRecord(@Valid GapTrainingRecordSaveReqVO createReqVO);

    /**
     * 更新培训记录
     *
     * @param updateReqVO 更新信息
     */
    void updateTrainingRecord(@Valid GapTrainingRecordSaveReqVO updateReqVO);

    /**
     * 删除培训记录
     *
     * @param id 编号
     */
    void deleteTrainingRecord(Long id);

    /**
     * 获得培训记录
     *
     * @param id 编号
     * @return 培训记录
     */
    GapTrainingRecordDO getTrainingRecord(Long id);

    /**
     * 获得培训记录分页
     *
     * @param pageReqVO 分页查询
     * @return 培训记录分页
     */
    PageResult<GapTrainingRecordDO> getTrainingRecordPage(GapTrainingRecordPageReqVO pageReqVO);

    /**
     * 获得培训记录列表
     *
     * @return 培训记录列表
     */
    List<GapTrainingRecordDO> getTrainingRecordList();

    /**
     * 根据培训计划编号获得培训记录列表
     *
     * @param planId 培训计划编号
     * @return 培训记录列表
     */
    List<GapTrainingRecordDO> getTrainingRecordListByPlanId(Long planId);

    /**
     * 校验培训记录存在
     *
     * @param id 编号
     * @return 培训记录
     */
    GapTrainingRecordDO validateTrainingRecordExists(Long id);

}
