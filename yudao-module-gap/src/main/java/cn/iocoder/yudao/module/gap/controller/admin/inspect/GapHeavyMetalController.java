package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapHeavyMetalSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapHeavyMetalDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapHeavyMetalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP HeavyMetal")
@RestController
@RequestMapping("/gap/heavy-metal")
@Validated
public class GapHeavyMetalController {

    @Resource
    private GapHeavyMetalService HeavyMetalService;

    @PostMapping("/create")
    @Operation(summary = "创建HeavyMetal")
    @PreAuthorize("@ss.hasPermission('gap:heavy-metal:create')")
    public CommonResult<Long> createGapHeavyMetal(@Valid @RequestBody GapHeavyMetalSaveReqVO createReqVO) {
        return success(HeavyMetalService.createGapHeavyMetal(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新HeavyMetal")
    @PreAuthorize("@ss.hasPermission('gap:heavy-metal:update')")
    public CommonResult<Boolean> updateGapHeavyMetal(@Valid @RequestBody GapHeavyMetalSaveReqVO updateReqVO) {
        HeavyMetalService.updateGapHeavyMetal(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除HeavyMetal")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:heavy-metal:delete')")
    public CommonResult<Boolean> deleteGapHeavyMetal(@RequestParam("id") Long id) {
        HeavyMetalService.deleteGapHeavyMetal(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得HeavyMetal")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:heavy-metal:query')")
    public CommonResult<GapHeavyMetalRespVO> getGapHeavyMetal(@RequestParam("id") Long id) {
        GapHeavyMetalDO entity = HeavyMetalService.getGapHeavyMetal(id);
        return success(BeanUtils.toBean(entity, GapHeavyMetalRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得HeavyMetal分页")
    @PreAuthorize("@ss.hasPermission('gap:heavy-metal:query')")
    public CommonResult<PageResult<GapHeavyMetalRespVO>> getGapHeavyMetalPage(@Valid GapHeavyMetalPageReqVO pageReqVO) {
        PageResult<GapHeavyMetalDO> pageResult = HeavyMetalService.getGapHeavyMetalPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapHeavyMetalRespVO.class));
    }
}
