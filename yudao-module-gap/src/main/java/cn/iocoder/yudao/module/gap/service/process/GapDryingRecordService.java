package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapDryingRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 干燥记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapDryingRecordService {

    /**
     * 创建干燥记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDryingRecord(@Valid GapDryingRecordSaveReqVO createReqVO);

    /**
     * 更新干燥记录
     *
     * @param updateReqVO 更新信息
     */
    void updateDryingRecord(@Valid GapDryingRecordSaveReqVO updateReqVO);

    /**
     * 删除干燥记录
     *
     * @param id 编号
     */
    void deleteDryingRecord(Long id);

    /**
     * 获得干燥记录
     *
     * @param id 编号
     * @return 干燥记录
     */
    GapDryingRecordDO getDryingRecord(Long id);

    /**
     * 获得干燥记录分页
     *
     * @param pageReqVO 分页查询
     * @return 干燥记录分页
     */
    PageResult<GapDryingRecordDO> getDryingRecordPage(GapDryingRecordPageReqVO pageReqVO);

    /**
     * 获得干燥记录列表
     *
     * @return 干燥记录列表
     */
    List<GapDryingRecordDO> getDryingRecordList();

    /**
     * 根据加工记录编号获得干燥记录列表
     *
     * @param processRecordId 加工记录编号
     * @return 干燥记录列表
     */
    List<GapDryingRecordDO> getDryingRecordListByProcessRecordId(Long processRecordId);

    /**
     * 校验干燥记录存在
     *
     * @param id 编号
     * @return 干燥记录
     */
    GapDryingRecordDO validateDryingRecordExists(Long id);

}
