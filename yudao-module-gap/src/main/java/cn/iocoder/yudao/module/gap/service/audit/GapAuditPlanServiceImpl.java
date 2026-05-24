package cn.iocoder.yudao.module.gap.service.audit;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditPlanDO;
import cn.iocoder.yudao.module.gap.dal.mysql.audit.GapAuditPlanMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.AUDIT_PLAN_NOT_EXISTS;

/**
 * GAP 审核计划 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapAuditPlanServiceImpl implements GapAuditPlanService {

    @Resource
    private GapAuditPlanMapper auditPlanMapper;

    @Override
    public Long createAuditPlan(GapAuditPlanSaveReqVO createReqVO) {
        validateAuditPlanNoUnique(null, createReqVO.getPlanNo());
        GapAuditPlanDO auditPlan = BeanUtils.toBean(createReqVO, GapAuditPlanDO.class);
        auditPlanMapper.insert(auditPlan);
        return auditPlan.getId();
    }

    @Override
    public void updateAuditPlan(GapAuditPlanSaveReqVO updateReqVO) {
        validateAuditPlanExists(updateReqVO.getId());
        validateAuditPlanNoUnique(updateReqVO.getId(), updateReqVO.getPlanNo());
        GapAuditPlanDO updateObj = BeanUtils.toBean(updateReqVO, GapAuditPlanDO.class);
        auditPlanMapper.updateById(updateObj);
    }

    @Override
    public void deleteAuditPlan(Long id) {
        validateAuditPlanExists(id);
        auditPlanMapper.deleteById(id);
    }

    @Override
    public GapAuditPlanDO getAuditPlan(Long id) {
        return auditPlanMapper.selectById(id);
    }

    @Override
    public PageResult<GapAuditPlanDO> getAuditPlanPage(GapAuditPlanPageReqVO pageReqVO) {
        return auditPlanMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapAuditPlanDO> getAuditPlanList() {
        return auditPlanMapper.selectList();
    }

    @Override
    public List<GapAuditPlanDO> getAuditPlanList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return auditPlanMapper.selectByIds(ids);
    }

    @Override
    public GapAuditPlanDO validateAuditPlanExists(Long id) {
        GapAuditPlanDO auditPlan = auditPlanMapper.selectById(id);
        if (auditPlan == null) {
            throw exception(AUDIT_PLAN_NOT_EXISTS);
        }
        return auditPlan;
    }

    private void validateAuditPlanNoUnique(Long id, String planNo) {
        if (planNo == null || planNo.isEmpty()) {
            return;
        }
        GapAuditPlanDO auditPlan = auditPlanMapper.selectByPlanNo(planNo);
        if (auditPlan == null) {
            return;
        }
        if (ObjUtil.notEqual(id, auditPlan.getId())) {
            throw exception(AUDIT_PLAN_NOT_EXISTS);
        }
    }

}
