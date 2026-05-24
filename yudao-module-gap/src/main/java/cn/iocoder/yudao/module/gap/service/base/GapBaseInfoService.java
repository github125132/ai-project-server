package cn.iocoder.yudao.module.gap.service.base;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.GapBaseInfoSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.GapBaseInfoDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 基地信息 Service 接口
 *
 * @author 芋道源码
 */
public interface GapBaseInfoService {

    /**
     * 创建基地信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createBaseInfo(@Valid GapBaseInfoSaveReqVO createReqVO);

    /**
     * 更新基地信息
     *
     * @param updateReqVO 更新信息
     */
    void updateBaseInfo(@Valid GapBaseInfoSaveReqVO updateReqVO);

    /**
     * 删除基地信息
     *
     * @param id 编号
     */
    void deleteBaseInfo(Long id);

    /**
     * 获得基地信息
     *
     * @param id 编号
     * @return 基地信息
     */
    GapBaseInfoDO getBaseInfo(Long id);

    /**
     * 获得基地信息分页
     *
     * @param pageReqVO 分页查询
     * @return 基地信息分页
     */
    PageResult<GapBaseInfoDO> getBaseInfoPage(GapBaseInfoPageReqVO pageReqVO);

    /**
     * 获得基地信息列表
     *
     * @return 基地信息列表
     */
    List<GapBaseInfoDO> getBaseInfoList();

    /**
     * 获得基地信息列表
     *
     * @param ids 基地编号集合
     * @return 基地信息列表
     */
    List<GapBaseInfoDO> getBaseInfoList(Collection<Long> ids);

    /**
     * 校验基地信息存在
     *
     * @param id 编号
     * @return 基地信息
     */
    GapBaseInfoDO validateBaseInfoExists(Long id);

}
