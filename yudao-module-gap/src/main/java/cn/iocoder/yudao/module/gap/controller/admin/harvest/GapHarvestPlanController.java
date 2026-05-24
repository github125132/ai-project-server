package cn.iocoder.yudao.module.gap.controller.admin.harvest;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestPlanSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestPlanDO;
import cn.iocoder.yudao.module.gap.service.harvest.GapHarvestPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP HarvestPlan")
@RestController
@RequestMapping("/gap/harvest-plan")
@Validated
public class GapHarvestPlanController {

    @Resource
    private GapHarvestPlanService HarvestPlanService;

    @PostMapping("/create")
    @Operation(summary = "创建HarvestPlan")
    @PreAuthorize("@ss.hasPermission('gap:harvest-plan:create')")
    public CommonResult<Long> createGapHarvestPlan(@Valid @RequestBody GapHarvestPlanSaveReqVO createReqVO) {
        return success(HarvestPlanService.createGapHarvestPlan(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新HarvestPlan")
    @PreAuthorize("@ss.hasPermission('gap:harvest-plan:update')")
    public CommonResult<Boolean> updateGapHarvestPlan(@Valid @RequestBody GapHarvestPlanSaveReqVO updateReqVO) {
        HarvestPlanService.updateGapHarvestPlan(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除HarvestPlan")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:harvest-plan:delete')")
    public CommonResult<Boolean> deleteGapHarvestPlan(@RequestParam("id") Long id) {
        HarvestPlanService.deleteGapHarvestPlan(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得HarvestPlan")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:harvest-plan:query')")
    public CommonResult<GapHarvestPlanRespVO> getGapHarvestPlan(@RequestParam("id") Long id) {
        GapHarvestPlanDO entity = HarvestPlanService.getGapHarvestPlan(id);
        return success(BeanUtils.toBean(entity, GapHarvestPlanRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得HarvestPlan分页")
    @PreAuthorize("@ss.hasPermission('gap:harvest-plan:query')")
    public CommonResult<PageResult<GapHarvestPlanRespVO>> getGapHarvestPlanPage(@Valid GapHarvestPlanPageReqVO pageReqVO) {
        PageResult<GapHarvestPlanDO> pageResult = HarvestPlanService.getGapHarvestPlanPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapHarvestPlanRespVO.class));
    }
}
