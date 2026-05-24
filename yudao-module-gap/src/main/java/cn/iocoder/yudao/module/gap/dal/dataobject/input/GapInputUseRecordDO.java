package cn.iocoder.yudao.module.gap.dal.dataobject.input;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * GAP 投入品使用记录 DO
 *
 * @author 芋道源码
 */
@TableName("gap_input_use_record")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapInputUseRecordDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 使用单号
     */
    private String recordNo;
    /**
     * 产品编号
     */
    private Long productId;
    /**
     * 库存编号
     */
    private Long inventoryId;
    /**
     * 产品批次号
     */
    private String batchNo;
    /**
     * 使用类型(0农药 1肥料 2其他)
     */
    private Integer useType;
    /**
     * 使用日期
     */
    private LocalDate useDate;
    /**
     * 基地编号
     */
    private Long baseId;
    /**
     * 地块编号
     */
    private Long plotId;
    /**
     * 地块种植批次
     */
    private String plotBatchNo;
    /**
     * 品种编号
     */
    private Long varietyId;
    /**
     * 使用量
     */
    private BigDecimal quantity;
    /**
     * 单位
     */
    private String unit;
    /**
     * 稀释倍数
     */
    private String dilutionRatio;
    /**
     * 施用面积(亩)
     */
    private BigDecimal applicationArea;
    /**
     * 施用方法
     */
    private String applicationMethod;
    /**
     * 天气条件
     */
    private String weatherCondition;
    /**
     * 风向
     */
    private String windDirection;
    /**
     * 风速
     */
    private String windSpeed;
    /**
     * 气温
     */
    private BigDecimal temperature;
    /**
     * 操作人员
     */
    private Long operatorId;
    /**
     * 安全间隔期(天)
     */
    private Integer safetyInterval;
    /**
     * 最早采收日期
     */
    private LocalDate earliestHarvestDate;
    /**
     * 禁用拦截校验
     */
    private Boolean bannedCheck;
    /**
     * 使用现场照片
     */
    private String photoUrl;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
