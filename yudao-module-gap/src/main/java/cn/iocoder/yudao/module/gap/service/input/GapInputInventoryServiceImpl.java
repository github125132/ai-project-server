package cn.iocoder.yudao.module.gap.service.input;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventoryPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputInventorySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputInventoryDO;
import cn.iocoder.yudao.module.gap.dal.mysql.input.GapInputInventoryMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

/**
 * GAP 投入品库存 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapInputInventoryServiceImpl implements GapInputInventoryService {

    @Resource
    private GapInputInventoryMapper inputInventoryMapper;

    @Override
    public Long createInputInventory(GapInputInventorySaveReqVO createReqVO) {
        // 插入
        GapInputInventoryDO inventory = BeanUtils.toBean(createReqVO, GapInputInventoryDO.class);
        inputInventoryMapper.insert(inventory);
        return inventory.getId();
    }

    @Override
    public void updateInputInventory(GapInputInventorySaveReqVO updateReqVO) {
        // 1. 校验存在
        validateInputInventoryExists(updateReqVO.getId());

        // 2. 更新
        GapInputInventoryDO updateObj = BeanUtils.toBean(updateReqVO, GapInputInventoryDO.class);
        inputInventoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputInventory(Long id) {
        // 1. 校验存在
        validateInputInventoryExists(id);

        // 2. 删除
        inputInventoryMapper.deleteById(id);
    }

    @Override
    public GapInputInventoryDO getInputInventory(Long id) {
        return inputInventoryMapper.selectById(id);
    }

    @Override
    public PageResult<GapInputInventoryDO> getInputInventoryPage(GapInputInventoryPageReqVO pageReqVO) {
        return inputInventoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInputInventoryDO> getInputInventoryList() {
        return inputInventoryMapper.selectList();
    }

    @Override
    public List<GapInputInventoryDO> getInputInventoryList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inputInventoryMapper.selectByIds(ids);
    }

    @Override
    public List<GapInputInventoryDO> getInputInventoryListByProductId(Long productId) {
        return inputInventoryMapper.selectListByProductId(productId);
    }

    @Override
    public GapInputInventoryDO validateInputInventoryExists(Long id) {
        GapInputInventoryDO inventory = inputInventoryMapper.selectById(id);
        if (inventory == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return inventory;
    }

}
