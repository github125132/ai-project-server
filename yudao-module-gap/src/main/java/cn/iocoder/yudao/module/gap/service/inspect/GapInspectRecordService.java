package cn.iocoder.yudao.module.gap.service.inspect;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 检验记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInspectRecordService {

    /**
     * 创建检验记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInspectRecord(@Valid GapInspectRecordSaveReqVO createReqVO);

    /**
     * 更新检验记录
     *
     * @param updateReqVO 更新信息
     */
    void updateInspectRecord(@Valid GapInspectRecordSaveReqVO updateReqVO);

    /**
     * 删除检验记录
     *
     * @param id 编号
     */
    void deleteInspectRecord(Long id);

    /**
     * 获得检验记录
     *
     * @param id 编号
     * @return 检验记录
     */
    GapInspectRecordDO getInspectRecord(Long id);

    /**
     * 获得检验记录分页
     *
     * @param pageReqVO 分页查询
     * @return 检验记录分页
     */
    PageResult<GapInspectRecordDO> getInspectRecordPage(GapInspectRecordPageReqVO pageReqVO);

    /**
     * 获得检验记录列表
     *
     * @return 检验记录列表
     */
    List<GapInspectRecordDO> getInspectRecordList();

    /**
     * 获得检验记录列表
     *
     * @param ids 记录编号集合
     * @return 检验记录列表
     */
    List<GapInspectRecordDO> getInspectRecordList(Collection<Long> ids);

    /**
     * 根据任务编号获得检验记录列表
     *
     * @param taskId 任务编号
     * @return 检验记录列表
     */
    List<GapInspectRecordDO> getInspectRecordListByTaskId(Long taskId);

    /**
     * 校验检验记录存在
     *
     * @param id 编号
     * @return 检验记录
     */
    GapInspectRecordDO validateInspectRecordExists(Long id);

}
