package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectTaskDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 检验任务 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInspectTaskService {

    /**
     * 创建检验任务
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInspectTask(@Valid GapInspectTaskSaveReqVO createReqVO);

    /**
     * 更新检验任务
     *
     * @param updateReqVO 更新信息
     */
    void updateInspectTask(@Valid GapInspectTaskSaveReqVO updateReqVO);

    /**
     * 删除检验任务
     *
     * @param id 编号
     */
    void deleteInspectTask(Long id);

    /**
     * 获得检验任务
     *
     * @param id 编号
     * @return 检验任务
     */
    GapInspectTaskDO getInspectTask(Long id);

    /**
     * 获得检验任务分页
     *
     * @param pageReqVO 分页查询
     * @return 检验任务分页
     */
    PageResult<GapInspectTaskDO> getInspectTaskPage(GapInspectTaskPageReqVO pageReqVO);

    /**
     * 获得检验任务列表
     *
     * @return 检验任务列表
     */
    List<GapInspectTaskDO> getInspectTaskList();

    /**
     * 获得检验任务列表
     *
     * @param ids 任务编号集合
     * @return 检验任务列表
     */
    List<GapInspectTaskDO> getInspectTaskList(Collection<Long> ids);

    /**
     * 根据品种编号获得检验任务列表
     *
     * @param varietyId 品种编号
     * @return 检验任务列表
     */
    List<GapInspectTaskDO> getInspectTaskListByVarietyId(Long varietyId);

    /**
     * 校验检验任务存在
     *
     * @param id 编号
     * @return 检验任务
     */
    GapInspectTaskDO validateInspectTaskExists(Long id);

}
