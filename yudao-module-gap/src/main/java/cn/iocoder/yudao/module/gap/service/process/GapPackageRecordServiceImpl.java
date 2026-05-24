package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapPackageRecordDO;
import cn.iocoder.yudao.module.gap.dal.mysql.process.GapPackageRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.PROCESS_RECORD_NOT_EXISTS;

/**
 * GAP 包装记录 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapPackageRecordServiceImpl implements GapPackageRecordService {

    @Resource
    private GapPackageRecordMapper packageRecordMapper;

    @Override
    public Long createPackageRecord(GapPackageRecordSaveReqVO createReqVO) {
        // 插入
        GapPackageRecordDO packageRecord = BeanUtils.toBean(createReqVO, GapPackageRecordDO.class);
        packageRecordMapper.insert(packageRecord);
        return packageRecord.getId();
    }

    @Override
    public void updatePackageRecord(GapPackageRecordSaveReqVO updateReqVO) {
        // 1. 校验存在
        validatePackageRecordExists(updateReqVO.getId());

        // 2. 更新
        GapPackageRecordDO updateObj = BeanUtils.toBean(updateReqVO, GapPackageRecordDO.class);
        packageRecordMapper.updateById(updateObj);
    }

    @Override
    public void deletePackageRecord(Long id) {
        // 1. 校验存在
        validatePackageRecordExists(id);

        // 2. 删除
        packageRecordMapper.deleteById(id);
    }

    @Override
    public GapPackageRecordDO getPackageRecord(Long id) {
        return packageRecordMapper.selectById(id);
    }

    @Override
    public PageResult<GapPackageRecordDO> getPackageRecordPage(GapPackageRecordPageReqVO pageReqVO) {
        return packageRecordMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapPackageRecordDO> getPackageRecordList() {
        return packageRecordMapper.selectList();
    }

    @Override
    public List<GapPackageRecordDO> getPackageRecordListByProcessRecordId(Long processRecordId) {
        return packageRecordMapper.selectListByProcessRecordId(processRecordId);
    }

    @Override
    public GapPackageRecordDO validatePackageRecordExists(Long id) {
        GapPackageRecordDO packageRecord = packageRecordMapper.selectById(id);
        if (packageRecord == null) {
            throw exception(PROCESS_RECORD_NOT_EXISTS);
        }
        return packageRecord;
    }

}
