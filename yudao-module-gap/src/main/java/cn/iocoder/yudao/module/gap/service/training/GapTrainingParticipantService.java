package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapTrainingParticipantSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapTrainingParticipantDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 培训参训人员 Service 接口
 *
 * @author 芋道源码
 */
public interface GapTrainingParticipantService {

    /**
     * 创建培训参训人员
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTrainingParticipant(@Valid GapTrainingParticipantSaveReqVO createReqVO);

    /**
     * 更新培训参训人员
     *
     * @param updateReqVO 更新信息
     */
    void updateTrainingParticipant(@Valid GapTrainingParticipantSaveReqVO updateReqVO);

    /**
     * 删除培训参训人员
     *
     * @param id 编号
     */
    void deleteTrainingParticipant(Long id);

    /**
     * 获得培训参训人员
     *
     * @param id 编号
     * @return 培训参训人员
     */
    GapTrainingParticipantDO getTrainingParticipant(Long id);

    /**
     * 获得培训参训人员分页
     *
     * @param pageReqVO 分页查询
     * @return 培训参训人员分页
     */
    PageResult<GapTrainingParticipantDO> getTrainingParticipantPage(GapTrainingParticipantPageReqVO pageReqVO);

    /**
     * 获得培训参训人员列表
     *
     * @return 培训参训人员列表
     */
    List<GapTrainingParticipantDO> getTrainingParticipantList();

    /**
     * 根据培训记录编号获得参训人员列表
     *
     * @param recordId 培训记录编号
     * @return 参训人员列表
     */
    List<GapTrainingParticipantDO> getTrainingParticipantListByRecordId(Long recordId);

    /**
     * 校验培训参训人员存在
     *
     * @param id 编号
     * @return 培训参训人员
     */
    GapTrainingParticipantDO validateTrainingParticipantExists(Long id);

}
