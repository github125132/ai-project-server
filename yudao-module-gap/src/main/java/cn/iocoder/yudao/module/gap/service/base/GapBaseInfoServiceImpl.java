package cn.iocoder.yudao.module.gap.service.base;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.GapBaseInfoDO;
import cn.iocoder.yudao.module.gap.dal.mysql.base.GapBaseInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 基地信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapBaseInfoServiceImpl implements GapBaseInfoService {

    @Resource
    private GapBaseInfoMapper baseInfoMapper;

    @Override
    public Long createBaseInfo(GapBaseInfoSaveReqVO createReqVO) {
        // 1. 校验编码唯一
        validateBaseInfoCodeUnique(null, createReqVO.getCode());
        // 1.2 校验名称唯一
        validateBaseInfoNameUnique(null, createReqVO.getName());

        // 2. 插入
        GapBaseInfoDO baseInfo = BeanUtils.toBean(createReqVO, GapBaseInfoDO.class);
        baseInfoMapper.insert(baseInfo);
        return baseInfo.getId();
    }

    @Override
    public void updateBaseInfo(GapBaseInfoSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateBaseInfoExists(updateReqVO.getId());
        // 1.2 校验编码唯一
        validateBaseInfoCodeUnique(updateReqVO.getId(), updateReqVO.getCode());
        // 1.3 校验名称唯一
        validateBaseInfoNameUnique(updateReqVO.getId(), updateReqVO.getName());

        // 2. 更新
        GapBaseInfoDO updateObj = BeanUtils.toBean(updateReqVO, GapBaseInfoDO.class);
        baseInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteBaseInfo(Long id) {
        // 1. 校验存在
        validateBaseInfoExists(id);

        // 2. 删除
        baseInfoMapper.deleteById(id);
    }

    @Override
    public GapBaseInfoDO getBaseInfo(Long id) {
        return baseInfoMapper.selectById(id);
    }

    @Override
    public PageResult<GapBaseInfoDO> getBaseInfoPage(GapBaseInfoPageReqVO pageReqVO) {
        return baseInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapBaseInfoDO> getBaseInfoList() {
        return baseInfoMapper.selectList();
    }

    @Override
    public List<GapBaseInfoDO> getBaseInfoList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return baseInfoMapper.selectByIds(ids);
    }

    @Override
    public GapBaseInfoDO validateBaseInfoExists(Long id) {
        GapBaseInfoDO baseInfo = baseInfoMapper.selectById(id);
        if (baseInfo == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return baseInfo;
    }

    private void validateBaseInfoCodeUnique(Long id, String code) {
        if (code == null || code.isEmpty()) {
            return;
        }
        GapBaseInfoDO baseInfo = baseInfoMapper.selectByCode(code);
        if (baseInfo == null) {
            return;
        }
        if (ObjUtil.notEqual(id, baseInfo.getId())) {
            throw exception(BASE_CODE_DUPLICATE);
        }
    }

    private void validateBaseInfoNameUnique(Long id, String name) {
        if (name == null || name.isEmpty()) {
            return;
        }
        GapBaseInfoDO baseInfo = baseInfoMapper.selectByName(name);
        if (baseInfo == null) {
            return;
        }
        if (ObjUtil.notEqual(id, baseInfo.getId())) {
            throw exception(BASE_NAME_DUPLICATE);
        }
    }

}
