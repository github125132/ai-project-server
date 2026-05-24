package cn.iocoder.yudao.module.gap.service.process;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessRecordDO;
import jakarta.validation.Valid;

import java.util.List;

/**
 * GAP 加工记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapProcessRecordService {

    /**
     * 创建加工记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createProcessRecord(@Valid GapProcessRecordSaveReqVO createReqVO);

    /**
     * 更新加工记录
     *
     * @param updateReqVO 更新信息
     */
    void updateProcessRecord(@Valid GapProcessRecordSaveReqVO updateReqVO);

    /**
     * 删除加工记录
     *
     * @param id 编号
     */
    void deleteProcessRecord(Long id);

    /**
     * 获得加工记录
     *
     * @param id 编号
     * @return 加工记录
     */
    GapProcessRecordDO getProcessRecord(Long id);

    /**
     * 获得加工记录分页
     *
     * @param pageReqVO 分页查询
     * @return 加工记录分页
     */
    PageResult<GapProcessRecordDO> getProcessRecordPage(GapProcessRecordPageReqVO pageReqVO);

    /**
     * 获得加工记录列表
     *
     * @return 加工记录列表
     */
    List<GapProcessRecordDO> getProcessRecordList();

    /**
     * 根据品种编号获得加工记录列表
     *
     * @param varietyId 品种编号
     * @return 加工记录列表
     */
    List<GapProcessRecordDO> getProcessRecordListByVarietyId(Long varietyId);

    /**
     * 校验加工记录存在
     *
     * @param id 编号
     * @return 加工记录
     */
    GapProcessRecordDO validateProcessRecordExists(Long id);

}
