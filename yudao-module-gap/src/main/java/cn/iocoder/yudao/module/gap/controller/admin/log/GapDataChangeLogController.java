package cn.iocoder.yudao.module.gap.controller.admin.log;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.log.vo.GapDataChangeLogSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.log.GapDataChangeLogDO;
import cn.iocoder.yudao.module.gap.service.log.GapDataChangeLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP DataChangeLog")
@RestController
@RequestMapping("/gap/data-change-log")
@Validated
public class GapDataChangeLogController {

    @Resource
    private GapDataChangeLogService DataChangeLogService;

    @PostMapping("/create")
    @Operation(summary = "创建DataChangeLog")
    @PreAuthorize("@ss.hasPermission('gap:data-change-log:create')")
    public CommonResult<Long> createGapDataChangeLog(@Valid @RequestBody GapDataChangeLogSaveReqVO createReqVO) {
        return success(DataChangeLogService.createGapDataChangeLog(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新DataChangeLog")
    @PreAuthorize("@ss.hasPermission('gap:data-change-log:update')")
    public CommonResult<Boolean> updateGapDataChangeLog(@Valid @RequestBody GapDataChangeLogSaveReqVO updateReqVO) {
        DataChangeLogService.updateGapDataChangeLog(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除DataChangeLog")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:data-change-log:delete')")
    public CommonResult<Boolean> deleteGapDataChangeLog(@RequestParam("id") Long id) {
        DataChangeLogService.deleteGapDataChangeLog(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得DataChangeLog")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:data-change-log:query')")
    public CommonResult<GapDataChangeLogRespVO> getGapDataChangeLog(@RequestParam("id") Long id) {
        GapDataChangeLogDO entity = DataChangeLogService.getGapDataChangeLog(id);
        return success(BeanUtils.toBean(entity, GapDataChangeLogRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得DataChangeLog分页")
    @PreAuthorize("@ss.hasPermission('gap:data-change-log:query')")
    public CommonResult<PageResult<GapDataChangeLogRespVO>> getGapDataChangeLogPage(@Valid GapDataChangeLogPageReqVO pageReqVO) {
        PageResult<GapDataChangeLogDO> pageResult = DataChangeLogService.getGapDataChangeLogPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapDataChangeLogRespVO.class));
    }
}
