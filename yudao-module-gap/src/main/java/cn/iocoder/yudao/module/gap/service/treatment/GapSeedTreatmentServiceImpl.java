package cn.iocoder.yudao.module.gap.service.treatment;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.treatment.vo.GapSeedTreatmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.treatment.GapSeedTreatmentDO;
import cn.iocoder.yudao.module.gap.dal.mysql.treatment.GapSeedTreatmentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

@Service
@Validated
public class GapSeedTreatmentServiceImpl implements GapSeedTreatmentService {

    @Resource
    private GapSeedTreatmentMapper seedTreatmentMapper;

    @Override
    public Long createSeedTreatment(GapSeedTreatmentSaveReqVO createReqVO) {
        GapSeedTreatmentDO seedTreatment = BeanUtils.toBean(createReqVO, GapSeedTreatmentDO.class);
        seedTreatmentMapper.insert(seedTreatment);
        return seedTreatment.getId();
    }

    @Override
    public void updateSeedTreatment(GapSeedTreatmentSaveReqVO updateReqVO) {
        validateSeedTreatmentExists(updateReqVO.getId());

        GapSeedTreatmentDO updateObj = BeanUtils.toBean(updateReqVO, GapSeedTreatmentDO.class);
        seedTreatmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteSeedTreatment(Long id) {
        validateSeedTreatmentExists(id);
        seedTreatmentMapper.deleteById(id);
    }

    @Override
    public GapSeedTreatmentDO getSeedTreatment(Long id) {
        return seedTreatmentMapper.selectById(id);
    }

    @Override
    public PageResult<GapSeedTreatmentDO> getSeedTreatmentPage(GapSeedTreatmentPageReqVO pageReqVO) {
        return seedTreatmentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapSeedTreatmentDO> getSeedTreatmentList() {
        return seedTreatmentMapper.selectList();
    }

    @Override
    public List<GapSeedTreatmentDO> getSeedTreatmentList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return seedTreatmentMapper.selectByIds(ids);
    }

    @Override
    public List<GapSeedTreatmentDO> getSeedTreatmentListBySeedBatchId(Long seedBatchId) {
        return seedTreatmentMapper.selectListBySeedBatchId(seedBatchId);
    }

    @Override
    public GapSeedTreatmentDO validateSeedTreatmentExists(Long id) {
        GapSeedTreatmentDO seedTreatment = seedTreatmentMapper.selectById(id);
        if (seedTreatment == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return seedTreatment;
    }

}
