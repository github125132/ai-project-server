package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingDetailDO;
import cn.iocoder.yudao.module.gap.service.farming.GapFarmingDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP FarmingDetail")
@RestController
@RequestMapping("/gap/farming-detail")
@Validated
public class GapFarmingDetailController {

    @Resource
    private GapFarmingDetailService FarmingDetailService;

    @PostMapping("/create")
    @Operation(summary = "创建FarmingDetail")
    @PreAuthorize("@ss.hasPermission('gap:farming-detail:create')")
    public CommonResult<Long> createGapFarmingDetail(@Valid @RequestBody GapFarmingDetailSaveReqVO createReqVO) {
        return success(FarmingDetailService.createGapFarmingDetail(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新FarmingDetail")
    @PreAuthorize("@ss.hasPermission('gap:farming-detail:update')")
    public CommonResult<Boolean> updateGapFarmingDetail(@Valid @RequestBody GapFarmingDetailSaveReqVO updateReqVO) {
        FarmingDetailService.updateGapFarmingDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除FarmingDetail")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:farming-detail:delete')")
    public CommonResult<Boolean> deleteGapFarmingDetail(@RequestParam("id") Long id) {
        FarmingDetailService.deleteGapFarmingDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得FarmingDetail")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:farming-detail:query')")
    public CommonResult<GapFarmingDetailRespVO> getGapFarmingDetail(@RequestParam("id") Long id) {
        GapFarmingDetailDO entity = FarmingDetailService.getGapFarmingDetail(id);
        return success(BeanUtils.toBean(entity, GapFarmingDetailRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得FarmingDetail分页")
    @PreAuthorize("@ss.hasPermission('gap:farming-detail:query')")
    public CommonResult<PageResult<GapFarmingDetailRespVO>> getGapFarmingDetailPage(@Valid GapFarmingDetailPageReqVO pageReqVO) {
        PageResult<GapFarmingDetailDO> pageResult = FarmingDetailService.getGapFarmingDetailPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapFarmingDetailRespVO.class));
    }
}
