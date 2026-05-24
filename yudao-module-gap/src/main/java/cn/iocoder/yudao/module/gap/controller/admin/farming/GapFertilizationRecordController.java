package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFertilizationRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFertilizationRecordDO;
import cn.iocoder.yudao.module.gap.service.farming.GapFertilizationRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP FertilizationRecord")
@RestController
@RequestMapping("/gap/fertilization-record")
@Validated
public class GapFertilizationRecordController {

    @Resource
    private GapFertilizationRecordService FertilizationRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建FertilizationRecord")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-record:create')")
    public CommonResult<Long> createGapFertilizationRecord(@Valid @RequestBody GapFertilizationRecordSaveReqVO createReqVO) {
        return success(FertilizationRecordService.createGapFertilizationRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新FertilizationRecord")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-record:update')")
    public CommonResult<Boolean> updateGapFertilizationRecord(@Valid @RequestBody GapFertilizationRecordSaveReqVO updateReqVO) {
        FertilizationRecordService.updateGapFertilizationRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除FertilizationRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:fertilization-record:delete')")
    public CommonResult<Boolean> deleteGapFertilizationRecord(@RequestParam("id") Long id) {
        FertilizationRecordService.deleteGapFertilizationRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得FertilizationRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-record:query')")
    public CommonResult<GapFertilizationRecordRespVO> getGapFertilizationRecord(@RequestParam("id") Long id) {
        GapFertilizationRecordDO entity = FertilizationRecordService.getGapFertilizationRecord(id);
        return success(BeanUtils.toBean(entity, GapFertilizationRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得FertilizationRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:fertilization-record:query')")
    public CommonResult<PageResult<GapFertilizationRecordRespVO>> getGapFertilizationRecordPage(@Valid GapFertilizationRecordPageReqVO pageReqVO) {
        PageResult<GapFertilizationRecordDO> pageResult = FertilizationRecordService.getGapFertilizationRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapFertilizationRecordRespVO.class));
    }
}
