package cn.iocoder.yudao.module.gap.service.variety;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietyPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.variety.GapVarietyDO;
import cn.iocoder.yudao.module.gap.dal.mysql.variety.GapVarietyMapper;
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
public class GapVarietyServiceImpl implements GapVarietyService {

    @Resource
    private GapVarietyMapper varietyMapper;

    @Override
    public Long createVariety(GapVarietySaveReqVO createReqVO) {
        validateVarietyCodeUnique(null, createReqVO.getCode());

        GapVarietyDO variety = BeanUtils.toBean(createReqVO, GapVarietyDO.class);
        varietyMapper.insert(variety);
        return variety.getId();
    }

    @Override
    public void updateVariety(GapVarietySaveReqVO updateReqVO) {
        validateVarietyExists(updateReqVO.getId());
        validateVarietyCodeUnique(updateReqVO.getId(), updateReqVO.getCode());

        GapVarietyDO updateObj = BeanUtils.toBean(updateReqVO, GapVarietyDO.class);
        varietyMapper.updateById(updateObj);
    }

    @Override
    public void deleteVariety(Long id) {
        validateVarietyExists(id);
        varietyMapper.deleteById(id);
    }

    @Override
    public GapVarietyDO getVariety(Long id) {
        return varietyMapper.selectById(id);
    }

    @Override
    public PageResult<GapVarietyDO> getVarietyPage(GapVarietyPageReqVO pageReqVO) {
        return varietyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapVarietyDO> getVarietyList() {
        return varietyMapper.selectList();
    }

    @Override
    public List<GapVarietyDO> getVarietyList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return varietyMapper.selectByIds(ids);
    }

    @Override
    public GapVarietyDO validateVarietyExists(Long id) {
        GapVarietyDO variety = varietyMapper.selectById(id);
        if (variety == null) {
            throw exception(VARIETY_NOT_EXISTS);
        }
        return variety;
    }

    private void validateVarietyCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapVarietyDO variety = varietyMapper.selectByCode(code);
        if (variety == null) {
            return;
        }
        if (ObjUtil.notEqual(id, variety.getId())) {
            throw exception(VARIETY_CODE_DUPLICATE);
        }
    }

}
