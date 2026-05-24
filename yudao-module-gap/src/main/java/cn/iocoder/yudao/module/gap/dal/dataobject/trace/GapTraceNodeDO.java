package cn.iocoder.yudao.module.gap.dal.dataobject.trace;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * GAP 溯源节点 DO
 *
 * @author 芋道源码
 */
@TableName("gap_trace_node")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GapTraceNodeDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 溯源批次编号
     */
    private Long traceBatchId;
    /**
     * 追溯码
     */
    private String traceCode;
    /**
     * 节点类型(0种植 1农事 2采收 3加工 4包装 5入库 6检验 7放行 8出库 9运输)
     */
    private Integer nodeType;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 节点时间
     */
    private LocalDateTime nodeTime;
    /**
     * 源记录编号
     */
    private Long sourceRecordId;
    /**
     * 源记录单号
     */
    private String sourceRecordNo;
    /**
     * 操作人
     */
    private String operatorName;
    /**
     * 地点
     */
    private String location;
    /**
     * 节点描述
     */
    private String description;
    /**
     * 照片附件
     */
    private String photoUrl;
    /**
     * 节点详情(JSON)
     */
    private String detailJson;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

}
