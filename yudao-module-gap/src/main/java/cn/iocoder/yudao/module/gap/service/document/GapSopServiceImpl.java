package cn.iocoder.yudao.module.gap.service.document;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapSopDO;
import cn.iocoder.yudao.module.gap.dal.mysql.document.GapSopMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP SOP库 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapSopServiceImpl implements GapSopService {

    @Resource
    private GapSopMapper sopMapper;

    @Override
    public Long createSop(GapSopSaveReqVO createReqVO) {
        // 1. 校验SOP编号唯一
        validateSopNoUnique(null, createReqVO.getSopNo());

        // 2. 插入
        GapSopDO sop = BeanUtils.toBean(createReqVO, GapSopDO.class);
        sopMapper.insert(sop);
        return sop.getId();
    }

    @Override
    public void updateSop(GapSopSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateSopExists(updateReqVO.getId());
        // 1.2 校验SOP编号唯一
        validateSopNoUnique(updateReqVO.getId(), updateReqVO.getSopNo());

        // 2. 更新
        GapSopDO updateObj = BeanUtils.toBean(updateReqVO, GapSopDO.class);
        sopMapper.updateById(updateObj);
    }

    @Override
    public void deleteSop(Long id) {
        // 1. 校验存在
        validateSopExists(id);

        // 2. 删除
        sopMapper.deleteById(id);
    }

    @Override
    public GapSopDO getSop(Long id) {
        return sopMapper.selectById(id);
    }

    @Override
    public PageResult<GapSopDO> getSopPage(GapSopPageReqVO pageReqVO) {
        return sopMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapSopDO> getSopList() {
        return sopMapper.selectList();
    }

    @Override
    public GapSopDO validateSopExists(Long id) {
        GapSopDO sop = sopMapper.selectById(id);
        if (sop == null) {
            throw exception(DOCUMENT_NOT_EXISTS);
        }
        return sop;
    }

    private void validateSopNoUnique(Long id, String sopNo) {
        if (sopNo == null || sopNo.isEmpty()) {
            return;
        }
        GapSopDO sop = sopMapper.selectBySopNo(sopNo);
        if (sop == null) {
            return;
        }
        if (ObjUtil.notEqual(id, sop.getId())) {
            throw exception(BASE_CODE_DUPLICATE);
        }
    }

}
