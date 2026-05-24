package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapPestControlSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapPestControlDO;
import cn.iocoder.yudao.module.gap.service.farming.GapPestControlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP PestControl")
@RestController
@RequestMapping("/gap/pest-control")
@Validated
public class GapPestControlController {

    @Resource
    private GapPestControlService PestControlService;

    @PostMapping("/create")
    @Operation(summary = "创建PestControl")
    @PreAuthorize("@ss.hasPermission('gap:pest-control:create')")
    public CommonResult<Long> createGapPestControl(@Valid @RequestBody GapPestControlSaveReqVO createReqVO) {
        return success(PestControlService.createGapPestControl(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新PestControl")
    @PreAuthorize("@ss.hasPermission('gap:pest-control:update')")
    public CommonResult<Boolean> updateGapPestControl(@Valid @RequestBody GapPestControlSaveReqVO updateReqVO) {
        PestControlService.updateGapPestControl(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除PestControl")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:pest-control:delete')")
    public CommonResult<Boolean> deleteGapPestControl(@RequestParam("id") Long id) {
        PestControlService.deleteGapPestControl(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得PestControl")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:pest-control:query')")
    public CommonResult<GapPestControlRespVO> getGapPestControl(@RequestParam("id") Long id) {
        GapPestControlDO entity = PestControlService.getGapPestControl(id);
        return success(BeanUtils.toBean(entity, GapPestControlRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得PestControl分页")
    @PreAuthorize("@ss.hasPermission('gap:pest-control:query')")
    public CommonResult<PageResult<GapPestControlRespVO>> getGapPestControlPage(@Valid GapPestControlPageReqVO pageReqVO) {
        PageResult<GapPestControlDO> pageResult = PestControlService.getGapPestControlPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapPestControlRespVO.class));
    }
}
