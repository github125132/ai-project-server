package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapIrrigationRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapIrrigationRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 灌溉记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapIrrigationRecordService {

    /**
     * 创建灌溉记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createIrrigationRecord(@Valid GapIrrigationRecordSaveReqVO createReqVO);

    /**
     * 更新灌溉记录
     *
     * @param updateReqVO 更新信息
     */
    void updateIrrigationRecord(@Valid GapIrrigationRecordSaveReqVO updateReqVO);

    /**
     * 删除灌溉记录
     *
     * @param id 编号
     */
    void deleteIrrigationRecord(Long id);

    /**
     * 获得灌溉记录
     *
     * @param id 编号
     * @return 灌溉记录
     */
    GapIrrigationRecordDO getIrrigationRecord(Long id);

    /**
     * 获得灌溉记录分页
     *
     * @param pageReqVO 分页查询
     * @return 灌溉记录分页
     */
    PageResult<GapIrrigationRecordDO> getIrrigationRecordPage(GapIrrigationRecordPageReqVO pageReqVO);

    /**
     * 获得灌溉记录列表
     *
     * @return 灌溉记录列表
     */
    List<GapIrrigationRecordDO> getIrrigationRecordList();

    /**
     * 根据基地编号获得灌溉记录列表
     *
     * @param baseId 基地编号
     * @return 灌溉记录列表
     */
    List<GapIrrigationRecordDO> getIrrigationRecordListByBaseId(Long baseId);

    /**
     * 根据地块编号获得灌溉记录列表
     *
     * @param plotId 地块编号
     * @return 灌溉记录列表
     */
    List<GapIrrigationRecordDO> getIrrigationRecordListByPlotId(Long plotId);

    /**
     * 校验灌溉记录存在
     *
     * @param id 编号
     * @return 灌溉记录
     */
    GapIrrigationRecordDO validateIrrigationRecordExists(Long id);

}
