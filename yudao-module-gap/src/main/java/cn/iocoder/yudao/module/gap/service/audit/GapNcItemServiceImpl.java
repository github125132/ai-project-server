package cn.iocoder.yudao.module.gap.service.audit;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.audit.vo.GapNcItemSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.audit.GapNcItemDO;
import cn.iocoder.yudao.module.gap.dal.mysql.audit.GapNcItemMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.NC_ITEM_NOT_EXISTS;

/**
 * GAP 不符合项 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapNcItemServiceImpl implements GapNcItemService {

    @Resource
    private GapNcItemMapper ncItemMapper;

    @Resource
    private GapAuditPlanService auditPlanService;

    @Override
    public Long createNcItem(GapNcItemSaveReqVO createReqVO) {
        validateAuditPlanExists(createReqVO.getPlanId());
        validateNcNoUnique(null, createReqVO.getNcNo());
        GapNcItemDO ncItem = BeanUtils.toBean(createReqVO, GapNcItemDO.class);
        ncItemMapper.insert(ncItem);
        return ncItem.getId();
    }

    @Override
    public void updateNcItem(GapNcItemSaveReqVO updateReqVO) {
        validateNcItemExists(updateReqVO.getId());
        validateAuditPlanExists(updateReqVO.getPlanId());
        validateNcNoUnique(updateReqVO.getId(), updateReqVO.getNcNo());
        GapNcItemDO updateObj = BeanUtils.toBean(updateReqVO, GapNcItemDO.class);
        ncItemMapper.updateById(updateObj);
    }

    @Override
    public void deleteNcItem(Long id) {
        validateNcItemExists(id);
        ncItemMapper.deleteById(id);
    }

    @Override
    public GapNcItemDO getNcItem(Long id) {
        return ncItemMapper.selectById(id);
    }

    @Override
    public PageResult<GapNcItemDO> getNcItemPage(GapNcItemPageReqVO pageReqVO) {
        return ncItemMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapNcItemDO> getNcItemList() {
        return ncItemMapper.selectList();
    }

    @Override
    public List<GapNcItemDO> getNcItemList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return ncItemMapper.selectByIds(ids);
    }

    @Override
    public List<GapNcItemDO> getNcItemListByPlanId(Long planId) {
        return ncItemMapper.selectListByPlanId(planId);
    }

    @Override
    public GapNcItemDO validateNcItemExists(Long id) {
        GapNcItemDO ncItem = ncItemMapper.selectById(id);
        if (ncItem == null) {
            throw exception(NC_ITEM_NOT_EXISTS);
        }
        return ncItem;
    }

    private void validateAuditPlanExists(Long planId) {
        if (planId == null) {
            return;
        }
        auditPlanService.validateAuditPlanExists(planId);
    }

    private void validateNcNoUnique(Long id, String ncNo) {
        if (ncNo == null || ncNo.isEmpty()) {
            return;
        }
        GapNcItemDO ncItem = ncItemMapper.selectByNcNo(ncNo);
        if (ncItem == null) {
            return;
        }
        if (ObjUtil.notEqual(id, ncItem.getId())) {
            throw exception(NC_ITEM_NOT_EXISTS);
        }
    }

}
