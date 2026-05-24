package cn.iocoder.yudao.module.gap.service.input;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputUseRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.input.GapInputUseRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.BASE_NOT_EXISTS;

/**
 * GAP 投入品使用记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapInputUseRecordServiceImpl implements GapInputUseRecordService {

    @Resource
    private GapInputUseRecordMapper inputUseRecordMapper;

    @Override
    public Long createInputUseRecord(GapInputUseRecordSaveReqVO createReqVO) {
        // 插入
        GapInputUseRecordDO record = BeanUtils.toBean(createReqVO, GapInputUseRecordDO.class);
        inputUseRecordMapper.insert(record);
        return record.getId();
    }

    @Override
    public void updateInputUseRecord(GapInputUseRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateInputUseRecordExists(updateReqVO.getId());

        // 2. 更新
        GapInputUseRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapInputUseRecordDO.class);
        inputUseRecordMapper.updateById(updateObj);
    }

    @Override
    public void deleteInputUseRecord(Long id) {
        // 1. 校验存在
        validateInputUseRecordExists(id);

        // 2. 删除
        inputUseRecordMapper.deleteById(id);
    }

    @Override
    public GapInputUseRecordDO getInputUseRecord(Long id) {
        return inputUseRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapInputUseRecordDO> getInputUseRecordPage(GapInputUseRecordPageReqVO pageReqVO) {
        return inputUseRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapInputUseRecordDO> getInputUseRecordList() {
        return inputUseRecordMapper.selectList();
    }

    @Override
    public List<GapInputUseRecordDO> getInputUseRecordList(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return Collections.emptyList();
        }
        return inputUseRecordMapper.selectByIds(ids);
    }

    @Override
    public List<GapInputUseRecordDO> getInputUseRecordListByBaseId(Long baseId) {
        return inputUseRecordMapper.selectListByBaseId(baseId);
    }

    @Override
    public List<GapInputUseRecordDO> getInputUseRecordListByPlotId(Long plotId) {
        return inputUseRecordMapper.selectListByPlotId(plotId);
    }

    @Override
    public GapInputUseRecordDO validateInputUseRecordExists(Long id) {
        GapInputUseRecordDO record = inputUseRecordMapper.selectById(id);
        if (record == null) {
            throw exception(BASE_NOT_EXISTS);
        }
        return record;
    }

}
