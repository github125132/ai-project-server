package cn.iocoder.yudao.module.gap.controller.admin.harvest;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.harvest.vo.GapHarvestRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.harvest.GapHarvestRecordDO;
import cn.iocoder.yudao.module.gap.service.harvest.GapHarvestRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP HarvestRecord")
@RestController
@RequestMapping("/gap/harvest-record")
@Validated
public class GapHarvestRecordController {

    @Resource
    private GapHarvestRecordService HarvestRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建HarvestRecord")
    @PreAuthorize("@ss.hasPermission('gap:harvest-record:create')")
    public CommonResult<Long> createGapHarvestRecord(@Valid @RequestBody GapHarvestRecordSaveReqVO createReqVO) {
        return success(HarvestRecordService.createGapHarvestRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新HarvestRecord")
    @PreAuthorize("@ss.hasPermission('gap:harvest-record:update')")
    public CommonResult<Boolean> updateGapHarvestRecord(@Valid @RequestBody GapHarvestRecordSaveReqVO updateReqVO) {
        HarvestRecordService.updateGapHarvestRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除HarvestRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:harvest-record:delete')")
    public CommonResult<Boolean> deleteGapHarvestRecord(@RequestParam("id") Long id) {
        HarvestRecordService.deleteGapHarvestRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得HarvestRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:harvest-record:query')")
    public CommonResult<GapHarvestRecordRespVO> getGapHarvestRecord(@RequestParam("id") Long id) {
        GapHarvestRecordDO entity = HarvestRecordService.getGapHarvestRecord(id);
        return success(BeanUtils.toBean(entity, GapHarvestRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得HarvestRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:harvest-record:query')")
    public CommonResult<PageResult<GapHarvestRecordRespVO>> getGapHarvestRecordPage(@Valid GapHarvestRecordPageReqVO pageReqVO) {
        PageResult<GapHarvestRecordDO> pageResult = HarvestRecordService.getGapHarvestRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapHarvestRecordRespVO.class));
    }
}
