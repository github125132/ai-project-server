package cn.iocoder.yudao.module.gap.service.document;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplatePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplateSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapRecordTemplateDO;
import cn.iocoder.yudao.module.gap.dal.mysql.document.GapRecordTemplateMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 记录模板 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapRecordTemplateServiceImpl implements GapRecordTemplateService {

    @Resource
    private GapRecordTemplateMapper recordTemplateMapper;

    @Override
    public Long createRecordTemplate(GapRecordTemplateSaveReqVO createReqVO) {
        // 1. 校验模板编号唯一
        validateRecordTemplateNoUnique(null, createReqVO.getTemplateNo());

        // 2. 插入
        GapRecordTemplateDO recordTemplate = BeanUtils.toBean(createReqVO, GapRecordTemplateDO.class);
        recordTemplateMapper.insert(recordTemplate);
        return recordTemplate.getId();
    }

    @Override
    public void updateRecordTemplate(GapRecordTemplateSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateRecordTemplateExists(updateReqVO.getId());
        // 1.2 校验模板编号唯一
        validateRecordTemplateNoUnique(updateReqVO.getId(), updateReqVO.getTemplateNo());

        // 2. 更新
        GapRecordTemplateDO updateObj = BeanUtils.toBean(updateReqVO, GapRecordTemplateDO.class);
        recordTemplateMapper.updateById(updateObj);
    }

    @Override
    public void deleteRecordTemplate(Long id) {
        // 1. 校验存在
        validateRecordTemplateExists(id);

        // 2. 删除
        recordTemplateMapper.deleteById(id);
    }

    @Override
    public GapRecordTemplateDO getRecordTemplate(Long id) {
        return recordTemplateMapper.selectById(id);
    }

    @Override
    public PageResult<GapRecordTemplateDO> getRecordTemplatePage(GapRecordTemplatePageReqVO pageReqVO) {
        return recordTemplateMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapRecordTemplateDO> getRecordTemplateList() {
        return recordTemplateMapper.selectList();
    }

    @Override
    public List<GapRecordTemplateDO> getRecordTemplateListByCategoryId(Long categoryId) {
        return recordTemplateMapper.selectListByCategoryId(categoryId);
    }

    @Override
    public GapRecordTemplateDO validateRecordTemplateExists(Long id) {
        GapRecordTemplateDO recordTemplate = recordTemplateMapper.selectById(id);
        if (recordTemplate == null) {
            throw exception(DOCUMENT_NOT_EXISTS);
        }
        return recordTemplate;
    }

    private void validateRecordTemplateNoUnique(Long id, String templateNo) {
        if (templateNo == null || templateNo.isEmpty()) {
            return;
        }
        GapRecordTemplateDO recordTemplate = recordTemplateMapper.selectByTemplateNo(templateNo);
        if (recordTemplate == null) {
            return;
        }
        if (ObjUtil.notEqual(id, recordTemplate.getId())) {
            throw exception(BASE_CODE_DUPLICATE);
        }
    }

}
