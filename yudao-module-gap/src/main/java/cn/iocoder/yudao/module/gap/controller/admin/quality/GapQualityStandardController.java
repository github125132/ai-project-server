package cn.iocoder.yudao.module.gap.controller.admin.quality;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.quality.vo.GapQualityStandardSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.quality.GapQualityStandardDO;
import cn.iocoder.yudao.module.gap.service.quality.GapQualityStandardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP QualityStandard")
@RestController
@RequestMapping("/gap/quality-standard")
@Validated
public class GapQualityStandardController {

    @Resource
    private GapQualityStandardService QualityStandardService;

    @PostMapping("/create")
    @Operation(summary = "创建QualityStandard")
    @PreAuthorize("@ss.hasPermission('gap:quality-standard:create')")
    public CommonResult<Long> createGapQualityStandard(@Valid @RequestBody GapQualityStandardSaveReqVO createReqVO) {
        return success(QualityStandardService.createGapQualityStandard(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新QualityStandard")
    @PreAuthorize("@ss.hasPermission('gap:quality-standard:update')")
    public CommonResult<Boolean> updateGapQualityStandard(@Valid @RequestBody GapQualityStandardSaveReqVO updateReqVO) {
        QualityStandardService.updateGapQualityStandard(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除QualityStandard")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:quality-standard:delete')")
    public CommonResult<Boolean> deleteGapQualityStandard(@RequestParam("id") Long id) {
        QualityStandardService.deleteGapQualityStandard(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得QualityStandard")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:quality-standard:query')")
    public CommonResult<GapQualityStandardRespVO> getGapQualityStandard(@RequestParam("id") Long id) {
        GapQualityStandardDO entity = QualityStandardService.getGapQualityStandard(id);
        return success(BeanUtils.toBean(entity, GapQualityStandardRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得QualityStandard分页")
    @PreAuthorize("@ss.hasPermission('gap:quality-standard:query')")
    public CommonResult<PageResult<GapQualityStandardRespVO>> getGapQualityStandardPage(@Valid GapQualityStandardPageReqVO pageReqVO) {
        PageResult<GapQualityStandardDO> pageResult = QualityStandardService.getGapQualityStandardPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapQualityStandardRespVO.class));
    }
}
