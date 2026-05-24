package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 农事记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapFarmingRecordService {

    /**
     * 创建农事记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFarmingRecord(@Valid GapFarmingRecordSaveReqVO createReqVO);

    /**
     * 更新农事记录
     *
     * @param updateReqVO 更新信息
     */
    void updateFarmingRecord(@Valid GapFarmingRecordSaveReqVO updateReqVO);

    /**
     * 删除农事记录
     *
     * @param id 编号
     */
    void deleteFarmingRecord(Long id);

    /**
     * 获得农事记录
     *
     * @param id 编号
     * @return 农事记录
     */
    GapFarmingRecordDO getFarmingRecord(Long id);

    /**
     * 获得农事记录分页
     *
     * @param pageReqVO 分页查询
     * @return 农事记录分页
     */
    PageResult<GapFarmingRecordDO> getFarmingRecordPage(GapFarmingRecordPageReqVO pageReqVO);

    /**
     * 获得农事记录列表
     *
     * @return 农事记录列表
     */
    List<GapFarmingRecordDO> getFarmingRecordList();

    /**
     * 根据基地编号获得农事记录列表
     *
     * @param baseId 基地编号
     * @return 农事记录列表
     */
    List<GapFarmingRecordDO> getFarmingRecordListByBaseId(Long baseId);

    /**
     * 根据地块编号获得农事记录列表
     *
     * @param plotId 地块编号
     * @return 农事记录列表
     */
    List<GapFarmingRecordDO> getFarmingRecordListByPlotId(Long plotId);

    /**
     * 校验农事记录存在
     *
     * @param id 编号
     * @return 农事记录
     */
    GapFarmingRecordDO validateFarmingRecordExists(Long id);

}
