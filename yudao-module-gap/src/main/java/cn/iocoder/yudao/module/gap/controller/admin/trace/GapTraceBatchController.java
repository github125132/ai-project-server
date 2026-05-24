package cn.iocoder.yudao.module.gap.controller.admin.trace;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.trace.vo.GapTraceBatchSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.trace.GapTraceBatchDO;
import cn.iocoder.yudao.module.gap.service.trace.GapTraceBatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP TraceBatch")
@RestController
@RequestMapping("/gap/trace-batch")
@Validated
public class GapTraceBatchController {

    @Resource
    private GapTraceBatchService TraceBatchService;

    @PostMapping("/create")
    @Operation(summary = "创建TraceBatch")
    @PreAuthorize("@ss.hasPermission('gap:trace-batch:create')")
    public CommonResult<Long> createGapTraceBatch(@Valid @RequestBody GapTraceBatchSaveReqVO createReqVO) {
        return success(TraceBatchService.createGapTraceBatch(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新TraceBatch")
    @PreAuthorize("@ss.hasPermission('gap:trace-batch:update')")
    public CommonResult<Boolean> updateGapTraceBatch(@Valid @RequestBody GapTraceBatchSaveReqVO updateReqVO) {
        TraceBatchService.updateGapTraceBatch(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除TraceBatch")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:trace-batch:delete')")
    public CommonResult<Boolean> deleteGapTraceBatch(@RequestParam("id") Long id) {
        TraceBatchService.deleteGapTraceBatch(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得TraceBatch")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:trace-batch:query')")
    public CommonResult<GapTraceBatchRespVO> getGapTraceBatch(@RequestParam("id") Long id) {
        GapTraceBatchDO entity = TraceBatchService.getGapTraceBatch(id);
        return success(BeanUtils.toBean(entity, GapTraceBatchRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得TraceBatch分页")
    @PreAuthorize("@ss.hasPermission('gap:trace-batch:query')")
    public CommonResult<PageResult<GapTraceBatchRespVO>> getGapTraceBatchPage(@Valid GapTraceBatchPageReqVO pageReqVO) {
        PageResult<GapTraceBatchDO> pageResult = TraceBatchService.getGapTraceBatchPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapTraceBatchRespVO.class));
    }
}
