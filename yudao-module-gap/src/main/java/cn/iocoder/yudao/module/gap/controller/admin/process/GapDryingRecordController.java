package cn.iocoder.yudao.module.gap.controller.admin.process;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.process.vo.GapDryingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.process.GapDryingRecordDO;
import cn.iocoder.yudao.module.gap.service.process.GapDryingRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP DryingRecord")
@RestController
@RequestMapping("/gap/drying-record")
@Validated
public class GapDryingRecordController {

    @Resource
    private GapDryingRecordService DryingRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建DryingRecord")
    @PreAuthorize("@ss.hasPermission('gap:drying-record:create')")
    public CommonResult<Long> createGapDryingRecord(@Valid @RequestBody GapDryingRecordSaveReqVO createReqVO) {
        return success(DryingRecordService.createGapDryingRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新DryingRecord")
    @PreAuthorize("@ss.hasPermission('gap:drying-record:update')")
    public CommonResult<Boolean> updateGapDryingRecord(@Valid @RequestBody GapDryingRecordSaveReqVO updateReqVO) {
        DryingRecordService.updateGapDryingRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除DryingRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:drying-record:delete')")
    public CommonResult<Boolean> deleteGapDryingRecord(@RequestParam("id") Long id) {
        DryingRecordService.deleteGapDryingRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得DryingRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:drying-record:query')")
    public CommonResult<GapDryingRecordRespVO> getGapDryingRecord(@RequestParam("id") Long id) {
        GapDryingRecordDO entity = DryingRecordService.getGapDryingRecord(id);
        return success(BeanUtils.toBean(entity, GapDryingRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得DryingRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:drying-record:query')")
    public CommonResult<PageResult<GapDryingRecordRespVO>> getGapDryingRecordPage(@Valid GapDryingRecordPageReqVO pageReqVO) {
        PageResult<GapDryingRecordDO> pageResult = DryingRecordService.getGapDryingRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapDryingRecordRespVO.class));
    }
}
