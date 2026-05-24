package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapPersonHealthDO;
import cn.iocoder.yudao.module.gap.dal.mysql.training.GapPersonHealthMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.TRAINING_COURSE_NOT_EXISTS;

/**
 * GAP 人员健康档案 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapPersonHealthServiceImpl implements GapPersonHealthService {

    @Resource
    private GapPersonHealthMapper personHealthMapper;

    @Override
    public Long createPersonHealth(GapPersonHealthSaveReqVO createReqVO) {
        // 1. 插入
        GapPersonHealthDO personHealth = BeanUtils.toBean(createReqVO, GapPersonHealthDO.class);
        personHealthMapper.insert(personHealth);
        return personHealth.getId();
    }

    @Override
    public void updatePersonHealth(GapPersonHealthSaveReqVO updateReqVO) {
        // 1. 校验存在
        validatePersonHealthExists(updateReqVO.getId());

        // 2. 更新
        GapPersonHealthDO updateObj = BeanUtils.toBean(updateReqVO, GapPersonHealthDO.class);
        personHealthMapper.updateById(updateObj);
    }

    @Override
    public void deletePersonHealth(Long id) {
        // 1. 校验存在
        validatePersonHealthExists(id);

        // 2. 删除
        personHealthMapper.deleteById(id);
    }

    @Override
    public GapPersonHealthDO getPersonHealth(Long id) {
        return personHealthMapper.selectById(id);
    }

    @Override
    public PageResult<GapPersonHealthDO> getPersonHealthPage(GapPersonHealthPageReqVO pageReqVO) {
        return personHealthMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPersonHealthDO> getPersonHealthList() {
        return personHealthMapper.selectList();
    }

    @Override
    public List<GapPersonHealthDO> getPersonHealthListByUserId(Long userId) {
        return personHealthMapper.selectListByUserId(userId);
    }

    @Override
    public GapPersonHealthDO validatePersonHealthExists(Long id) {
        GapPersonHealthDO personHealth = personHealthMapper.selectById(id);
        if (personHealth == null) {
            throw exception(TRAINING_COURSE_NOT_EXISTS);
        }
        return personHealth;
    }

}
