package cn.iocoder.yudao.module.gap.service.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapDocumentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapDocumentDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 文件档案 Service 接口
 *
 * @author 芋道源码
 */
public interface GapDocumentService {

    /**
     * 创建文件档案
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createDocument(@Valid GapDocumentSaveReqVO createReqVO);

    /**
     * 更新文件档案
     *
     * @param updateReqVO 更新信息
     */
    void updateDocument(@Valid GapDocumentSaveReqVO updateReqVO);

    /**
     * 删除文件档案
     *
     * @param id 编号
     */
    void deleteDocument(Long id);

    /**
     * 获得文件档案
     *
     * @param id 编号
     * @return 文件档案
     */
    GapDocumentDO getDocument(Long id);

    /**
     * 获得文件档案分页
     *
     * @param pageReqVO 分页查询
     * @return 文件档案分页
     */
    PageResult<GapDocumentDO> getDocumentPage(GapDocumentPageReqVO pageReqVO);

    /**
     * 获得文件档案列表
     *
     * @return 文件档案列表
     */
    List<GapDocumentDO> getDocumentList();

    /**
     * 根据分类ID获得文件档案列表
     *
     * @param categoryId 分类编号
     * @return 文件档案列表
     */
    List<GapDocumentDO> getDocumentListByCategoryId(Long categoryId);

    /**
     * 校验文件档案存在
     *
     * @param id 编号
     * @return 文件档案
     */
    GapDocumentDO validateDocumentExists(Long id);

}
