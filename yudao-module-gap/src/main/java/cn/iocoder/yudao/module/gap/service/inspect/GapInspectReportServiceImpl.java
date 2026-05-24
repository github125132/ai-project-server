package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectReportSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectReportDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapInspectReportMapper;
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
public class GapInspectReportServiceImpl implements GapInspectReportService {

    @Resource
    private GapInspectReportMapper inspectReportMapper;

    @Override
    public Long createInspectReport(GapInspectReportSaveReqVO createReqVO) {
        validateInspectReportNoUnique(null, createReqVO.getReportNo());
        GapInspectReportDO inspectReport = BeanUtils.toBean(createReqVO, GapInspectReportDO.class);
        inspectReportMapper.insert(inspectReport);
        return inspectReport.getId();
    }

    @Override
    public void updateInspectReport(GapInspectReportSaveReqVO updateReqVO) {
        validateInspectReportExists(updateReqVO.getId());
        validateInspectReportNoUnique(updateReqVO.getId(), updateReqVO.getReportNo());
        GapInspectReportDO updateObj = BeanUtils.toBean(updateReqVO, GapInspectReportDO.class);
        inspectReportMapper.updateById(updateObj);
    }

    @Override
    public void deleteInspectReport(Long id) {
        validateInspectReportExists(id);
        inspectReportMapper.deleteById(id);
    }

    @Override
    public GapInspectReportDO getInspectReport(Long id) {
        return inspectReportMapper.selectById(id);
    }

    @Override
    public PageResult<GapInspectReportDO> getInspectReportPage(GapInspectReportPageReqVO pageReqVO) {
        return inspectReportMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInspectReportDO> getInspectReportList() {
        return inspectReportMapper.selectList();
    }

    @Override
    public List<GapInspectReportDO> getInspectReportList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inspectReportMapper.selectByIds(ids);
    }

    @Override
    public List<GapInspectReportDO> getInspectReportListByTaskId(Long taskId) {
        return inspectReportMapper.selectListByTaskId(taskId);
    }

    @Override
    public GapInspectReportDO validateInspectReportExists(Long id) {
        GapInspectReportDO inspectReport = inspectReportMapper.selectById(id);
        if (inspectReport == null) {
            throw exception(INSPECT_REPORT_NOT_EXISTS);
        }
        return inspectReport;
    }

    private void validateInspectReportNoUnique(Long id, String reportNo) {
        if (reportNo == null || reportNo.isEmpty()) {
            return;
        }
        GapInspectReportDO inspectReport = inspectReportMapper.selectByReportNo(reportNo);
        if (inspectReport == null) {
            return;
        }
        if (ObjUtil.notEqual(id, inspectReport.getId())) {
            throw exception(INSPECT_REPORT_NO_DUPLICATE);
        }
    }

}
