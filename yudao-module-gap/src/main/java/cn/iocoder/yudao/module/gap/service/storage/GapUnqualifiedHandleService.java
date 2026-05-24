package cn.iocoder.yudao.module.gap.service.storage;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandlePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandleSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapUnqualifiedHandleDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 不合格品处理 Service 接口
 *
 * @author 芋道源码
 */
public interface GapUnqualifiedHandleService {

    /**
     * 创建不合格品处理
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createUnqualifiedHandle(@Valid GapUnqualifiedHandleSaveReqVO createReqVO);

    /**
     * 更新不合格品处理
     *
     * @param updateReqVO 更新信息
     */
    void updateUnqualifiedHandle(@Valid GapUnqualifiedHandleSaveReqVO updateReqVO);

    /**
     * 删除不合格品处理
     *
     * @param id 编号
     */
    void deleteUnqualifiedHandle(Long id);

    /**
     * 获得不合格品处理
     *
     * @param id 编号
     * @return 不合格品处理
     */
    GapUnqualifiedHandleDO getUnqualifiedHandle(Long id);

    /**
     * 获得不合格品处理分页
     *
     * @param pageReqVO 分页查询
     * @return 不合格品处理分页
     */
    PageResult<GapUnqualifiedHandleDO> getUnqualifiedHandlePage(GapUnqualifiedHandlePageReqVO pageReqVO);

    /**
     * 获得不合格品处理列表
     *
     * @return 不合格品处理列表
     */
    List<GapUnqualifiedHandleDO> getUnqualifiedHandleList();

    /**
     * 获得不合格品处理列表
     *
     * @param ids 编号集合
     * @return 不合格品处理列表
     */
    List<GapUnqualifiedHandleDO> getUnqualifiedHandleList(Collection<Long> ids);

    /**
     * 根据批次号获得不合格品处理列表
     *
     * @param batchNo 批次号
     * @return 不合格品处理列表
     */
    List<GapUnqualifiedHandleDO> getUnqualifiedHandleListByBatchNo(String batchNo);

    /**
     * 校验不合格品处理存在
     *
     * @param id 编号
     * @return 不合格品处理
     */
    GapUnqualifiedHandleDO validateUnqualifiedHandleExists(Long id);

}
