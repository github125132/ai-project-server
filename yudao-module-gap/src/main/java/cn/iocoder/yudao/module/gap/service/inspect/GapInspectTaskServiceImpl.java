package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectTaskDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapInspectTaskMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

@Service
@Validated
public class GapInspectTaskServiceImpl implements GapInspectTaskService {

    @Resource
    private GapInspectTaskMapper inspectTaskMapper;

    @Override
    public Long createInspectTask(GapInspectTaskSaveReqVO createReqVO) {
        validateInspectTaskNoUnique(null, createReqVO.getTaskNo());
        GapInspectTaskDO inspectTask = BeanUtils.toBean(createReqVO, GapInspectTaskDO.class);
        inspectTaskMapper.insert(inspectTask);
        return inspectTask.getId();
    }

    @Override
    public void updateInspectTask(GapInspectTaskSaveReqVO updateReqVO) {
        validateInspectTaskExists(updateReqVO.getId());
        validateInspectTaskNoUnique(updateReqVO.getId(), updateReqVO.getTaskNo());
        GapInspectTaskDO updateObj = BeanUtils.toBean(updateReqVO, GapInspectTaskDO.class);
        inspectTaskMapper.updateById(updateObj);
    }

    @Override
    public void deleteInspectTask(Long id) {
        validateInspectTaskExists(id);
        inspectTaskMapper.deleteById(id);
    }

    @Override
    public GapInspectTaskDO getInspectTask(Long id) {
        return inspectTaskMapper.selectById(id);
    }

    @Override
    public PageResult<GapInspectTaskDO> getInspectTaskPage(GapInspectTaskPageReqVO pageReqVO) {
        return inspectTaskMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInspectTaskDO> getInspectTaskList() {
        return inspectTaskMapper.selectList();
    }

    @Override
    public List<GapInspectTaskDO> getInspectTaskList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inspectTaskMapper.selectByIds(ids);
    }

    @Override
    public List<GapInspectTaskDO> getInspectTaskListByVarietyId(Long varietyId) {
        return inspectTaskMapper.selectListByVarietyId(varietyId);
    }

    @Override
    public GapInspectTaskDO validateInspectTaskExists(Long id) {
        GapInspectTaskDO inspectTask = inspectTaskMapper.selectById(id);
        if (inspectTask == null) {
            throw exception(INSPECT_TASK_NOT_EXISTS);
        }
        return inspectTask;
    }

    private void validateInspectTaskNoUnique(Long id, String taskNo) {
        if (taskNo == null || taskNo.isEmpty()) {
            return;
        }
        GapInspectTaskDO inspectTask = inspectTaskMapper.selectByTaskNo(taskNo);
        if (inspectTask == null) {
            return;
        }
        if (ObjUtil.notEqual(id, inspectTask.getId())) {
            throw exception(INSPECT_TASK_NO_DUPLICATE);
        }
    }

}
