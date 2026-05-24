package cn.iocoder.yudao.module.gap.controller.admin.trace;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodeRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceNodeSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceNodeDO;
import cn.iocoder.yudao.module.gap.service.trace.GapTraceNodeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP TraceNode")
@RestController
@RequestMapping("/gap/trace-node")
@Validated
public class GapTraceNodeController {

    @Resource
    private GapTraceNodeService TraceNodeService;

    @PostMapping("/create")
    @Operation(summary = "创建TraceNode")
    @PreAuthorize("@ss.hasPermission('gap:trace-node:create')")
    public CommonResult<Long> createGapTraceNode(@Valid @RequestBody GapTraceNodeSaveReqVO createReqVO) {
        return success(TraceNodeService.createGapTraceNode(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新TraceNode")
    @PreAuthorize("@ss.hasPermission('gap:trace-node:update')")
    public CommonResult<Boolean> updateGapTraceNode(@Valid @RequestBody GapTraceNodeSaveReqVO updateReqVO) {
        TraceNodeService.updateGapTraceNode(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除TraceNode")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:trace-node:delete')")
    public CommonResult<Boolean> deleteGapTraceNode(@RequestParam("id") Long id) {
        TraceNodeService.deleteGapTraceNode(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得TraceNode")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:trace-node:query')")
    public CommonResult<GapTraceNodeRespVO> getGapTraceNode(@RequestParam("id") Long id) {
        GapTraceNodeDO entity = TraceNodeService.getGapTraceNode(id);
        return success(BeanUtils.toBean(entity, GapTraceNodeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得TraceNode分页")
    @PreAuthorize("@ss.hasPermission('gap:trace-node:query')")
    public CommonResult<PageResult<GapTraceNodeRespVO>> getGapTraceNodePage(@Valid GapTraceNodePageReqVO pageReqVO) {
        PageResult<GapTraceNodeDO> pageResult = TraceNodeService.getGapTraceNodePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTraceNodeRespVO.class));
    }
}
