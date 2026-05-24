package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectReportDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 检验报告 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInspectReportService {

    /**
     * 创建检验报告
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInspectReport(@Valid GapInspectReportSaveReqVO createReqVO);

    /**
     * 更新检验报告
     *
     * @param updateReqVO 更新信息
     */
    void updateInspectReport(@Valid GapInspectReportSaveReqVO updateReqVO);

    /**
     * 删除检验报告
     *
     * @param id 编号
     */
    void deleteInspectReport(Long id);

    /**
     * 获得检验报告
     *
     * @param id 编号
     * @return 检验报告
     */
    GapInspectReportDO getInspectReport(Long id);

    /**
     * 获得检验报告分页
     *
     * @param pageReqVO 分页查询
     * @return 检验报告分页
     */
    PageResult<GapInspectReportDO> getInspectReportPage(GapInspectReportPageReqVO pageReqVO);

    /**
     * 获得检验报告列表
     *
     * @return 检验报告列表
     */
    List<GapInspectReportDO> getInspectReportList();

    /**
     * 获得检验报告列表
     *
     * @param ids 报告编号集合
     * @return 检验报告列表
     */
    List<GapInspectReportDO> getInspectReportList(Collection<Long> ids);

    /**
     * 根据任务编号获得检验报告列表
     *
     * @param taskId 任务编号
     * @return 检验报告列表
     */
    List<GapInspectReportDO> getInspectReportListByTaskId(Long taskId);

    /**
     * 校验检验报告存在
     *
     * @param id 编号
     * @return 检验报告
     */
    GapInspectReportDO validateInspectReportExists(Long id);

}
