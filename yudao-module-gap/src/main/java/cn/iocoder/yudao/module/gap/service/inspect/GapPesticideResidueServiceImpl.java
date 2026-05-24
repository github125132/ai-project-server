package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResiduePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResidueSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapPesticideResidueDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapPesticideResidueMapper;
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
public class GapPesticideResidueServiceImpl implements GapPesticideResidueService {

    @Resource
    private GapPesticideResidueMapper pesticideResidueMapper;

    @Override
    public Long createPesticideResidue(GapPesticideResidueSaveReqVO createReqVO) {
        GapPesticideResidueDO pesticideResidue = BeanUtils.toBean(createReqVO, GapPesticideResidueDO.class);
        pesticideResidueMapper.insert(pesticideResidue);
        return pesticideResidue.getId();
    }

    @Override
    public void updatePesticideResidue(GapPesticideResidueSaveReqVO updateReqVO) {
        validatePesticideResidueExists(updateReqVO.getId());
        GapPesticideResidueDO updateObj = BeanUtils.toBean(updateReqVO, GapPesticideResidueDO.class);
        pesticideResidueMapper.updateById(updateObj);
    }

    @Override
    public void deletePesticideResidue(Long id) {
        validatePesticideResidueExists(id);
        pesticideResidueMapper.deleteById(id);
    }

    @Override
    public GapPesticideResidueDO getPesticideResidue(Long id) {
        return pesticideResidueMapper.selectById(id);
    }

    @Override
    public PageResult<GapPesticideResidueDO> getPesticideResiduePage(GapPesticideResiduePageReqVO pageReqVO) {
        return pesticideResidueMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPesticideResidueDO> getPesticideResidueList() {
        return pesticideResidueMapper.selectList();
    }

    @Override
    public List<GapPesticideResidueDO> getPesticideResidueList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return pesticideResidueMapper.selectByIds(ids);
    }

    @Override
    public List<GapPesticideResidueDO> getPesticideResidueListByTaskId(Long taskId) {
        return pesticideResidueMapper.selectListByTaskId(taskId);
    }

    @Override
    public List<GapPesticideResidueDO> getPesticideResidueListByReportId(Long reportId) {
        return pesticideResidueMapper.selectListByReportId(reportId);
    }

    @Override
    public GapPesticideResidueDO validatePesticideResidueExists(Long id) {
        GapPesticideResidueDO pesticideResidue = pesticideResidueMapper.selectById(id);
        if (pesticideResidue == null) {
            throw exception(PESTICIDE_RESIDUE_NOT_EXISTS);
        }
        return pesticideResidue;
    }

}
