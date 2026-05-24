package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 施肥记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapFertilizationRecordService {

    /**
     * 创建施肥记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFertilizationRecord(@Valid GapFertilizationRecordSaveReqVO createReqVO);

    /**
     * 更新施肥记录
     *
     * @param updateReqVO 更新信息
     */
    void updateFertilizationRecord(@Valid GapFertilizationRecordSaveReqVO updateReqVO);

    /**
     * 删除施肥记录
     *
     * @param id 编号
     */
    void deleteFertilizationRecord(Long id);

    /**
     * 获得施肥记录
     *
     * @param id 编号
     * @return 施肥记录
     */
    GapFertilizationRecordDO getFertilizationRecord(Long id);

    /**
     * 获得施肥记录分页
     *
     * @param pageReqVO 分页查询
     * @return 施肥记录分页
     */
    PageResult<GapFertilizationRecordDO> getFertilizationRecordPage(GapFertilizationRecordPageReqVO pageReqVO);

    /**
     * 获得施肥记录列表
     *
     * @return 施肥记录列表
     */
    List<GapFertilizationRecordDO> getFertilizationRecordList();

    /**
     * 根据基地编号获得施肥记录列表
     *
     * @param baseId 基地编号
     * @return 施肥记录列表
     */
    List<GapFertilizationRecordDO> getFertilizationRecordListByBaseId(Long baseId);

    /**
     * 根据地块编号获得施肥记录列表
     *
     * @param plotId 地块编号
     * @return 施肥记录列表
     */
    List<GapFertilizationRecordDO> getFertilizationRecordListByPlotId(Long plotId);

    /**
     * 校验施肥记录存在
     *
     * @param id 编号
     * @return 施肥记录
     */
    GapFertilizationRecordDO validateFertilizationRecordExists(Long id);

}
