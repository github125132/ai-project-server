package cn.iocoder.yudao.module.gap.service.quality;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.quality.GapQualityStandardDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 质量标准 Service 接口
 *
 * @author 芋道源码
 */
public interface GapQualityStandardService {

    /**
     * 创建质量标准
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createQualityStandard(@Valid GapQualityStandardSaveReqVO createReqVO);

    /**
     * 更新质量标准
     *
     * @param updateReqVO 更新信息
     */
    void updateQualityStandard(@Valid GapQualityStandardSaveReqVO updateReqVO);

    /**
     * 删除质量标准
     *
     * @param id 编号
     */
    void deleteQualityStandard(Long id);

    /**
     * 获得质量标准
     *
     * @param id 编号
     * @return 质量标准
     */
    GapQualityStandardDO getQualityStandard(Long id);

    /**
     * 获得质量标准分页
     *
     * @param pageReqVO 分页查询
     * @return 质量标准分页
     */
    PageResult<GapQualityStandardDO> getQualityStandardPage(GapQualityStandardPageReqVO pageReqVO);

    /**
     * 获得质量标准列表
     *
     * @return 质量标准列表
     */
    List<GapQualityStandardDO> getQualityStandardList();

    /**
     * 获得质量标准列表
     *
     * @param ids 标准编号集合
     * @return 质量标准列表
     */
    List<GapQualityStandardDO> getQualityStandardList(Collection<Long> ids);

    /**
     * 校验质量标准存在
     *
     * @param id 编号
     * @return 质量标准
     */
    GapQualityStandardDO validateQualityStandardExists(Long id);

}
