package cn.iocoder.yudao.module.gap.controller.admin.environment;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.environment.vo.GapBaseEnvironmentSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.environment.GapBaseEnvironmentDO;
import cn.iocoder.yudao.module.gap.service.environment.GapBaseEnvironmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP BaseEnvironment")
@RestController
@RequestMapping("/gap/base-environment")
@Validated
public class GapBaseEnvironmentController {

    @Resource
    private GapBaseEnvironmentService BaseEnvironmentService;

    @PostMapping("/create")
    @Operation(summary = "创建BaseEnvironment")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:create')")
    public CommonResult<Long> createGapBaseEnvironment(@Valid @RequestBody GapBaseEnvironmentSaveReqVO createReqVO) {
        return success(BaseEnvironmentService.createGapBaseEnvironment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新BaseEnvironment")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:update')")
    public CommonResult<Boolean> updateGapBaseEnvironment(@Valid @RequestBody GapBaseEnvironmentSaveReqVO updateReqVO) {
        BaseEnvironmentService.updateGapBaseEnvironment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除BaseEnvironment")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-environment:delete')")
    public CommonResult<Boolean> deleteGapBaseEnvironment(@RequestParam("id") Long id) {
        BaseEnvironmentService.deleteGapBaseEnvironment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得BaseEnvironment")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:query')")
    public CommonResult<GapBaseEnvironmentRespVO> getGapBaseEnvironment(@RequestParam("id") Long id) {
        GapBaseEnvironmentDO entity = BaseEnvironmentService.getGapBaseEnvironment(id);
        return success(BeanUtils.toBean(entity, GapBaseEnvironmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得BaseEnvironment分页")
    @PreAuthorize("@ss.hasPermission('gap:base-environment:query')")
    public CommonResult<PageResult<GapBaseEnvironmentRespVO>> getGapBaseEnvironmentPage(@Valid GapBaseEnvironmentPageReqVO pageReqVO) {
        PageResult<GapBaseEnvironmentDO> pageResult = BaseEnvironmentService.getGapBaseEnvironmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseEnvironmentRespVO.class));
    }
}
