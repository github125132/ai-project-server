package cn.iocoder.yudao.module.gap.service.origin;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifyPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.origin.vo.GapOriginIdentifySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.origin.GapOriginIdentifyDO;
import cn.iocoder.yudao.module.gap.dal.mysql.origin.GapOriginIdentifyMapper;
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
public class GapOriginIdentifyServiceImpl implements GapOriginIdentifyService {

    @Resource
    private GapOriginIdentifyMapper originIdentifyMapper;

    @Override
    public Long createOriginIdentify(GapOriginIdentifySaveReqVO createReqVO) {
        GapOriginIdentifyDO originIdentify = BeanUtils.toBean(createReqVO, GapOriginIdentifyDO.class);
        originIdentifyMapper.insert(originIdentify);
        return originIdentify.getId();
    }

    @Override
    public void updateOriginIdentify(GapOriginIdentifySaveReqVO updateReqVO) {
        validateOriginIdentifyExists(updateReqVO.getId());

        GapOriginIdentifyDO updateObj = BeanUtils.toBean(updateReqVO, GapOriginIdentifyDO.class);
        originIdentifyMapper.updateById(updateObj);
    }

    @Override
    public void deleteOriginIdentify(Long id) {
        validateOriginIdentifyExists(id);
        originIdentifyMapper.deleteById(id);
    }

    @Override
    public GapOriginIdentifyDO getOriginIdentify(Long id) {
        return originIdentifyMapper.selectById(id);
    }

    @Override
    public PageResult<GapOriginIdentifyDO> getOriginIdentifyPage(GapOriginIdentifyPageReqVO pageReqVO) {
        return originIdentifyMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapOriginIdentifyDO> getOriginIdentifyList() {
        return originIdentifyMapper.selectList();
    }

    @Override
    public List<GapOriginIdentifyDO> getOriginIdentifyList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return originIdentifyMapper.selectByIds(ids);
    }

    @Override
    public List<GapOriginIdentifyDO> getOriginIdentifyListByVarietyId(Long varietyId) {
        return originIdentifyMapper.selectListByVarietyId(varietyId);
    }

    @Override
    public List<GapOriginIdentifyDO> getOriginIdentifyListBySeedBatchId(Long seedBatchId) {
        return originIdentifyMapper.selectListBySeedBatchId(seedBatchId);
    }

    @Override
    public GapOriginIdentifyDO validateOriginIdentifyExists(Long id) {
        GapOriginIdentifyDO originIdentify = originIdentifyMapper.selectById(id);
        if (originIdentify == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return originIdentify;
    }

}
