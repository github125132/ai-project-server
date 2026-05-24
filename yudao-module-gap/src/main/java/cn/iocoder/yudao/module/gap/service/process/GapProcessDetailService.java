package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessDetailDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 加工工序明细 Service 接口
 *
 * @author 芋道源码
 */
public interface GapProcessDetailService {

    /**
     * 创建加工工序明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProcessDetail(@Valid GapProcessDetailSaveReqVO createReqVO);

    /**
     * 更新加工工序明细
     *
     * @param updateReqVO 更新信息
     */
    void updateProcessDetail(@Valid GapProcessDetailSaveReqVO updateReqVO);

    /**
     * 删除加工工序明细
     *
     * @param id 编号
     */
    void deleteProcessDetail(Long id);

    /**
     * 获得加工工序明细
     *
     * @param id 编号
     * @return 加工工序明细
     */
    GapProcessDetailDO getProcessDetail(Long id);

    /**
     * 获得加工工序明细分页
     *
     * @param pageReqVO 分页查询
     * @return 加工工序明细分页
     */
    PageResult<GapProcessDetailDO> getProcessDetailPage(GapProcessDetailPageReqVO pageReqVO);

    /**
     * 根据加工记录编号获得工序明细列表
     *
     * @param processRecordId 加工记录编号
     * @return 工序明细列表
     */
    List<GapProcessDetailDO> getProcessDetailListByProcessRecordId(Long processRecordId);

    /**
     * 校验加工工序明细存在
     *
     * @param id 编号
     * @return 加工工序明细
     */
    GapProcessDetailDO validateProcessDetailExists(Long id);

}
