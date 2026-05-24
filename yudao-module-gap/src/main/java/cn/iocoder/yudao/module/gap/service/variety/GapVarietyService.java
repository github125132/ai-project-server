package cn.iocoder.yudao.module.gap.service.variety;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietyPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.variety.vo.GapVarietySaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.variety.GapVarietyDO;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;

public interface GapVarietyService {

    Long createVariety(@Valid GapVarietySaveReqVO createReqVO);

    void updateVariety(@Valid GapVarietySaveReqVO updateReqVO);

    void deleteVariety(Long id);

    GapVarietyDO getVariety(Long id);

    PageResult<GapVarietyDO> getVarietyPage(GapVarietyPageReqVO pageReqVO);

    List<GapVarietyDO> getVarietyList();

    List<GapVarietyDO> getVarietyList(Collection<Long> ids);

    GapVarietyDO validateVarietyExists(Long id);

}
