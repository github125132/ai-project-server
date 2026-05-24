package cn.iocoder.yudao.module.gap.dal.dataobject.log;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * GAP 业务操作日志 DO
 *
 * @author 芋道源码
 */
@TableName("gap_operation_log")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapOperationLogDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 日志类型(0新增 1修改 2删除 3查询 4导入 5导出 6审批)
     */
    private Integer logType;
    /**
     * 业务模块
     */
    private String moduleType;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 记录编号
     */
    private Long recordId;
    /**
     * 记录单号
     */
    private String recordNo;
    /**
     * 操作描述
     */
    private String operationDesc;
    /**
     * 请求数据
     */
    private String requestData;
    /**
     * 响应数据
     */
    private String responseData;
    /**
     * 操作人
     */
    private Long operatorId;
    /**
     * 操作人姓名
     */
    private String operatorName;
    /**
     * 操作IP
     */
    private String operateIp;
    /**
     * 操作时间
     */
    private LocalDateTime operateTime;
    /**
     * 耗时(ms)
     */
    private Integer duration;
    /**
     * 结果(0成功 1失败)
     */
    private Integer result;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 备注
     */
    private String remark;

}
