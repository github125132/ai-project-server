package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapHeavyMetalDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 重金属检测明细 Service 接口
 *
 * @author 芋道源码
 */
public interface GapHeavyMetalService {

    /**
     * 创建重金属检测明细
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createHeavyMetal(@Valid GapHeavyMetalSaveReqVO createReqVO);

    /**
     * 更新重金属检测明细
     *
     * @param updateReqVO 更新信息
     */
    void updateHeavyMetal(@Valid GapHeavyMetalSaveReqVO updateReqVO);

    /**
     * 删除重金属检测明细
     *
     * @param id 编号
     */
    void deleteHeavyMetal(Long id);

    /**
     * 获得重金属检测明细
     *
     * @param id 编号
     * @return 重金属检测明细
     */
    GapHeavyMetalDO getHeavyMetal(Long id);

    /**
     * 获得重金属检测明细分页
     *
     * @param pageReqVO 分页查询
     * @return 重金属检测明细分页
     */
    PageResult<GapHeavyMetalDO> getHeavyMetalPage(GapHeavyMetalPageReqVO pageReqVO);

    /**
     * 获得重金属检测明细列表
     *
     * @return 重金属检测明细列表
     */
    List<GapHeavyMetalDO> getHeavyMetalList();

    /**
     * 获得重金属检测明细列表
     *
     * @param ids 编号集合
     * @return 重金属检测明细列表
     */
    List<GapHeavyMetalDO> getHeavyMetalList(Collection<Long> ids);

    /**
     * 根据任务编号获得重金属检测明细列表
     *
     * @param taskId 任务编号
     * @return 重金属检测明细列表
     */
    List<GapHeavyMetalDO> getHeavyMetalListByTaskId(Long taskId);

    /**
     * 根据报告编号获得重金属检测明细列表
     *
     * @param reportId 报告编号
     * @return 重金属检测明细列表
     */
    List<GapHeavyMetalDO> getHeavyMetalListByReportId(Long reportId);

    /**
     * 校验重金属检测明细存在
     *
     * @param id 编号
     * @return 重金属检测明细
     */
    GapHeavyMetalDO validateHeavyMetalExists(Long id);

}
