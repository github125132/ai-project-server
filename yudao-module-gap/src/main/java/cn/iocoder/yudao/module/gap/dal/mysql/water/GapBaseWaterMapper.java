package cn.iocoder.yudao.module.gap.dal.mysql.water;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.water.vo.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.water.GapBaseWaterDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GapBaseWaterMapper extends BaseMapperX<GapBaseWaterDO> {

    default PageResult<GapBaseWaterDO> selectPage(GapBaseWaterPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapBaseWaterDO>()
                .eqIfPresent(GapBaseWaterDO::getId, reqVO.getId())
                .eqIfPresent(GapBaseWaterDO::getBaseId, reqVO.getBaseId())
                .eqIfPresent(GapBaseWaterDO::getWaterType, reqVO.getWaterType())
                .likeIfPresent(GapBaseWaterDO::getSampleNo, reqVO.getSampleNo())
                .eqIfPresent(GapBaseWaterDO::getSampleDate, reqVO.getSampleDate())
                .likeIfPresent(GapBaseWaterDO::getSampleLocation, reqVO.getSampleLocation())
                .eqIfPresent(GapBaseWaterDO::getPhValue, reqVO.getPhValue())
                .eqIfPresent(GapBaseWaterDO::getCod, reqVO.getCod())
                .eqIfPresent(GapBaseWaterDO::getBod5, reqVO.getBod5())
                .eqIfPresent(GapBaseWaterDO::getAmmoniaNitrogen, reqVO.getAmmoniaNitrogen())
                .eqIfPresent(GapBaseWaterDO::getTotalNitrogen, reqVO.getTotalNitrogen())
                .eqIfPresent(GapBaseWaterDO::getTotalPhosphorus, reqVO.getTotalPhosphorus())
                .eqIfPresent(GapBaseWaterDO::getCadmium, reqVO.getCadmium())
                .eqIfPresent(GapBaseWaterDO::getLead, reqVO.getLead())
                .eqIfPresent(GapBaseWaterDO::getArsenic, reqVO.getArsenic())
                .eqIfPresent(GapBaseWaterDO::getMercury, reqVO.getMercury())
                .eqIfPresent(GapBaseWaterDO::getChromium, reqVO.getChromium())
                .likeIfPresent(GapBaseWaterDO::getReportUrl, reqVO.getReportUrl())
                .eqIfPresent(GapBaseWaterDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapBaseWaterDO::getId));
    }
    default List<GapBaseWaterDO> selectListByBaseId(Long baseId) {
        return selectList(GapBaseWaterDO::getBaseId, baseId);
    }
}
