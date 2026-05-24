package cn.iocoder.yudao.module.gap.controller.admin.inspect;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResiduePageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResidueRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.inspect.vo.GapPesticideResidueSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.inspect.GapPesticideResidueDO;
import cn.iocoder.yudao.module.gap.service.inspect.GapPesticideResidueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP PesticideResidue")
@RestController
@RequestMapping("/gap/pesticide-residue")
@Validated
public class GapPesticideResidueController {

    @Resource
    private GapPesticideResidueService PesticideResidueService;

    @PostMapping("/create")
    @Operation(summary = "创建PesticideResidue")
    @PreAuthorize("@ss.hasPermission('gap:pesticide-residue:create')")
    public CommonResult<Long> createGapPesticideResidue(@Valid @RequestBody GapPesticideResidueSaveReqVO createReqVO) {
        return success(PesticideResidueService.createGapPesticideResidue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新PesticideResidue")
    @PreAuthorize("@ss.hasPermission('gap:pesticide-residue:update')")
    public CommonResult<Boolean> updateGapPesticideResidue(@Valid @RequestBody GapPesticideResidueSaveReqVO updateReqVO) {
        PesticideResidueService.updateGapPesticideResidue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除PesticideResidue")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:pesticide-residue:delete')")
    public CommonResult<Boolean> deleteGapPesticideResidue(@RequestParam("id") Long id) {
        PesticideResidueService.deleteGapPesticideResidue(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得PesticideResidue")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:pesticide-residue:query')")
    public CommonResult<GapPesticideResidueRespVO> getGapPesticideResidue(@RequestParam("id") Long id) {
        GapPesticideResidueDO entity = PesticideResidueService.getGapPesticideResidue(id);
        return success(BeanUtils.toBean(entity, GapPesticideResidueRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得PesticideResidue分页")
    @PreAuthorize("@ss.hasPermission('gap:pesticide-residue:query')")
    public CommonResult<PageResult<GapPesticideResidueRespVO>> getGapPesticideResiduePage(@Valid GapPesticideResiduePageReqVO pageReqVO) {
        PageResult<GapPesticideResidueDO> pageResult = PesticideResidueService.getGapPesticideResiduePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPesticideResidueRespVO.class));
    }
}
