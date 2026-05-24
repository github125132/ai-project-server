package cn.iocoder.yudao.module.gap.controller.admin.process;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapProcessDetailSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapProcessDetailDO;
import cn.iocoder.yudao.module.gap.service.process.GapProcessDetailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP ProcessDetail")
@RestController
@RequestMapping("/gap/process-detail")
@Validated
public class GapProcessDetailController {

    @Resource
    private GapProcessDetailService ProcessDetailService;

    @PostMapping("/create")
    @Operation(summary = "创建ProcessDetail")
    @PreAuthorize("@ss.hasPermission('gap:process-detail:create')")
    public CommonResult<Long> createGapProcessDetail(@Valid @RequestBody GapProcessDetailSaveReqVO createReqVO) {
        return success(ProcessDetailService.createGapProcessDetail(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新ProcessDetail")
    @PreAuthorize("@ss.hasPermission('gap:process-detail:update')")
    public CommonResult<Boolean> updateGapProcessDetail(@Valid @RequestBody GapProcessDetailSaveReqVO updateReqVO) {
        ProcessDetailService.updateGapProcessDetail(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除ProcessDetail")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:process-detail:delete')")
    public CommonResult<Boolean> deleteGapProcessDetail(@RequestParam("id") Long id) {
        ProcessDetailService.deleteGapProcessDetail(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得ProcessDetail")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:process-detail:query')")
    public CommonResult<GapProcessDetailRespVO> getGapProcessDetail(@RequestParam("id") Long id) {
        GapProcessDetailDO entity = ProcessDetailService.getGapProcessDetail(id);
        return success(BeanUtils.toBean(entity, GapProcessDetailRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得ProcessDetail分页")
    @PreAuthorize("@ss.hasPermission('gap:process-detail:query')")
    public CommonResult<PageResult<GapProcessDetailRespVO>> getGapProcessDetailPage(@Valid GapProcessDetailPageReqVO pageReqVO) {
        PageResult<GapProcessDetailDO> pageResult = ProcessDetailService.getGapProcessDetailPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapProcessDetailRespVO.class));
    }
}
