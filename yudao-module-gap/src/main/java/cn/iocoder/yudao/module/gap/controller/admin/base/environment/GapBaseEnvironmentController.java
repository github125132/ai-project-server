package cn.iocoder.yudao.module.gap.controller.admin.base.environment;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.environment.GapBaseEnvironmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.environment.GapBaseEnvironmentDO;
import cn.iocoder.yudao.module.gap.service.base.environment.GapBaseEnvironmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP 基地环境评估")
@RestController
@RequestMapping("/gap/base-environment")
@Validated
public class GapBaseEnvironmentController {

    @Resource
    private GapBaseEnvironmentService environmentService;

    @PostMapping("/create")
    @Operation(summary = "创建环境评估")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:create')")
    public CommonResult<Long> createEnvironment(@Valid @RequestBody GapBaseEnvironmentSaveReqVO createReqVO) {
        return success(environmentService.createEnvironment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新环境评估")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:update')")
    public CommonResult<Boolean> updateEnvironment(@Valid @RequestBody GapBaseEnvironmentSaveReqVO updateReqVO) {
        environmentService.updateEnvironment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除环境评估")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-environment:delete')")
    public CommonResult<Boolean> deleteEnvironment(@RequestParam("id") Long id) {
        environmentService.deleteEnvironment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得环境评估")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:query')")
    public CommonResult<GapBaseEnvironmentRespVO> getEnvironment(@RequestParam("id") Long id) {
        GapBaseEnvironmentDO env = environmentService.getEnvironment(id);
        return success(BeanUtils.toBean(env, GapBaseEnvironmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得环境评估分页")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:query')")
    public CommonResult<PageResult<GapBaseEnvironmentRespVO>> getEnvironmentPage(@Valid GapBaseEnvironmentPageReqVO pageReqVO) {
        PageResult<GapBaseEnvironmentDO> pageResult = environmentService.getEnvironmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseEnvironmentRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得环境评估列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:query')")
    public CommonResult<List<GapBaseEnvironmentRespVO>> getEnvironmentListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapBaseEnvironmentDO> list = environmentService.getEnvironmentListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapBaseEnvironmentRespVO.class));
    }

}
