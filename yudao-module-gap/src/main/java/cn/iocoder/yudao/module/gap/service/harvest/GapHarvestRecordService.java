package cn.iocoder.yudao.module.gap.service.harvest;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 采收记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapHarvestRecordService {

    /**
     * 创建采收记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHarvestRecord(@Valid GapHarvestRecordSaveReqVO createReqVO);

    /**
     * 更新采收记录
     *
     * @param updateReqVO 更新信息
     */
    void updateHarvestRecord(@Valid GapHarvestRecordSaveReqVO updateReqVO);

    /**
     * 删除采收记录
     *
     * @param id 编号
     */
    void deleteHarvestRecord(Long id);

    /**
     * 获得采收记录
     *
     * @param id 编号
     * @return 采收记录
     */
    GapHarvestRecordDO getHarvestRecord(Long id);

    /**
     * 获得采收记录分页
     *
     * @param pageReqVO 分页查询
     * @return 采收记录分页
     */
    PageResult<GapHarvestRecordDO> getHarvestRecordPage(GapHarvestRecordPageReqVO pageReqVO);

    /**
     * 获得采收记录列表
     *
     * @return 采收记录列表
     */
    List<GapHarvestRecordDO> getHarvestRecordList();

    /**
     * 根据基地编号获得采收记录列表
     *
     * @param baseId 基地编号
     * @return 采收记录列表
     */
    List<GapHarvestRecordDO> getHarvestRecordListByBaseId(Long baseId);

    /**
     * 根据地块编号获得采收记录列表
     *
     * @param plotId 地块编号
     * @return 采收记录列表
     */
    List<GapHarvestRecordDO> getHarvestRecordListByPlotId(Long plotId);

    /**
     * 校验采收记录存在
     *
     * @param id 编号
     * @return 采收记录
     */
    GapHarvestRecordDO validateHarvestRecordExists(Long id);

}
