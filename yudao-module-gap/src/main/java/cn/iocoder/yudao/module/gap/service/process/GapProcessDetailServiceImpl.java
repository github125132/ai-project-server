package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessDetailDO;
import cn.iocoder.yudao.module.gap.dal.mysql.process.GapProcessDetailMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.PROCESS_RECORD_NOT_EXISTS;

/**
 * GAP 加工工序明细 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapProcessDetailServiceImpl implements GapProcessDetailService {

    @Resource
    private GapProcessDetailMapper processDetailMapper;

    @Override
    public Long createProcessDetail(GapProcessDetailSaveReqVO createReqVO) {
        // 插入
        GapProcessDetailDO processDetail = BeanUtils.toBean(createReqVO, GapProcessDetailDO.class);
        processDetailMapper.insert(processDetail);
        return processDetail.getId();
    }

    @Override
    public void updateProcessDetail(GapProcessDetailSaveReqVO updateReqVO) {
        // 1. 校验存在
        validateProcessDetailExists(updateReqVO.getId());

        // 2. 更新
        GapProcessDetailDO updateObj = BeanUtils.toBean(updateReqVO, GapProcessDetailDO.class);
        processDetailMapper.updateById(updateObj);
    }

    @Override
    public void deleteProcessDetail(Long id) {
        // 1. 校验存在
        validateProcessDetailExists(id);

        // 2. 删除
        processDetailMapper.deleteById(id);
    }

    @Override
    public GapProcessDetailDO getProcessDetail(Long id) {
        return processDetailMapper.selectById(id);
    }

    @Override
    public PageResult<GapProcessDetailDO> getProcessDetailPage(GapProcessDetailPageReqVO pageReqVO) {
        return processDetailMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapProcessDetailDO> getProcessDetailListByProcessRecordId(Long processRecordId) {
        return processDetailMapper.selectListByProcessRecordId(processRecordId);
    }

    @Override
    public GapProcessDetailDO validateProcessDetailExists(Long id) {
        GapProcessDetailDO processDetail = processDetailMapper.selectById(id);
        if (processDetail == null) {
            throw exception(PROCESS_RECORD_NOT_EXISTS);
        }
        return processDetail;
    }

}
