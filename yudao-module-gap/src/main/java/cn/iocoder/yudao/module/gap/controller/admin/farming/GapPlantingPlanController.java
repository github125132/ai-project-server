package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPlantingPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPlantingPlanDO;
import cn.iocoder.yudao.module.gap.service.farming.GapPlantingPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP PlantingPlan")
@RestController
@RequestMapping("/gap/planting-plan")
@Validated
public class GapPlantingPlanController {

    @Resource
    private GapPlantingPlanService PlantingPlanService;

    @PostMapping("/create")
    @Operation(summary = "创建PlantingPlan")
    @PreAuthorize("@ss.hasPermission('gap:planting-plan:create')")
    public CommonResult<Long> createGapPlantingPlan(@Valid @RequestBody GapPlantingPlanSaveReqVO createReqVO) {
        return success(PlantingPlanService.createGapPlantingPlan(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新PlantingPlan")
    @PreAuthorize("@ss.hasPermission('gap:planting-plan:update')")
    public CommonResult<Boolean> updateGapPlantingPlan(@Valid @RequestBody GapPlantingPlanSaveReqVO updateReqVO) {
        PlantingPlanService.updateGapPlantingPlan(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除PlantingPlan")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:planting-plan:delete')")
    public CommonResult<Boolean> deleteGapPlantingPlan(@RequestParam("id") Long id) {
        PlantingPlanService.deleteGapPlantingPlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得PlantingPlan")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:planting-plan:query')")
    public CommonResult<GapPlantingPlanRespVO> getGapPlantingPlan(@RequestParam("id") Long id) {
        GapPlantingPlanDO entity = PlantingPlanService.getGapPlantingPlan(id);
        return success(BeanUtils.toBean(entity, GapPlantingPlanRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得PlantingPlan分页")
    @PreAuthorize("@ss.hasPermission('gap:planting-plan:query')")
    public CommonResult<PageResult<GapPlantingPlanRespVO>> getGapPlantingPlanPage(@Valid GapPlantingPlanPageReqVO pageReqVO) {
        PageResult<GapPlantingPlanDO> pageResult = PlantingPlanService.getGapPlantingPlanPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPlantingPlanRespVO.class));
    }
}
