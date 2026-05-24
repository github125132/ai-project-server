package cn.iocoder.yudao.module.gap.service.document;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.document.vo.GapSopSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.document.GapSopDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP SOP库 Service 接口
 *
 * @author 芋道源码
 */
public interface GapSopService {

    /**
     * 创建SOP
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSop(@Valid GapSopSaveReqVO createReqVO);

    /**
     * 更新SOP
     *
     * @param updateReqVO 更新信息
     */
    void updateSop(@Valid GapSopSaveReqVO updateReqVO);

    /**
     * 删除SOP
     *
     * @param id 编号
     */
    void deleteSop(Long id);

    /**
     * 获得SOP
     *
     * @param id 编号
     * @return SOP
     */
    GapSopDO getSop(Long id);

    /**
     * 获得SOP分页
     *
     * @param pageReqVO 分页查询
     * @return SOP分页
     */
    PageResult<GapSopDO> getSopPage(GapSopPageReqVO pageReqVO);

    /**
     * 获得SOP列表
     *
     * @return SOP列表
     */
    List<GapSopDO> getSopList();

    /**
     * 校验SOP存在
     *
     * @param id 编号
     * @return SOP
     */
    GapSopDO validateSopExists(Long id);

}
