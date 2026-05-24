package cn.iocoder.yudao.module.gap.service.document;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentDO;
import cn.iocoder.yudao.module.gap.dal.mysql.document.GapDocumentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gap.enums.ErrorCodeConstants.*;

/**
 * GAP 文件档案 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class GapDocumentServiceImpl implements GapDocumentService {

    @Resource
    private GapDocumentMapper documentMapper;

    @Override
    public Long createDocument(GapDocumentSaveReqVO createReqVO) {
        // 1. 校验文件编号唯一
        validateDocumentDocNoUnique(null, createReqVO.getDocNo());

        // 2. 插入
        GapDocumentDO document = BeanUtils.toBean(createReqVO, GapDocumentDO.class);
        documentMapper.insert(document);
        return document.getId();
    }

    @Override
    public void updateDocument(GapDocumentSaveReqVO updateReqVO) {
        // 1.1 校验存在
        validateDocumentExists(updateReqVO.getId());
        // 1.2 校验文件编号唯一
        validateDocumentDocNoUnique(updateReqVO.getId(), updateReqVO.getDocNo());

        // 2. 更新
        GapDocumentDO updateObj = BeanUtils.toBean(updateReqVO, GapDocumentDO.class);
        documentMapper.updateById(updateObj);
    }

    @Override
    public void deleteDocument(Long id) {
        // 1. 校验存在
        validateDocumentExists(id);

        // 2. 删除
        documentMapper.deleteById(id);
    }

    @Override
    public GapDocumentDO getDocument(Long id) {
        return documentMapper.selectById(id);
    }

    @Override
    public PageResult<GapDocumentDO> getDocumentPage(GapDocumentPageReqVO pageReqVO) {
        return documentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<GapDocumentDO> getDocumentList() {
        return documentMapper.selectList();
    }

    @Override
    public List<GapDocumentDO> getDocumentListByCategoryId(Long categoryId) {
        return documentMapper.selectListByCategoryId(categoryId);
    }

    @Override
    public GapDocumentDO validateDocumentExists(Long id) {
        GapDocumentDO document = documentMapper.selectById(id);
        if (document == null) {
            throw exception(DOCUMENT_NOT_EXISTS);
        }
        return document;
    }

    private void validateDocumentDocNoUnique(Long id, String docNo) {
        if (docNo == null || docNo.isEmpty()) {
            return;
        }
        GapDocumentDO document = documentMapper.selectByDocNo(docNo);
        if (document == null) {
            return;
        }
        if (ObjUtil.notEqual(id, document.getId())) {
            throw exception(BASE_CODE_DUPLICATE);
        }
    }

}
