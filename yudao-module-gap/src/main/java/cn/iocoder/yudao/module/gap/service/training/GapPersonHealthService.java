package cn.iocoder.yudao.module.gap.service.training;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.training.vo.GapPersonHealthSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.training.GapPersonHealthDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 人员健康档案 Service 接口
 *
 * @author 芋道源码
 */
public interface GapPersonHealthService {

    /**
     * 创建人员健康档案
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPersonHealth(@Valid GapPersonHealthSaveReqVO createReqVO);

    /**
     * 更新人员健康档案
     *
     * @param updateReqVO 更新信息
     */
    void updatePersonHealth(@Valid GapPersonHealthSaveReqVO updateReqVO);

    /**
     * 删除人员健康档案
     *
     * @param id 编号
     */
    void deletePersonHealth(Long id);

    /**
     * 获得人员健康档案
     *
     * @param id 编号
     * @return 人员健康档案
     */
    GapPersonHealthDO getPersonHealth(Long id);

    /**
     * 获得人员健康档案分页
     *
     * @param pageReqVO 分页查询
     * @return 人员健康档案分页
     */
    PageResult<GapPersonHealthDO> getPersonHealthPage(GapPersonHealthPageReqVO pageReqVO);

    /**
     * 获得人员健康档案列表
     *
     * @return 人员健康档案列表
     */
    List<GapPersonHealthDO> getPersonHealthList();

    /**
     * 根据人员编号获得健康档案列表
     *
     * @param userId 人员编号
     * @return 健康档案列表
     */
    List<GapPersonHealthDO> getPersonHealthListByUserId(Long userId);

    /**
     * 校验人员健康档案存在
     *
     * @param id 编号
     * @return 人员健康档案
     */
    GapPersonHealthDO validatePersonHealthExists(Long id);

}
