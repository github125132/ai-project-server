package cn.iocoder.yudao.module.gap.service.inspect;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapHeavyMetalDO;
import cn.iocoder.yudao.module.gap.dal.mysql.inspect.GapHeavyMetalMapper;
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
public class GapHeavyMetalServiceImpl implements GapHeavyMetalService {

    @Resource
    private GapHeavyMetalMapper heavyMetalMapper;

    @Override
    public Long createHeavyMetal(GapHeavyMetalSaveReqVO createReqVO) {
        GapHeavyMetalDO heavyMetal = BeanUtils.toBean(createReqVO, GapHeavyMetalDO.class);
        heavyMetalMapper.insert(heavyMetal);
        return heavyMetal.getId();
    }

    @Override
    public void updateHeavyMetal(GapHeavyMetalSaveReqVO updateReqVO) {
        validateHeavyMetalExists(updateReqVO.getId());
        GapHeavyMetalDO updateObj = BeanUtils.toBean(updateReqVO, GapHeavyMetalDO.class);
        heavyMetalMapper.updateById(updateObj);
    }

    @Override
    public void deleteHeavyMetal(Long id) {
        validateHeavyMetalExists(id);
        heavyMetalMapper.deleteById(id);
    }

    @Override
    public GapHeavyMetalDO getHeavyMetal(Long id) {
        return heavyMetalMapper.selectById(id);
    }

    @Override
    public PageResult<GapHeavyMetalDO> getHeavyMetalPage(GapHeavyMetalPageReqVO pageReqVO) {
        return heavyMetalMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapHeavyMetalDO> getHeavyMetalList() {
        return heavyMetalMapper.selectList();
    }

    @Override
    public List<GapHeavyMetalDO> getHeavyMetalList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return heavyMetalMapper.selectByIds(ids);
    }

    @Override
    public List<GapHeavyMetalDO> getHeavyMetalListByTaskId(Long taskId) {
        return heavyMetalMapper.selectListByTaskId(taskId);
    }

    @Override
    public List<GapHeavyMetalDO> getHeavyMetalListByReportId(Long reportId) {
        return heavyMetalMapper.selectListByReportId(reportId);
    }

    @Override
    public GapHeavyMetalDO validateHeavyMetalExists(Long id) {
        GapHeavyMetalDO heavyMetal = heavyMetalMapper.selectById(id);
        if (heavyMetal == null) {
            throw exception(HEAVY_METAL_NOT_EXISTS);
        }
        return heavyMetal;
    }

}
