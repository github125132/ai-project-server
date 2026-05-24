package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapPackageRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapPackageRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 包装记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapPackageRecordService {

    /**
     * 创建包装记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPackageRecord(@Valid GapPackageRecordSaveReqVO createReqVO);

    /**
     * 更新包装记录
     *
     * @param updateReqVO 更新信息
     */
    void updatePackageRecord(@Valid GapPackageRecordSaveReqVO updateReqVO);

    /**
     * 删除包装记录
     *
     * @param id 编号
     */
    void deletePackageRecord(Long id);

    /**
     * 获得包装记录
     *
     * @param id 编号
     * @return 包装记录
     */
    GapPackageRecordDO getPackageRecord(Long id);

    /**
     * 获得包装记录分页
     *
     * @param pageReqVO 分页查询
     * @return 包装记录分页
     */
    PageResult<GapPackageRecordDO> getPackageRecordPage(GapPackageRecordPageReqVO pageReqVO);

    /**
     * 获得包装记录列表
     *
     * @return 包装记录列表
     */
    List<GapPackageRecordDO> getPackageRecordList();

    /**
     * 根据加工记录编号获得包装记录列表
     *
     * @param processRecordId 加工记录编号
     * @return 包装记录列表
     */
    List<GapPackageRecordDO> getPackageRecordListByProcessRecordId(Long processRecordId);

    /**
     * 校验包装记录存在
     *
     * @param id 编号
     * @return 包装记录
     */
    GapPackageRecordDO validatePackageRecordExists(Long id);

}
