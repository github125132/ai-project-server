package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingDetailDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 农事记录明细 Service 接口
 *
 * @author 芋道源码
 */
public interface GapFarmingDetailService {

    /**
     * 创建农事记录明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFarmingDetail(@Valid GapFarmingDetailSaveReqVO createReqVO);

    /**
     * 更新农事记录明细
     *
     * @param updateReqVO 更新信息
     */
    void updateFarmingDetail(@Valid GapFarmingDetailSaveReqVO updateReqVO);

    /**
     * 删除农事记录明细
     *
     * @param id 编号
     */
    void deleteFarmingDetail(Long id);

    /**
     * 获得农事记录明细
     *
     * @param id 编号
     * @return 农事记录明细
     */
    GapFarmingDetailDO getFarmingDetail(Long id);

    /**
     * 获得农事记录明细分页
     *
     * @param pageReqVO 分页查询
     * @return 农事记录明细分页
     */
    PageResult<GapFarmingDetailDO> getFarmingDetailPage(GapFarmingDetailPageReqVO pageReqVO);

    /**
     * 获得农事记录明细列表
     *
     * @return 农事记录明细列表
     */
    List<GapFarmingDetailDO> getFarmingDetailList();

    /**
     * 根据农事记录编号获得明细列表
     *
     * @param recordId 农事记录编号
     * @return 明细列表
     */
    List<GapFarmingDetailDO> getDetailListByRecordId(Long recordId);

    /**
     * 校验农事记录明细存在
     *
     * @param id 编号
     * @return 农事记录明细
     */
    GapFarmingDetailDO validateFarmingDetailExists(Long id);

}
