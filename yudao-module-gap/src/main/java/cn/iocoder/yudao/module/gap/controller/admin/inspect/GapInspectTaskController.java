package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapInspectTaskSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapInspectTaskDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapInspectTaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP InspectTask")
@RestController
@RequestMapping("/gap/inspect-task")
@Validated
public class GapInspectTaskController {

    @Resource
    private GapInspectTaskService InspectTaskService;

    @PostMapping("/create")
    @Operation(summary = "创建InspectTask")
    @PreAuthorize("@ss.hasPermission('gap:inspect-task:create')")
    public CommonResult<Long> createGapInspectTask(@Valid @RequestBody GapInspectTaskSaveReqVO createReqVO) {
        return success(InspectTaskService.createGapInspectTask(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新InspectTask")
    @PreAuthorize("@ss.hasPermission('gap:inspect-task:update')")
    public CommonResult<Boolean> updateGapInspectTask(@Valid @RequestBody GapInspectTaskSaveReqVO updateReqVO) {
        InspectTaskService.updateGapInspectTask(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除InspectTask")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:inspect-task:delete')")
    public CommonResult<Boolean> deleteGapInspectTask(@RequestParam("id") Long id) {
        InspectTaskService.deleteGapInspectTask(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得InspectTask")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:inspect-task:query')")
    public CommonResult<GapInspectTaskRespVO> getGapInspectTask(@RequestParam("id") Long id) {
        GapInspectTaskDO entity = InspectTaskService.getGapInspectTask(id);
        return success(BeanUtils.toBean(entity, GapInspectTaskRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得InspectTask分页")
    @PreAuthorize("@ss.hasPermission('gap:inspect-task:query')")
    public CommonResult<PageResult<GapInspectTaskRespVO>> getGapInspectTaskPage(@Valid GapInspectTaskPageReqVO pageReqVO) {
        PageResult<GapInspectTaskDO> pageResult = InspectTaskService.getGapInspectTaskPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapInspectTaskRespVO.class));
    }
}
