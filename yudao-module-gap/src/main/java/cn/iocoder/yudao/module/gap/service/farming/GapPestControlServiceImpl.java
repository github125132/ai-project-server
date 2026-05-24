package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPestControlDO;
import cn.iocoder.yudao.module.gap.dal.mysql.farming.GapPestControlMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.INPUT_PRODUCT_NOT_EXISTS;

/**
 * GAP 病虫害防治方案 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapPestControlServiceImpl implements GapPestControlService {

    @Resource
    private GapPestControlMapper pestControlMapper;

    @Override
    public Long createPestControl(GapPestControlSaveReqVO createReqVO) {
        // 插入
        GapPestControlDO pestControl = BeanUtils.toBean(createReqVO, GapPestControlDO.class);
        pestControlMapper.insert(pestControl);
        return pestControl.getId();
    }

    @Override
    public void updatePestControl(GapPestControlSaveReqVO updateReqVO) {
        // 校验存在
        validatePestControlExists(updateReqVO.getId());

        // 更新
        GapPestControlDO updateObj = BeanUtils.toBean(updateReqVO, GapPestControlDO.class);
        pestControlMapper.updateById(updateObj);
    }

    @Override
    public void deletePestControl(Long id) {
        // 校验存在
        validatePestControlExists(id);

        // 删除
        pestControlMapper.deleteById(id);
    }

    @Override
    public GapPestControlDO getPestControl(Long id) {
        return pestControlMapper.selectById(id);
    }

    @Override
    public PageResult<GapPestControlDO> getPestControlPage(GapPestControlPageReqVO pageReqVO) {
        return pestControlMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPestControlDO> getPestControlList() {
        return pestControlMapper.selectList();
    }

    @Override
    public List<GapPestControlDO> getPestControlListByBaseId(Long baseId) {
        return pestControlMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapPestControlDO> getPestControlListByVarietyId(Long varietyId) {
        return pestControlMapper.selectListByVarietyId(varietyId);
    }

    @Override
    public GapPestControlDO validatePestControlExists(Long id) {
        GapPestControlDO pestControl = pestControlMapper.selectById(id);
        if (pestControl == null) {
            throw exception(INPUT_PRODUCT_NOT_EXISTS);
        }
        return pestControl;
    }

}
