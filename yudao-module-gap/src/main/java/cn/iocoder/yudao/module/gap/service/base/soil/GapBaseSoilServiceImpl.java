package cn.iocoder.yudao.module.gap.service.base.soil;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.soil.GapBaseSoilDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.soil.GapBaseSoilMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

@Service
@Validated
public class GapBaseSoilServiceImpl implements GapBaseSoilService {

    @Resource
    private GapBaseSoilMapper soilMapper;

    @Override
    public Long createSoil(GapBaseSoilSaveReqVO createReqVO) {
        validateSampleNoUnique(null, createReqVO.getSampleNo());
        GapBaseSoilDO soil = BeanUtils.toBean(createReqVO, GapBaseSoilDO.class);
        soilMapper.insert(soil);
        return soil.getId();
    }

    @Override
    public void updateSoil(GapBaseSoilSaveReqVO updateReqVO) {
        validateSoilExists(updateReqVO.getId());
        validateSampleNoUnique(updateReqVO.getId(), updateReqVO.getSampleNo());
        GapBaseSoilDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseSoilDO.class);
        soilMapper.updateById(updateObj);
    }

    @Override
    public void deleteSoil(Long id) {
        validateSoilExists(id);
        soilMapper.deleteById(id);
    }

    @Override
    public GapBaseSoilDO getSoil(Long id) {
        return soilMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseSoilDO> getSoilPage(GapBaseSoilPageReqVO pageReqVO) {
        return soilMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapBaseSoilDO> getSoilListByBaseId(Long baseId) {
        return soilMapper.selectList(GapBaseSoilDO::getBaseId, baseId);
    }

    @Override
    public List<GapBaseSoilDO> getSoilListByPlotId(Long plotId) {
        return soilMapper.selectList(GapBaseSoilDO::getPlotId, plotId);
    }

    @Override
    public GapBaseSoilDO validateSoilExists(Long id) {
        GapBaseSoilDO soil = soilMapper.selectById(id);
        if (soil == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return soil;
    }

    private void validateSampleNoUnique(Long id, String sampleNo) {
        if (sampleNo == null || sampleNo.isEmpty()) {
            return;
        }
        GapBaseSoilDO soil = soilMapper.selectBySampleNo(sampleNo);
        if (soil == null) {
            return;
        }
        if (ObjUtil.notEqual(id, soil.getId())) {
            throw exception(new cn.iocoder.yudao.framework.common.exception.ErrorCode(1_050_104_001, "样品编号已存在"));
        }
    }

}
