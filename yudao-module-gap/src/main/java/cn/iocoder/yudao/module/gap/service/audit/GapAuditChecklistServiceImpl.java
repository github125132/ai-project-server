package cn.iocoder.yudao.module.gap.service.audit;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistDO;
import cn.iocoder.yudao.module.gap.dal.mysql.audit.GapAuditChecklistMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.AUDIT_PLAN_NOT_EXISTS;

/**
 * GAP 审核检查表 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapAuditChecklistServiceImpl implements GapAuditChecklistService {

    @Resource
    private GapAuditChecklistMapper auditChecklistMapper;

    @Resource
    private GapAuditPlanService auditPlanService;

    @Override
    public Long createAuditChecklist(GapAuditChecklistSaveReqVO createReqVO) {
        validateAuditPlanExists(createReqVO.getPlanId());
        validateChecklistNoUnique(null, createReqVO.getChecklistNo());
        GapAuditChecklistDO auditChecklist = BeanUtils.toBean(createReqVO, GapAuditChecklistDO.class);
        auditChecklistMapper.insert(auditChecklist);
        return auditChecklist.getId();
    }

    @Override
    public void updateAuditChecklist(GapAuditChecklistSaveReqVO updateReqVO) {
        validateAuditChecklistExists(updateReqVO.getId());
        validateAuditPlanExists(updateReqVO.getPlanId());
        validateChecklistNoUnique(updateReqVO.getId(), updateReqVO.getChecklistNo());
        GapAuditChecklistDO updateObj = BeanUtils.toBean(updateReqVO, GapAuditChecklistDO.class);
        auditChecklistMapper.updateById(updateObj);
    }

    @Override
    public void deleteAuditChecklist(Long id) {
        validateAuditChecklistExists(id);
        auditChecklistMapper.deleteById(id);
    }

    @Override
    public GapAuditChecklistDO getAuditChecklist(Long id) {
        return auditChecklistMapper.selectById(id);
    }

    @Override
    public PageResult<GapAuditChecklistDO> getAuditChecklistPage(GapAuditChecklistPageReqVO pageReqVO) {
        return auditChecklistMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapAuditChecklistDO> getAuditChecklistList() {
        return auditChecklistMapper.selectList();
    }

    @Override
    public List<GapAuditChecklistDO> getAuditChecklistList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return auditChecklistMapper.selectByIds(ids);
    }

    @Override
    public List<GapAuditChecklistDO> getAuditChecklistListByPlanId(Long planId) {
        return auditChecklistMapper.selectListByPlanId(planId);
    }

    @Override
    public GapAuditChecklistDO validateAuditChecklistExists(Long id) {
        GapAuditChecklistDO auditChecklist = auditChecklistMapper.selectById(id);
        if (auditChecklist == null) {
            throw exception(AUDIT_PLAN_NOT_EXISTS);
        }
        return auditChecklist;
    }

    private void validateAuditPlanExists(Long planId) {
        if (planId == null) {
            return;
        }
        auditPlanService.validateAuditPlanExists(planId);
    }

    private void validateChecklistNoUnique(Long id, String checklistNo) {
        if (checklistNo == null || checklistNo.isEmpty()) {
            return;
        }
        GapAuditChecklistDO auditChecklist = auditChecklistMapper.selectByChecklistNo(checklistNo);
        if (auditChecklist == null) {
            return;
        }
        if (ObjUtil.notEqual(id, auditChecklist.getId())) {
            throw exception(AUDIT_PLAN_NOT_EXISTS);
        }
    }

}
