package cn.iocoder.yudao.module.gap.controller.admin.base.water;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.water.GapBaseWaterSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.water.GapBaseWaterDO;
import cn.iocoder.yudao.module.gap.service.base.water.GapBaseWaterService;
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

@Tag(name = "管理后台 - GAP 水源检测")
@RestController
@RequestMapping("/gap/base-water")
@Validated
public class GapBaseWaterController {

    @Resource
    private GapBaseWaterService waterService;

    @PostMapping("/create")
    @Operation(summary = "创建水源检测")
    @PreAuthorize("@ss.hasPermission('gap:base-water:create')")
    public CommonResult<Long> createWater(@Valid @RequestBody GapBaseWaterSaveReqVO createReqVO) {
        return success(waterService.createWater(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新水源检测")
    @PreAuthorize("@ss.hasPermission('gap:base-water:update')")
    public CommonResult<Boolean> updateWater(@Valid @RequestBody GapBaseWaterSaveReqVO updateReqVO) {
        waterService.updateWater(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除水源检测")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-water:delete')")
    public CommonResult<Boolean> deleteWater(@RequestParam("id") Long id) {
        waterService.deleteWater(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得水源检测")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-water:query')")
    public CommonResult<GapBaseWaterRespVO> getWater(@RequestParam("id") Long id) {
        GapBaseWaterDO water = waterService.getWater(id);
        return success(BeanUtils.toBean(water, GapBaseWaterRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得水源检测分页")
    @PreAuthorize("@ss.hasPermission('gap:base-water:query')")
    public CommonResult<PageResult<GapBaseWaterRespVO>> getWaterPage(@Valid GapBaseWaterPageReqVO pageReqVO) {
        PageResult<GapBaseWaterDO> pageResult = waterService.getWaterPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseWaterRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得水源检测列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:base-water:query')")
    public CommonResult<List<GapBaseWaterRespVO>> getWaterListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapBaseWaterDO> list = waterService.getWaterListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapBaseWaterRespVO.class));
    }

}
