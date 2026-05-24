package cn.iocoder.yudao.module.gap.controller.admin.farming;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordPageReqVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordRespVO;
import cn.iocoder.yudao.module.gap.controller.admin.farming.vo.GapFarmingRecordSaveReqVO;
import cn.iocoder.yudao.module.gap.dal.dataobject.farming.GapFarmingRecordDO;
import cn.iocoder.yudao.module.gap.service.farming.GapFarmingRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "管理后台 - GAP FarmingRecord")
@RestController
@RequestMapping("/gap/farming-record")
@Validated
public class GapFarmingRecordController {

    @Resource
    private GapFarmingRecordService FarmingRecordService;

    @PostMapping("/create")
    @Operation(summary = "创建FarmingRecord")
    @PreAuthorize("@ss.hasPermission('gap:farming-record:create')")
    public CommonResult<Long> createGapFarmingRecord(@Valid @RequestBody GapFarmingRecordSaveReqVO createReqVO) {
        return success(FarmingRecordService.createGapFarmingRecord(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新FarmingRecord")
    @PreAuthorize("@ss.hasPermission('gap:farming-record:update')")
    public CommonResult<Boolean> updateGapFarmingRecord(@Valid @RequestBody GapFarmingRecordSaveReqVO updateReqVO) {
        FarmingRecordService.updateGapFarmingRecord(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除FarmingRecord")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gap:farming-record:delete')")
    public CommonResult<Boolean> deleteGapFarmingRecord(@RequestParam("id") Long id) {
        FarmingRecordService.deleteGapFarmingRecord(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得FarmingRecord")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gap:farming-record:query')")
    public CommonResult<GapFarmingRecordRespVO> getGapFarmingRecord(@RequestParam("id") Long id) {
        GapFarmingRecordDO entity = FarmingRecordService.getGapFarmingRecord(id);
        return success(BeanUtils.toBean(entity, GapFarmingRecordRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得FarmingRecord分页")
    @PreAuthorize("@ss.hasPermission('gap:farming-record:query')")
    public CommonResult<PageResult<GapFarmingRecordRespVO>> getGapFarmingRecordPage(@Valid GapFarmingRecordPageReqVO pageReqVO) {
        PageResult<GapFarmingRecordDO> pageResult = FarmingRecordService.getGapFarmingRecordPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, GapFarmingRecordRespVO.class));
    }
}
