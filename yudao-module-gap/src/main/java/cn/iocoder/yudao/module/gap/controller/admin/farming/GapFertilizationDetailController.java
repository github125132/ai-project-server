package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationDetailDO;
import cn.iocoder.yudao.module.gap.service.farming.GapFertilizationDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP FertilizationDetail")
@RestController
@RequestMapping("/gap/fertilization-detail")
@Validated
public class GapFertilizationDetailController {

    @Resource
    private GapFertilizationDetailService FertilizationDetailService;

    @PostMapping("/create")
    @Operation(summary = "创建FertilizationDetail")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-detail:create')")
    public CommonResult<Long> createGapFertilizationDetail(@Valid @RequestBody GapFertilizationDetailSaveReqVO createReqVO) {
        return success(FertilizationDetailService.createGapFertilizationDetail(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新FertilizationDetail")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-detail:update')")
    public CommonResult<Boolean> updateGapFertilizationDetail(@Valid @RequestBody GapFertilizationDetailSaveReqVO updateReqVO) {
        FertilizationDetailService.updateGapFertilizationDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除FertilizationDetail")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:fertilization-detail:delete')")
    public CommonResult<Boolean> deleteGapFertilizationDetail(@RequestParam("id") Long id) {
        FertilizationDetailService.deleteGapFertilizationDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得FertilizationDetail")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-detail:query')")
    public CommonResult<GapFertilizationDetailRespVO> getGapFertilizationDetail(@RequestParam("id") Long id) {
        GapFertilizationDetailDO entity = FertilizationDetailService.getGapFertilizationDetail(id);
        return success(BeanUtils.toBean(entity, GapFertilizationDetailRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得FertilizationDetail分页")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-detail:query')")
    public CommonResult<PageResult<GapFertilizationDetailRespVO>> getGapFertilizationDetailPage(@Valid GapFertilizationDetailPageReqVO pageReqVO) {
        PageResult<GapFertilizationDetailDO> pageResult = FertilizationDetailService.getGapFertilizationDetailPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapFertilizationDetailRespVO.class));
    }
}
