package cn.iocoder.yudao.module.gap.controller.admin.log;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapOperationLogSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapOperationLogDO;
import cn.iocoder.yudao.module.gap.service.log.GapOperationLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP OperationLog")
@RestController
@RequestMapping("/gap/operation-log")
@Validated
public class GapOperationLogController {

    @Resource
    private GapOperationLogService OperationLogService;

    @PostMapping("/create")
    @Operation(summary = "创建OperationLog")
    @PreAuthorize("@ss.hasPermission('gap:operation-log:create')")
    public CommonResult<Long> createGapOperationLog(@Valid @RequestBody GapOperationLogSaveReqVO createReqVO) {
        return success(OperationLogService.createGapOperationLog(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新OperationLog")
    @PreAuthorize("@ss.hasPermission('gap:operation-log:update')")
    public CommonResult<Boolean> updateGapOperationLog(@Valid @RequestBody GapOperationLogSaveReqVO updateReqVO) {
        OperationLogService.updateGapOperationLog(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除OperationLog")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:operation-log:delete')")
    public CommonResult<Boolean> deleteGapOperationLog(@RequestParam("id") Long id) {
        OperationLogService.deleteGapOperationLog(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得OperationLog")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:operation-log:query')")
    public CommonResult<GapOperationLogRespVO> getGapOperationLog(@RequestParam("id") Long id) {
        GapOperationLogDO entity = OperationLogService.getGapOperationLog(id);
        return success(BeanUtils.toBean(entity, GapOperationLogRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得OperationLog分页")
    @PreAuthorize("@ss.hasPermission('gap:operation-log:query')")
    public CommonResult<PageResult<GapOperationLogRespVO>> getGapOperationLogPage(@Valid GapOperationLogPageReqVO pageReqVO) {
        PageResult<GapOperationLogDO> pageResult = OperationLogService.getGapOperationLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapOperationLogRespVO.class));
    }
}
