package cn.iocoder.yudao.module.gap.service.seed;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.seed.vo.GapSeedBatchSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.seed.GapSeedBatchDO;
import cn.iocoder.yudao.module.gap.dal.mysql.seed.GapSeedBatchMapper;
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
public class GapSeedBatchServiceImpl implements GapSeedBatchService {

    @Resource
    private GapSeedBatchMapper seedBatchMapper;

    @Override
    public Long createSeedBatch(GapSeedBatchSaveReqVO createReqVO) {
        validateSeedBatchNoUnique(null, createReqVO.getBatchNo());

        GapSeedBatchDO seedBatch = BeanUtils.toBean(createReqVO, GapSeedBatchDO.class);
        seedBatchMapper.insert(seedBatch);
        return seedBatch.getId();
    }

    @Override
    public void updateSeedBatch(GapSeedBatchSaveReqVO updateReqVO) {
        validateSeedBatchExists(updateReqVO.getId());
        validateSeedBatchNoUnique(updateReqVO.getId(), updateReqVO.getBatchNo());

        GapSeedBatchDO updateObj = BeanUtils.toBean(updateReqVO, GapSeedBatchDO.class);
        seedBatchMapper.updateById(updateObj);
    }

    @Override
    public void deleteSeedBatch(Long id) {
        validateSeedBatchExists(id);
        seedBatchMapper.deleteById(id);
    }

    @Override
    public GapSeedBatchDO getSeedBatch(Long id) {
        return seedBatchMapper.selectById(id);
    }

    @Override
    public PageResult<GapSeedBatchDO> getSeedBatchPage(GapSeedBatchPageReqVO pageReqVO) {
        return seedBatchMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapSeedBatchDO> getSeedBatchList() {
        return seedBatchMapper.selectList();
    }

    @Override
    public List<GapSeedBatchDO> getSeedBatchList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return seedBatchMapper.selectByIds(ids);
    }

    @Override
    public List<GapSeedBatchDO> getSeedBatchListByVarietyId(Long varietyId) {
        return seedBatchMapper.selectListByVarietyId(varietyId);
    }

    @Override
    public GapSeedBatchDO validateSeedBatchExists(Long id) {
        GapSeedBatchDO seedBatch = seedBatchMapper.selectById(id);
        if (seedBatch == null) {
            throw exception(SEED_BATCH_NOT_EXISTS);
        }
        return seedBatch;
    }

    private void validateSeedBatchNoUnique(Long id, String batchNo) {
        if (batchNo == null || batchNo.isEmpty()) {
            return;
        }
        GapSeedBatchDO seedBatch = seedBatchMapper.selectByBatchNo(batchNo);
        if (seedBatch == null) {
            return;
        }
        if (ObjUtil.notEqual(id, seedBatch.getId())) {
            throw exception(SEED_BATCH_CODE_DUPLICATE);
        }
    }

}
