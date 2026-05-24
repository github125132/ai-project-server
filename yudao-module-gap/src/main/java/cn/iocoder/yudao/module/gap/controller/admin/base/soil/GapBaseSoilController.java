package cn.iocoder.yudao.module.gap.controller.admin.base.soil;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.base.vo.soil.GapBaseSoilSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.base.soil.GapBaseSoilDO;
import cn.iocoder.yudao.module.gap.service.base.soil.GapBaseSoilService;
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

@Tag(name = "管理后台 - GAP 土壤检测")
@RestController
@RequestMapping("/gap/base-soil")
@Validated
public class GapBaseSoilController {

    @Resource
    private GapBaseSoilService soilService;

    @PostMapping("/create")
    @Operation(summary = "创建土壤检测")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:create')")
    public CommonResult<Long> createSoil(@Valid @RequestBody GapBaseSoilSaveReqVO createReqVO) {
        return success(soilService.createSoil(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新土壤检测")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:update')")
    public CommonResult<Boolean> updateSoil(@Valid @RequestBody GapBaseSoilSaveReqVO updateReqVO) {
        soilService.updateSoil(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除土壤检测")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:base-soil:delete')")
    public CommonResult<Boolean> deleteSoil(@RequestParam("id") Long id) {
        soilService.deleteSoil(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得土壤检测")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:query')")
    public CommonResult<GapBaseSoilRespVO> getSoil(@RequestParam("id") Long id) {
        GapBaseSoilDO soil = soilService.getSoil(id);
        return success(BeanUtils.toBean(soil, GapBaseSoilRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得土壤检测分页")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:query')")
    public CommonResult<PageResult<GapBaseSoilRespVO>> getSoilPage(@Valid GapBaseSoilPageReqVO pageReqVO) {
        PageResult<GapBaseSoilDO> pageResult = soilService.getSoilPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapBaseSoilRespVO.class));
    }

    @GetMapping("/list-by-base")
    @Operation(summary = "根据基地获得土壤检测列表")
    @Parameter(name = "baseId", description = "基地编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:query')")
    public CommonResult<List<GapBaseSoilRespVO>> getSoilListByBaseId(@RequestParam("baseId") Long baseId) {
        List<GapBaseSoilDO> list = soilService.getSoilListByBaseId(baseId);
        return success(BeanUtils.toBean(list, GapBaseSoilRespVO.class));
    }

    @GetMapping("/list-by-plot")
    @Operation(summary = "根据地块获得土壤检测列表")
    @Parameter(name = "plotId", description = "地块编号", required = true, example = "1")
    @PreAuthorize("@ss.hasPermission('gap:base-soil:query')")
    public CommonResult<List<GapBaseSoilRespVO>> getSoilListByPlotId(@RequestParam("plotId") Long plotId) {
        List<GapBaseSoilDO> list = soilService.getSoilListByPlotId(plotId);
        return success(BeanUtils.toBean(list, GapBaseSoilRespVO.class));
    }

}
