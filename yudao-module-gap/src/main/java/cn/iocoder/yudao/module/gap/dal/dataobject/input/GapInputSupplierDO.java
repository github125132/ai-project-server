package cn.iocoder.yudao.module.gap.dal.dataobject.input;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

/**
 * GAP 投入品供应商 DO
 *
 * @author 芋道源码
 */
@TableName("gap_input_supplier")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInputSupplierDO extends BaseDO {

    /**
     * 供应商编号
     */
    private Long id;
    /**
     * 供应商编码
     */
    private String code;
    /**
     * 供应商名称
     */
    private String name;
    /**
     * 联系人
     */
    private String contactPerson;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 地址
     */
    private String address;
    /**
     * 营业执照号
     */
    private String businessLicense;
    /**
     * 营业执照附件
     */
    private String licenseUrl;
    /**
     * 生产许可证号
     */
    private String productionLicense;
    /**
     * 质量协议附件
     */
    private String qualityAgreementUrl;
    /**
     * 审计日期
     */
    private LocalDate auditDate;
    /**
     * 审计结果(0合格 1不合格)
     */
    private Integer auditResult;
    /**
     * 审计报告附件
     */
    private String auditReportUrl;
    /**
     * 状态(0合格供应商 1观察 2不合格)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
