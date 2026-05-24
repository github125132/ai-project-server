package cn.iocoder.yudao.module.gap.controller.admin.input;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.input.vo.GapWasteDisposalSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.input.GapWasteDisposalDO;
import cn.iocoder.yudao.module.gap.service.input.GapWasteDisposalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP waste_disposal")
@RestController
@RequestMapping("/gap/waste-disposal")
@Validated
public class GapWasteDisposalController {

    @Resource
    private GapWasteDisposalService wasteDisposalService;

    @PostMapping("/create")
    @Operation(summary = "创建waste_disposal")
    @PreAuthorize("@ss.hasPermission('gap:waste-disposal:create')")
    public CommonResult<Long> createGapWasteDisposal(@Valid @RequestBody GapWasteDisposalSaveReqVO createReqVO) {
        return success(wasteDisposalService.createGapWasteDisposal(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新waste_disposal")
    @PreAuthorize("@ss.hasPermission('gap:waste-disposal:update')")
    public CommonResult<Boolean> updateGapWasteDisposal(@Valid @RequestBody GapWasteDisposalSaveReqVO updateReqVO) {
        wasteDisposalService.updateGapWasteDisposal(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除waste_disposal")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:waste-disposal:delete')")
    public CommonResult<Boolean> deleteGapWasteDisposal(@RequestParam("id") Long id) {
        wasteDisposalService.deleteGapWasteDisposal(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得waste_disposal")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:waste-disposal:query')")
    public CommonResult<GapWasteDisposalRespVO> getGapWasteDisposal(@RequestParam("id") Long id) {
        GapWasteDisposalDO entity = wasteDisposalService.getGapWasteDisposal(id);
        return success(BeanUtils.toBean(entity, GapWasteDisposalRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得waste_disposal分页")
    @PreAuthorize("@ss.hasPermission('gap:waste-disposal:query')")
    public CommonResult<PageResult<GapWasteDisposalRespVO>> getGapWasteDisposalPage(@Valid GapWasteDisposalPageReqVO pageReqVO) {
        PageResult<GapWasteDisposalDO> pageResult = wasteDisposalService.getGapWasteDisposalPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapWasteDisposalRespVO.class));
    }
}
