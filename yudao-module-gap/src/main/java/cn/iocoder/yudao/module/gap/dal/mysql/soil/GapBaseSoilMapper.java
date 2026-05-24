package cn.iocoder.yudao.module.gap.dal.mysql.soil;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.soil.vo.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.soil.GapBaseSoilDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapBaseSoilMapper extends BaseMapperX<GapBaseSoilDO> {

    default PageResult<GapBaseSoilDO> selectPage(GapBaseSoilPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseSoilDO>()
                .eqIfPresent(GapBaseSoilDO::getId, reqVO.getId())
                .eqIfPresent(GapBaseSoilDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseSoilDO::getPlotId, reqVO.getPlotId())
                .likeIfPresent(GapBaseSoilDO::getSampleNo, reqVO.getSampleNo())
                .eqIfPresent(GapBaseSoilDO::getSampleDate, reqVO.getSampleDate())
                .likeIfPresent(GapBaseSoilDO::getSampleLocation, reqVO.getSampleLocation())
                .likeIfPresent(GapBaseSoilDO::getSoilType, reqVO.getSoilType())
                .eqIfPresent(GapBaseSoilDO::getPhValue, reqVO.getPhValue())
                .eqIfPresent(GapBaseSoilDO::getOrganicMatter, reqVO.getOrganicMatter())
                .eqIfPresent(GapBaseSoilDO::getNitrogen, reqVO.getNitrogen())
                .eqIfPresent(GapBaseSoilDO::getPhosphorus, reqVO.getPhosphorus())
                .eqIfPresent(GapBaseSoilDO::getPotassium, reqVO.getPotassium())
                .eqIfPresent(GapBaseSoilDO::getCadmium, reqVO.getCadmium())
                .eqIfPresent(GapBaseSoilDO::getLead, reqVO.getLead())
                .eqIfPresent(GapBaseSoilDO::getArsenic, reqVO.getArsenic())
                .eqIfPresent(GapBaseSoilDO::getMercury, reqVO.getMercury())
                .eqIfPresent(GapBaseSoilDO::getChromium, reqVO.getChromium())
                .likeIfPresent(GapBaseSoilDO::getReportUrl, reqVO.getReportUrl())
                .eqIfPresent(GapBaseSoilDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapBaseSoilDO::getId));
    }
    default List<GapBaseSoilDO> selectListByBaseId(Long baseId) {
        return selectList(GapBaseSoilDO::getBaseId, baseId);
    }

    default List<GapBaseSoilDO> selectListByPlotId(Long plotId) {
        return selectList(GapBaseSoilDO::getPlotId, plotId);
    }
}
