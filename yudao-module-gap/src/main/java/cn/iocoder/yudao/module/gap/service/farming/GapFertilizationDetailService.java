package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationDetailDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 施肥明细 Service 接口
 *
 * @author 芋道源码
 */
public interface GapFertilizationDetailService {

    /**
     * 创建施肥明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFertilizationDetail(@Valid GapFertilizationDetailSaveReqVO createReqVO);

    /**
     * 更新施肥明细
     *
     * @param updateReqVO 更新信息
     */
    void updateFertilizationDetail(@Valid GapFertilizationDetailSaveReqVO updateReqVO);

    /**
     * 删除施肥明细
     *
     * @param id 编号
     */
    void deleteFertilizationDetail(Long id);

    /**
     * 获得施肥明细
     *
     * @param id 编号
     * @return 施肥明细
     */
    GapFertilizationDetailDO getFertilizationDetail(Long id);

    /**
     * 获得施肥明细分页
     *
     * @param pageReqVO 分页查询
     * @return 施肥明细分页
     */
    PageResult<GapFertilizationDetailDO> getFertilizationDetailPage(GapFertilizationDetailPageReqVO pageReqVO);

    /**
     * 获得施肥明细列表
     *
     * @return 施肥明细列表
     */
    List<GapFertilizationDetailDO> getFertilizationDetailList();

    /**
     * 根据施肥记录编号获得明细列表
     *
     * @param recordId 施肥记录编号
     * @return 明细列表
     */
    List<GapFertilizationDetailDO> getDetailListByRecordId(Long recordId);

    /**
     * 校验施肥明细存在
     *
     * @param id 编号
     * @return 施肥明细
     */
    GapFertilizationDetailDO validateFertilizationDetailExists(Long id);

}
