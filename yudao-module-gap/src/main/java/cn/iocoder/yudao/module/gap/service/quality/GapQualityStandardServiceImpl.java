package cn.iocoder.yudao.module.gap.service.quality;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.quality.GapQualityStandardDO;
import cn.iocoder.yudao.module.gap.dal.mysql.quality.GapQualityStandardMapper;
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
public class GapQualityStandardServiceImpl implements GapQualityStandardService {

    @Resource
    private GapQualityStandardMapper qualityStandardMapper;

    @Override
    public Long createQualityStandard(GapQualityStandardSaveReqVO createReqVO) {
        validateQualityStandardCodeUnique(null, createReqVO.getCode());
        GapQualityStandardDO qualityStandard = BeanUtils.toBean(createReqVO, GapQualityStandardDO.class);
        qualityStandardMapper.insert(qualityStandard);
        return qualityStandard.getId();
    }

    @Override
    public void updateQualityStandard(GapQualityStandardSaveReqVO updateReqVO) {
        validateQualityStandardExists(updateReqVO.getId());
        validateQualityStandardCodeUnique(updateReqVO.getId(), updateReqVO.getCode());
        GapQualityStandardDO updateObj = BeanUtils.toBean(updateReqVO, GapQualityStandardDO.class);
        qualityStandardMapper.updateById(updateObj);
    }

    @Override
    public void deleteQualityStandard(Long id) {
        validateQualityStandardExists(id);
        qualityStandardMapper.deleteById(id);
    }

    @Override
    public GapQualityStandardDO getQualityStandard(Long id) {
        return qualityStandardMapper.selectById(id);
    }

    @Override
    public PageResult<GapQualityStandardDO> getQualityStandardPage(GapQualityStandardPageReqVO pageReqVO) {
        return qualityStandardMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapQualityStandardDO> getQualityStandardList() {
        return qualityStandardMapper.selectList();
    }

    @Override
    public List<GapQualityStandardDO> getQualityStandardList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return qualityStandardMapper.selectByIds(ids);
    }

    @Override
    public GapQualityStandardDO validateQualityStandardExists(Long id) {
        GapQualityStandardDO qualityStandard = qualityStandardMapper.selectById(id);
        if (qualityStandard == null) {
            throw exception(QUALITY_STANDARD_NOT_EXISTS);
        }
        return qualityStandard;
    }

    private void validateQualityStandardCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapQualityStandardDO qualityStandard = qualityStandardMapper.selectByCode(code);
        if (qualityStandard == null) {
            return;
        }
        if (ObjUtil.notEqual(id, qualityStandard.getId())) {
            throw exception(QUALITY_STANDARD_CODE_DUPLICATE);
        }
    }

}
