package cn.iocoder.yudao.module.gap.dal.mysql.input;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapInputSupplierPageReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapInputSupplierDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * GAP 投入品供应商 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface GapInputSupplierMapper extends BaseMapperX<GapInputSupplierDO> {

    default PageResult<GapInputSupplierDO> selectPage(GapInputSupplierPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<GapInputSupplierDO>()
                .likeIfPresent(GapInputSupplierDO::getCode, reqVO.getCode())
                .likeIfPresent(GapInputSupplierDO::getName, reqVO.getName())
                .likeIfPresent(GapInputSupplierDO::getContactPerson, reqVO.getContactPerson())
                .eqIfPresent(GapInputSupplierDO::getAuditResult, reqVO.getAuditResult())
                .eqIfPresent(GapInputSupplierDO::getStatus, reqVO.getStatus())
                .orderByDesc(GapInputSupplierDO::getId));
    }

    default GapInputSupplierDO selectByCode(String code) {
        return selectOne(GapInputSupplierDO::getCode, code);
    }

    default GapInputSupplierDO selectByName(String name) {
        return selectOne(GapInputSupplierDO::getName, name);
    }

}
