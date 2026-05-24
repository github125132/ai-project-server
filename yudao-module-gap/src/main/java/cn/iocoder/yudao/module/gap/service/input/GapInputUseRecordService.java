package cn.iocoder.yudao.module.gap.service.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputUseRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputUseRecordDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

/**
 * GAP 投入品使用记录 Service 接口
 *
 * @author 芋道源码
 */
public interface GapInputUseRecordService {

    /**
     * 创建投入品使用记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createInputUseRecord(@Valid GapInputUseRecordSaveReqVO createReqVO);

    /**
     * 更新投入品使用记录
     *
     * @param updateReqVO 更新信息
     */
    void updateInputUseRecord(@Valid GapInputUseRecordSaveReqVO updateReqVO);

    /**
     * 删除投入品使用记录
     *
     * @param id 编号
     */
    void deleteInputUseRecord(Long id);

    /**
     * 获得投入品使用记录
     *
     * @param id 编号
     * @return 投入品使用记录
     */
    GapInputUseRecordDO getInputUseRecord(Long id);

    /**
     * 获得投入品使用记录分页
     *
     * @param pageReqVO 分页查询
     * @return 投入品使用记录分页
     */
    PageResult<GapInputUseRecordDO> getInputUseRecordPage(GapInputUseRecordPageReqVO pageReqVO);

    /**
     * 获得投入品使用记录列表
     *
     * @return 投入品使用记录列表
     */
    List<GapInputUseRecordDO> getInputUseRecordList();

    /**
     * 获得投入品使用记录列表
     *
     * @param ids 使用记录编号集合
     * @return 投入品使用记录列表
     */
    List<GapInputUseRecordDO> getInputUseRecordList(Collection<Long> ids);

    /**
     * 根据基地编号获得使用记录列表
     *
     * @param baseId 基地编号
     * @return 使用记录列表
     */
    List<GapInputUseRecordDO> getInputUseRecordListByBaseId(Long baseId);

    /**
     * 根据地块编号获得使用记录列表
     *
     * @param plotId 地块编号
     * @return 使用记录列表
     */
    List<GapInputUseRecordDO> getInputUseRecordListByPlotId(Long plotId);

    /**
     * 校验投入品使用记录存在
     *
     * @param id 编号
     * @return 投入品使用记录
     */
    GapInputUseRecordDO validateInputUseRecordExists(Long id);

}
