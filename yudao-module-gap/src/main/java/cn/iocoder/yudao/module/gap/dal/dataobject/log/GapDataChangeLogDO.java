package cn.iocoder.yudao.module.gap.dal.dataobject.log;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * GAP 数据变更日志(审计追踪) DO
 *
 * @author 芋道源码
 */
@TableName("gap_data_change_log")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapDataChangeLogDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 记录编号
     */
    private Long recordId;
    /**
     * 变更类型(0新增 1修改 2删除)
     */
    private Integer changeType;
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段中文名
     */
    private String fieldLabel;
    /**
     * 旧值
     */
    private String oldValue;
    /**
     * 新值
     */
    private String newValue;
    /**
     * 变更原因(GAP要求)
     */
    private String changeReason;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 操作人姓名
     */
    private String operatorName;
    /**
     * 操作时间
     */
    private LocalDateTime operateTime;
    /**
     * 操作IP
     */
    private String operateIp;
    /**
     * 版本号
     */
    private Integer version;
    /**
     * 备注
     */
    private String remark;

}
