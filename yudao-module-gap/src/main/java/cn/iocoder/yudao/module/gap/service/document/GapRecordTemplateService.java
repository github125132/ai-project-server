package cn.iocoder.yudao.module.gap.service.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplatePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapRecordTemplateSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapRecordTemplateDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 记录模板 Service 接口
 *
 * @author 芋道源码
 */
public interface GapRecordTemplateService {

    /**
     * 创建记录模板
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRecordTemplate(@Valid GapRecordTemplateSaveReqVO createReqVO);

    /**
     * 更新记录模板
     *
     * @param updateReqVO 更新信息
     */
    void updateRecordTemplate(@Valid GapRecordTemplateSaveReqVO updateReqVO);

    /**
     * 删除记录模板
     *
     * @param id 编号
     */
    void deleteRecordTemplate(Long id);

    /**
     * 获得记录模板
     *
     * @param id 编号
     * @return 记录模板
     */
    GapRecordTemplateDO getRecordTemplate(Long id);

    /**
     * 获得记录模板分页
     *
     * @param pageReqVO 分页查询
     * @return 记录模板分页
     */
    PageResult<GapRecordTemplateDO> getRecordTemplatePage(GapRecordTemplatePageReqVO pageReqVO);

    /**
     * 获得记录模板列表
     *
     * @return 记录模板列表
     */
    List<GapRecordTemplateDO> getRecordTemplateList();

    /**
     * 根据分类ID获得记录模板列表
     *
     * @param categoryId 分类编号
     * @return 记录模板列表
     */
    List<GapRecordTemplateDO> getRecordTemplateListByCategoryId(Long categoryId);

    /**
     * 校验记录模板存在
     *
     * @param id 编号
     * @return 记录模板
     */
    GapRecordTemplateDO validateRecordTemplateExists(Long id);

}
