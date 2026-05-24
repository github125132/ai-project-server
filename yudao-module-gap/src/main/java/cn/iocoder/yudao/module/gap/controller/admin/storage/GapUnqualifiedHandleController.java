package cn.iocoder.yudao.module.gap.controller.admin.storage;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandlePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandleRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.storage.vo.GapUnqualifiedHandleSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.storage.GapUnqualifiedHandleDO;
import cn.iocoder.yudao.module.gap.service.storage.GapUnqualifiedHandleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP UnqualifiedHandle")
@RestController
@RequestMapping("/gap/unqualified-handle")
@Validated
public class GapUnqualifiedHandleController {

    @Resource
    private GapUnqualifiedHandleService UnqualifiedHandleService;

    @PostMapping("/create")
    @Operation(summary = "创建UnqualifiedHandle")
    @PreAuthorize("@ss.hasPermission('gap:unqualified-handle:create')")
    public CommonResult<Long> createGapUnqualifiedHandle(@Valid @RequestBody GapUnqualifiedHandleSaveReqVO createReqVO) {
        return success(UnqualifiedHandleService.createGapUnqualifiedHandle(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新UnqualifiedHandle")
    @PreAuthorize("@ss.hasPermission('gap:unqualified-handle:update')")
    public CommonResult<Boolean> updateGapUnqualifiedHandle(@Valid @RequestBody GapUnqualifiedHandleSaveReqVO updateReqVO) {
        UnqualifiedHandleService.updateGapUnqualifiedHandle(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除UnqualifiedHandle")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:unqualified-handle:delete')")
    public CommonResult<Boolean> deleteGapUnqualifiedHandle(@RequestParam("id") Long id) {
        UnqualifiedHandleService.deleteGapUnqualifiedHandle(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得UnqualifiedHandle")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:unqualified-handle:query')")
    public CommonResult<GapUnqualifiedHandleRespVO> getGapUnqualifiedHandle(@RequestParam("id") Long id) {
        GapUnqualifiedHandleDO entity = UnqualifiedHandleService.getGapUnqualifiedHandle(id);
        return success(BeanUtils.toBean(entity, GapUnqualifiedHandleRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得UnqualifiedHandle分页")
    @PreAuthorize("@ss.hasPermission('gap:unqualified-handle:query')")
    public CommonResult<PageResult<GapUnqualifiedHandleRespVO>> getGapUnqualifiedHandlePage(@Valid GapUnqualifiedHandlePageReqVO pageReqVO) {
        PageResult<GapUnqualifiedHandleDO> pageResult = UnqualifiedHandleService.getGapUnqualifiedHandlePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapUnqualifiedHandleRespVO.class));
    }
}
