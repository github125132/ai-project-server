package cn.iocoder.yudao.module.gap.service.farming;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPestControlDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 病虫害防治方案 Service 接口
 *
 * @author 芋道源码
 */
public interface GapPestControlService {

    /**
     * 创建病虫害防治方案
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPestControl(@Valid GapPestControlSaveReqVO createReqVO);

    /**
     * 更新病虫害防治方案
     *
     * @param updateReqVO 更新信息
     */
    void updatePestControl(@Valid GapPestControlSaveReqVO updateReqVO);

    /**
     * 删除病虫害防治方案
     *
     * @param id 编号
     */
    void deletePestControl(Long id);

    /**
     * 获得病虫害防治方案
     *
     * @param id 编号
     * @return 病虫害防治方案
     */
    GapPestControlDO getPestControl(Long id);

    /**
     * 获得病虫害防治方案分页
     *
     * @param pageReqVO 分页查询
     * @return 病虫害防治方案分页
     */
    PageResult<GapPestControlDO> getPestControlPage(GapPestControlPageReqVO pageReqVO);

    /**
     * 获得病虫害防治方案列表
     *
     * @return 病虫害防治方案列表
     */
    List<GapPestControlDO> getPestControlList();

    /**
     * 根据基地编号获得病虫害防治方案列表
     *
     * @param baseId 基地编号
     * @return 病虫害防治方案列表
     */
    List<GapPestControlDO> getPestControlListByBaseId(Long baseId);

    /**
     * 根据品种编号获得病虫害防治方案列表
     *
     * @param varietyId 品种编号
     * @return 病虫害防治方案列表
     */
    List<GapPestControlDO> getPestControlListByVarietyId(Long varietyId);

    /**
     * 校验病虫害防治方案存在
     *
     * @param id 编号
     * @return 病虫害防治方案
     */
    GapPestControlDO validatePestControlExists(Long id);

}
