package cn.iocoder.yudao.module.gap.dal.dataobject.base.facility;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

@TableName("gap_base_facility")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapBaseFacilityDO extends BaseDO {

    private Long id;
    private Long baseId;
    private Integer facilityType;
    private String name;
    private String code;
    private String specification;
    private Integer quantity;
    private String unit;
    private LocalDate buildDate;
    private Integer status;
    private String locationDesc;
    private String photoUrl;
    private String remark;

}
