package cn.iocoder.yudao.module.gap.service.audit;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapAuditChecklistItemSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapAuditChecklistItemDO;
import cn.iocoder.yudao.module.gap.dal.mysql.audit.GapAuditChecklistItemMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.AUDIT_PLAN_NOT_EXISTS;

/**
 * GAP 审核检查表项目 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapAuditChecklistItemServiceImpl implements GapAuditChecklistItemService {

    @Resource
    private GapAuditChecklistItemMapper auditChecklistItemMapper;

    @Resource
    private GapAuditChecklistService auditChecklistService;

    @Override
    public Long createAuditChecklistItem(GapAuditChecklistItemSaveReqVO createReqVO) {
        validateChecklistExists(createReqVO.getChecklistId());
        GapAuditChecklistItemDO auditChecklistItem = BeanUtils.toBean(createReqVO, GapAuditChecklistItemDO.class);
        auditChecklistItemMapper.insert(auditChecklistItem);
        return auditChecklistItem.getId();
    }

    @Override
    public void updateAuditChecklistItem(GapAuditChecklistItemSaveReqVO updateReqVO) {
        validateAuditChecklistItemExists(updateReqVO.getId());
        validateChecklistExists(updateReqVO.getChecklistId());
        GapAuditChecklistItemDO updateObj = BeanUtils.toBean(updateReqVO, GapAuditChecklistItemDO.class);
        auditChecklistItemMapper.updateById(updateObj);
    }

    @Override
    public void deleteAuditChecklistItem(Long id) {
        validateAuditChecklistItemExists(id);
        auditChecklistItemMapper.deleteById(id);
    }

    @Override
    public GapAuditChecklistItemDO getAuditChecklistItem(Long id) {
        return auditChecklistItemMapper.selectById(id);
    }

    @Override
    public PageResult<GapAuditChecklistItemDO> getAuditChecklistItemPage(GapAuditChecklistItemPageReqVO pageReqVO) {
        return auditChecklistItemMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapAuditChecklistItemDO> getAuditChecklistItemList() {
        return auditChecklistItemMapper.selectList();
    }

    @Override
    public List<GapAuditChecklistItemDO> getAuditChecklistItemList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return auditChecklistItemMapper.selectByIds(ids);
    }

    @Override
    public List<GapAuditChecklistItemDO> getAuditChecklistItemListByChecklistId(Long checklistId) {
        return auditChecklistItemMapper.selectListByChecklistId(checklistId);
    }

    @Override
    public GapAuditChecklistItemDO validateAuditChecklistItemExists(Long id) {
        GapAuditChecklistItemDO auditChecklistItem = auditChecklistItemMapper.selectById(id);
        if (auditChecklistItem == null) {
            throw exception(AUDIT_PLAN_NOT_EXISTS);
        }
        return auditChecklistItem;
    }

    private void validateChecklistExists(Long checklistId) {
        if (checklistId == null) {
            return;
        }
        auditChecklistService.validateAuditChecklistExists(checklistId);
    }

}
