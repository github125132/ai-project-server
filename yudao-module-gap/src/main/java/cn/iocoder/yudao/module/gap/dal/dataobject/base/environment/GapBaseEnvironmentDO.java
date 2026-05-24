package cn.iocoder.yudao.module.gap.dal.dataobject.base.environment;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDate;

@TableName("gap_base_environment")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapBaseEnvironmentDO extends BaseDO {

    private Long id;
    private Long baseId;
    private LocalDate assessDate;
    private String assessOrg;
    private String assessPerson;
    private String surroundings;
    private String pollutionSource;
    private String airQuality;
    private String noiseLevel;
    private Integer assessResult;
    private String reportUrl;
    private Integer status;
    private String remark;

}
